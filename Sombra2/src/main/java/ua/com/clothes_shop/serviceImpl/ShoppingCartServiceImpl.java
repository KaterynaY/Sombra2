package ua.com.clothes_shop.serviceImpl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.clothes_shop.dao.ShoppingCartDao;
import ua.com.clothes_shop.entity.ItemOfClothing;
import ua.com.clothes_shop.entity.Quantity;
import ua.com.clothes_shop.entity.ShoppingCart;
import ua.com.clothes_shop.service.QuantityService;
import ua.com.clothes_shop.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Autowired
	private QuantityService quantityService;

	@Override
	public void save(ShoppingCart shoppingCart) {
		shoppingCartDao.save(shoppingCart);
	}

	@Override
	public List<ShoppingCart> findAll() {
		return shoppingCartDao.findAll();
	}
	
	@Override
	public ShoppingCart findById(int id) {
		return shoppingCartDao.findById(id);
	}

	@Override
	public ShoppingCart findOne(int id) {
		ShoppingCart cart = shoppingCartDao.findById(id);
		if(cart.getCount()==0){
			return cart;
		}
		return shoppingCartDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		shoppingCartDao.delete(id);
	}

	@Override
	public void update(ShoppingCart shoppingCart) {
		shoppingCartDao.save(shoppingCart);
	}

	@Override
	public void deleteItem(int cartId, int itemId) {
		ShoppingCart cart = shoppingCartDao.findOne(cartId);
		List<ItemOfClothing> list = cart.getItemsOfClothing();
		Iterator<ItemOfClothing> iter = list.iterator();
		Quantity quantity = quantityService.findByCartAndItemIDs(itemId, cartId);
		int count = quantity.getQuantity();
		while (iter.hasNext()){ 
			ItemOfClothing itemOfClothing = iter.next();
			if(itemOfClothing.getId() == itemId){
				iter.remove();
				cart.setCount(cart.getCount()-count);
			}
		}
		shoppingCartDao.save(cart);
		quantity = quantityService.findByCartAndItemIDs(itemId, cartId);
		quantityService.delete(quantity.getId());
	}

	@Override
	public BigDecimal price(ShoppingCart shoppingCart) {
		BigDecimal totalPrice = new BigDecimal("0");
		List<ItemOfClothing> list = shoppingCart.getItemsOfClothing();
		if(list.isEmpty()){
			return totalPrice;
		}
		for(ItemOfClothing itemOfClothing : list){
			Quantity quantity = quantityService.findByCartAndItemIDs(itemOfClothing.getId(), shoppingCart.getId());
			int count = quantity.getQuantity();
			totalPrice = totalPrice.add(itemOfClothing.getPrice().multiply(new BigDecimal(count)));
			}
		return totalPrice;
	}

	@Override
	public int getQuantity(int cartId, int itemId) {
		Quantity quantity = quantityService.findByCartAndItemIDs(itemId, cartId);
		return quantity.getQuantity();
	}

	@Override
	public void reduce(int cartId, int itemId) {
		ShoppingCart cart = shoppingCartDao.findOne(cartId);
		List<ItemOfClothing> list = cart.getItemsOfClothing();
		for (ItemOfClothing itemOfClothing: list){ 
			if(itemOfClothing.getId() == itemId && cart.getCount()>list.size()){
				cart.setCount(cart.getCount()-1);
			}
		}
		shoppingCartDao.save(cart);
		Quantity quantity = quantityService.findByCartAndItemIDs(itemId, cartId);
		if (quantity.getQuantity()>1){
			quantity.setQuantity(quantity.getQuantity()-1);
		}
		quantityService.save(quantity);
	}

	@Override
	public void increase(int cartId, int itemId) {
		ShoppingCart cart = shoppingCartDao.findOne(cartId);
		List<ItemOfClothing> list = cart.getItemsOfClothing();
		for (ItemOfClothing itemOfClothing: list){ 
			if(itemOfClothing.getId() == itemId){
				cart.setCount(cart.getCount()+1);
			}
		}
		shoppingCartDao.save(cart);
		Quantity quantity = quantityService.findByCartAndItemIDs(itemId, cartId);
		quantity.setQuantity(quantity.getQuantity()+1);
		quantityService.save(quantity);
	}



}
