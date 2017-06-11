package ua.com.clothes_shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.clothes_shop.dao.OrdersDao;
import ua.com.clothes_shop.entity.Orders;
import ua.com.clothes_shop.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void save(Orders orders) {
		ordersDao.save(orders);
	}

	@Override
	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	@Override
	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		ordersDao.delete(id);
	}

	@Override
	public void update(Orders orders) {
		ordersDao.save(orders);
	}

}
