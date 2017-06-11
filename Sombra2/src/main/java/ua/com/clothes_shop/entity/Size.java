package ua.com.clothes_shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="size")
public class Size {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="size")
	private String size;
	
	@OneToMany(mappedBy="size")
	private List<ItemOfClothing> itemsOfClothing = new ArrayList<>();
	
	public Size() {
		// TODO Auto-generated constructor stub
	}

	public Size(String size) {
		super();
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<ItemOfClothing> getItemsOfClothing() {
		return itemsOfClothing;
	}

	public void setItemsOfClothing(List<ItemOfClothing> itemsOfClothing) {
		this.itemsOfClothing = itemsOfClothing;
	}

	@Override
	public String toString() {
		return "Size [id=" + id + ", size=" + size + "]";
	}

}
