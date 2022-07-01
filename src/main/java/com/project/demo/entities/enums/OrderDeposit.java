package com.project.demo.entities.enums;

public enum OrderDeposit {
	WAITING_PAYMANT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderDeposit(int code) {
		this.code = code;
	}
	
	public int getBalance() {
		return code;
	}
	
	public static OrderDeposit valueOf(int code) {
		for(OrderDeposit value : OrderDeposit.values()) {
			if (value.getBalance() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("INVALID ORDER STATUS CODE");
	}
}
