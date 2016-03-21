package com.cubic.vo;

import java.util.HashMap;
import java.util.Iterator;

public class CartVO {

private ItemVO item;
private int quantity;
public CartVO(){
	
}
public CartVO(ItemVO item, int quantity) {
	super();
	this.item = item;
	this.quantity = quantity;
}
public ItemVO getItem() {
	return item;
}
public void setItem(ItemVO item) {
	this.item = item;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}