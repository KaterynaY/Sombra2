package ua.com.clothes_shop.entity;

public class NumberOfItems {
	
	ItemOfClothing itemOfClothing;
	
	int quantity;
	
	int cartId;

	public NumberOfItems(ItemOfClothing itemOfClothing, int quantity, int cartId) {
		super();
		this.itemOfClothing = itemOfClothing;
		this.quantity = quantity;
		this.cartId = cartId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public ItemOfClothing getItemOfClothing() {
		return itemOfClothing;
	}

	public void setItemOfClothing(ItemOfClothing itemOfClothing) {
		this.itemOfClothing = itemOfClothing;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
