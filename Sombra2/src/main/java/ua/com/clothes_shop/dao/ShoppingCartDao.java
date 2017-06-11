package ua.com.clothes_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.clothes_shop.entity.ShoppingCart;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer>{
	
	@Query("SELECT DISTINCT shc FROM ShoppingCart shc JOIN FETCH shc.itemsOfClothing WHERE shc.id=?1")
	ShoppingCart findOne(int id);
	
	ShoppingCart findById(int id);

}
