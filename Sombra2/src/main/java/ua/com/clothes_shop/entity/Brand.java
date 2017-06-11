package ua.com.clothes_shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brand", indexes=@Index(columnList = "brand_name"))
public class Brand {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(name="brand_name")
		private String brandName;
		
		@OneToMany(mappedBy="brand")
		private List<ItemOfClothing> itemsOfClothing = new ArrayList<>();
		
		public Brand() {
			// TODO Auto-generated constructor stub
		}

		public Brand(String brandName) {
			super();
			this.brandName = brandName;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public List<ItemOfClothing> getItemsOfClothing() {
			return itemsOfClothing;
		}

		public void setItemsOfClothing(List<ItemOfClothing> itemsOfClothing) {
			this.itemsOfClothing = itemsOfClothing;
		}

		@Override
		public String toString() {
			return "Brand [id=" + id + ", brandName=" + brandName + "]";
		}

}
