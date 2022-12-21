package com.fixitytech.bean;

public class Cart extends Item {
	
	int quantity;
	
	
	public double getSubAmt() {
		return quantity*price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void addQuantitiy()
	{
		quantity++;
	}
	
	
}
