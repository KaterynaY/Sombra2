package ua.com.clothes_shop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private String address;
	
	@ManyToMany
	@JoinTable(name="item_orders_connection",
	joinColumns=@JoinColumn(name="id_orders"),
	inverseJoinColumns=@JoinColumn(name="id_item_of_clothing"))
	private List<ItemOfClothing> itemsOfClothing = new ArrayList<>();
	
	private int quantity;
	private BigDecimal totalPrice;
	private boolean isAccepted;
	@ManyToOne
	private ShoppingCart shoppingCart;
	
	public Orders() {
		
	}

	public Orders(String name) {
		super();
		this.name = name;
	}

	public Orders(String name, String surname, String phoneNumber,
			String email, String address, int quantity, BigDecimal totalPrice,
			boolean isAccepted) {
		super();
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.isAccepted = isAccepted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ItemOfClothing> getItemsOfClothing() {
		return itemsOfClothing;
	}

	public void setItemsOfClothing(List<ItemOfClothing> itemsOfClothing) {
		this.itemsOfClothing = itemsOfClothing;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	

}
