package ua.com.clothes_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.clothes_shop.entity.Quantity;

public interface QuantityDao  extends JpaRepository<Quantity, Integer>{

}
