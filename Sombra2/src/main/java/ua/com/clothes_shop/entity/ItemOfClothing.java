package ua.com.clothes_shop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="item_of_clothing")
public class ItemOfClothing {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="marking")
		private int marking;
		
		@Column(name="price")
		private BigDecimal price;
		
		private int version; 
				
		public int getVersion() {
		   return version;
		}
		public void setVersion(int version) {
		   this.version = version;
		}
		
		@ManyToOne
		private ItemName itemName;
		
		@ManyToOne
		private TargetAudience targetAudience;
		
		@ManyToOne
		private TypeOfClothing typeOfClothing;
		
		@ManyToOne
		private Brand brand;
		
		@ManyToOne
		private Color color;
		
		@ManyToOne
		private Size size;
		
		@ManyToMany
		@JoinTable(name="item_cart_connection",
		joinColumns=@JoinColumn(name="id_item_of_clothing"),
		inverseJoinColumns=@JoinColumn(name="id_shopping_cart"))
		private List<ShoppingCart> shoppingCarts = new ArrayList<>();
		
		@ManyToMany
		@JoinTable(name="item_orders_connection",
		joinColumns=@JoinColumn(name="id_item_of_clothing"),
		inverseJoinColumns=@JoinColumn(name="id_orders"))
		private List<Orders> orderss = new ArrayList<>();
		
		public List<Orders> getOrderss() {
			return orderss;
		}
		public void setOrderss(List<Orders> orderss) {
			this.orderss = orderss;
		}
		public List<ShoppingCart> getShoppingCarts() {
			return shoppingCarts;
		}

		public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
			this.shoppingCarts = shoppingCarts;
		}

		public ItemOfClothing() {
			// TODO Auto-generated constructor stub
		}

		public ItemOfClothing(int marking, BigDecimal price) {
			super();
			this.marking = marking;
			this.price = price;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getMarking() {
			return marking;
		}

		public void setMarking(int marking) {
			this.marking = marking;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public TargetAudience getTargetAudience() {
			return targetAudience;
		}

		public void setTargetAudience(TargetAudience targetAudience) {
			this.targetAudience = targetAudience;
		}

		public TypeOfClothing getTypeOfClothing() {
			return typeOfClothing;
		}

		public void setTypeOfClothing(TypeOfClothing typeOfClothing) {
			this.typeOfClothing = typeOfClothing;
		}

		public Brand getBrand() {
			return brand;
		}

		public void setBrand(Brand brand) {
			this.brand = brand;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public Size getSize() {
			return size;
		}

		public void setSize(Size size) {
			this.size = size;
		}

		public ItemName getItemName() {
			return itemName;
		}

		public void setItemName(ItemName itemName) {
			this.itemName = itemName;
		}

		@Override
		public String toString() {
			return "ItemOfClothing [id=" + id + ", marking=" + marking
					+ ", price=" + price + "]";
		}
		

}
