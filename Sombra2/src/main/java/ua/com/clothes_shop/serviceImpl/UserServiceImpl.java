package ua.com.clothes_shop.serviceImpl;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.clothes_shop.dao.ItemOfClothingDao;
import ua.com.clothes_shop.dao.ShoppingCartDao;
import ua.com.clothes_shop.dao.UserDao;
import ua.com.clothes_shop.entity.ItemOfClothing;
import ua.com.clothes_shop.entity.Quantity;
import ua.com.clothes_shop.entity.Role;
import ua.com.clothes_shop.entity.ShoppingCart;
import ua.com.clothes_shop.entity.User;
import ua.com.clothes_shop.service.QuantityService;
import ua.com.clothes_shop.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService,UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Autowired
	private ItemOfClothingDao itemOfClothingDao;
	
	@Autowired
	private QuantityService quantityService;

	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCartDao.save(shoppingCart);
		user.setShoppingCart(shoppingCart);
		userDao.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.findByEmail(username);
	}
	
	@PostConstruct
	public void addAdmin(){
		User user = userDao.findByEmail("admin");
		if(user==null){
			user = new User();
			user.setEmail("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			userDao.save(user);
		}
	}

//	@Override
//	public int createNewUser() {
//		return userDao.saveAndFlush(new User()).getId();
//	}
	@Override
	public int createNewUser() {
		User user = new User();
		user.setEmail("unknown");
		user.setName("unknown");
		user.setPassword("unknown");
		user.setPhoneNumber("000");
		userDao.saveAndFlush(user);
		return user.getId();
	}

	@Override
	@Transactional
	public void addToShoppingCart(int userId, int itemId) {
		User user = userDao.findOne(userId);
		if(user == null){
			createNewUser();
		}
		ShoppingCart cart = user.getShoppingCart();
		if(cart==null){
			cart = shoppingCartDao.save(new ShoppingCart());
			user.setShoppingCart(cart);
		}
		ItemOfClothing itemOfClothing = itemOfClothingDao.findOne(itemId);
		cart.add(itemOfClothing);
		Quantity quantity = quantityService.findByCartAndItemIDs(itemOfClothing.getId(), cart.getId());
		if (quantity==null){
			quantity = new Quantity();
			quantityService.save(quantity);
		}
		quantity.setItemId(itemOfClothing.getId());
		quantity.setCartId(cart.getId());
		quantity.setQuantity(quantity.getQuantity()+1);
		quantityService.save(quantity);

	}

	@Override
	public int findShoppingCart(String email) {
		User user = userDao.findByEmail(email);
		if (user.getShoppingCart() == null){
			return 0;
		}else return user.getShoppingCart().getId();
	}
	
//	@Scheduled(fixedDelay=500)
//	public void task(){
//		System.out.println("Hello");
//	}
	
	@Override
	public void sendMail(String content, String email, String mailBody) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
		new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("grace.brand.shop@gmail.com", "graceshop2017");
		}
		});
		try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("grace.brand.shop@gmail.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
		email));
		message.setSubject(content, "UTF-8");
		message.setText(mailBody);
		Transport.send(message);
		} catch (MessagingException å) {
		å.printStackTrace();
		}
		}
}