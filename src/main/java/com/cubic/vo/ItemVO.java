package com.cubic.vo;


public class ItemVO {
	private Long id;
	private String itemName;
	private int quantity;
	private int itemPrice;
	private int cartquantity;
	
	public int getCartquantity() {
		return cartquantity;
	}


	public void setCartquantity(int cartquantity) {
		this.cartquantity = cartquantity;
	}


	public ItemVO() {
		super();
	}


	public ItemVO(int i, String itemName,int quantity,int itemPrice) {
		super();
		this.id = (long) i;
		this.itemName = itemName;
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	


	@Override
	public String toString() {
		return "ItemVO [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + ", itemPrice=" + itemPrice
				+ "]";
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
