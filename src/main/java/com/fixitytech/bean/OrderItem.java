package com.fixitytech.bean;

public class OrderItem extends Cart{
	
	int orderId;
	int status;
	double totalAmt;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId=orderId;
		
	}
	public void setStatus(int status) {
			this.status=status;
	}
	public int getStatus() {
		return status;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt=totalAmt;
		
	}


	

	

	
}
