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
//import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="color")
public class Color {
	
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int id;
			@Column(name="color")
			private String color;
			
			@OneToMany(mappedBy="color")
			private List<ItemOfClothing> itemsOfClothing = new ArrayList<>();
			
			private int version;
			@Transient 
			private MultipartFile file;
			
			public int getVersion() {
				return version;
			}
			public void setVersion(int version) {
				this.version = version;
			}
			public MultipartFile getFile() {
				return file;
			}
			public void setFile(MultipartFile file) {
				this.file = file;
			}
			
			public Color() {
				// TODO Auto-generated constructor stub
			}

			public Color(String color) {
				super();
				this.color = color;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getColor() {
				return color;
			}

			public void setColor(String color) {
				this.color = color;
			}

			public List<ItemOfClothing> getItemsOfClothing() {
				return itemsOfClothing;
			}

			public void setItemsOfClothing(List<ItemOfClothing> itemsOfClothing) {
				this.itemsOfClothing = itemsOfClothing;
			}

			@Override
			public String toString() {
				return "Color [id=" + id + ", color=" + color + "]";
			}
			

			
			

}
