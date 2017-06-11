package ua.com.clothes_shop.service;

import java.math.BigDecimal;
import java.util.List;

import ua.com.clothes_shop.entity.ShoppingCart;

public interface ShoppingCartService {
	
    void save(ShoppingCart shoppingCart);
	
	List<ShoppingCart> findAll();
	
	ShoppingCart findOne(int id);
	
	ShoppingCart findById(int id);
	
	void deleteItem (int cartId, int itemId);
	
	void reduce (int cartId, int itemId);
	
	void increase (int cartId, int itemId);
	
	void delete(int id);
	
	void update (ShoppingCart shoppingCart);
	
	BigDecimal price (ShoppingCart shoppingCart);
	
	int getQuantity (int cartId, int itemId);

}
