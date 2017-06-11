package ua.com.clothes_shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item_name")
public class ItemName {
	
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int id;
			@Column(name="_name")
			private String name;
			
			@OneToMany(mappedBy="itemName")
			private List<ItemOfClothing> itemsOfClothing = new ArrayList<>();
			
			public ItemName() {
				// TODO Auto-generated constructor stub
			}


			public ItemName(String name) {
				super();
				this.name = name;
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


			public List<ItemOfClothing> getItemsOfClothing() {
				return itemsOfClothing;
			}


			public void setItemsOfClothing(List<ItemOfClothing> itemsOfClothing) {
				this.itemsOfClothing = itemsOfClothing;
			}


			@Override
			public String toString() {
				return "ItemName [id=" + id + ", name=" + name + "]";
			}

}
