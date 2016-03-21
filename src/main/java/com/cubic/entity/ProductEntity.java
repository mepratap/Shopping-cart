package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
@NamedNativeQuery(name = "ProductEntity.findAll", query = "select * from PRODUCT", resultClass = ProductEntity.class)
public class ProductEntity {
	
	@Id
	@Column(name="PRODUCT_ID")
	private Long pk;
	
	@Column(name="PRODUCT_NAME")
	private String itemName;
	
	@Column(name="PRODUCT_QUANTITY")
	private int quantity;
	
	@Column(name="PRODUCT_PRICE")
	private int price;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductEntity [pk=" + pk + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	

}
