package ua.com.clothes_shop.service;

import java.util.List;

import ua.com.clothes_shop.entity.Orders;

public interface OrdersService {
	
	void save(Orders orders);
	
	List<Orders> findAll();
	
	Orders findOne(int id);
	
	void delete(int id);
	
	void update (Orders orders);

}
