package ua.com.clothes_shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.clothes_shop.dao.QuantityDao;
import ua.com.clothes_shop.entity.Quantity;
import ua.com.clothes_shop.service.QuantityService;

@Service
public class QuantityServiceImpl implements QuantityService{
	
	@Autowired
	private QuantityDao quantityDao;

	@Override
	public void save(Quantity quantity) {
		quantityDao.save(quantity);
	}

	@Override
	public List<Quantity> findAll() {
		return quantityDao.findAll();
	}

	@Override
	public Quantity findOne(int id) {		
		return quantityDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		quantityDao.delete(id);
	}

	@Override
	public Quantity findByCartAndItemIDs(int itemId, int cartId) {
		List<Quantity> list = quantityDao.findAll();
		for (Quantity quantity:list){
			if (quantity.getCartId()== cartId && quantity.getItemId()==itemId){
				return quantity;
			}
		}
		return null;
	}

}
