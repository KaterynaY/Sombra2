package ua.com.clothes_shop.controller.user;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.clothes_shop.entity.Mail;
import ua.com.clothes_shop.entity.TypeOfClothing;
import ua.com.clothes_shop.entity.User;
import ua.com.clothes_shop.service.TypeOfClothingService;
import ua.com.clothes_shop.service.UserService;
import ua.com.clothes_shop.validator.UserValidator;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TypeOfClothingService typeOfClothingService;
	
	@RequestMapping("/")
	public String index(Model model, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		try{
			model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));		
			model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));}
		catch(Exception e){}
		
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		return "user-index";
	}
           
	@RequestMapping("/admin")
	public String admin(Model model){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		return "redirect:/admin/itemName";
	}
	
	@GetMapping("/registration")
	public String registration(Model model, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@InitBinder("user")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new UserValidator(userService));
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user") @Valid User user,  BindingResult br, Model model, SessionStatus status, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		if(br.hasErrors()) return "user-registration";
		userService.save(user);
		status.setComplete();
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Model model, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		try{
			model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));		
			model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));}
		catch(Exception e){}
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		return "user-login";
	}
	
	@GetMapping("/sale")
	public String sale(Model model, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		return "user-sale";
	}
	
	@GetMapping("/customerCare")
	public String care(Model model, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		return "user-customerCare";
	}
	
	@GetMapping("/women")
	public String women(Model model){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		List<TypeOfClothing> list = typeOfClothingService.findByTargetAudience("women");
		TypeOfClothing typeOfClothing = list.get(0);
		String itemType = typeOfClothing.getItemType();
		model.addAttribute("itemType", itemType);
		return "redirect:/shopWomen/{itemType}";
	}
	
	@GetMapping("/men")
	public String men(Model model){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		List<TypeOfClothing> list = typeOfClothingService.findByTargetAudience("men");
		TypeOfClothing typeOfClothing = list.get(0);
		String itemType = typeOfClothing.getItemType();
		model.addAttribute("itemType", itemType);
		return "redirect:/shopMen/{itemType}";
	}
	
	@GetMapping("/confirm")
	public String confirm(Model model, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		return "user-thanks";
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute("mail") Mail mail,  BindingResult br, Model model, SessionStatus status, Principal principal){
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		String adr = mail.getMail();
		userService.sendMail("Grace Subscribe", adr, "Thanks for subscribing. You'll first receive our up-to-date fashion news");
		return "redirect:/";
	}
	
}
