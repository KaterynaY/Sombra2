package ua.com.clothes_shop.service;

import java.util.List;

import ua.com.clothes_shop.entity.Quantity;

public interface QuantityService {
	
    void save(Quantity quantity);
	
	List<Quantity> findAll();
	
	Quantity findOne(int id);
	
	void delete(int id);
	
	Quantity findByCartAndItemIDs(int itemId, int cartId);

}
