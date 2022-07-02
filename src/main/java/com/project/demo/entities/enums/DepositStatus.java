package com.project.demo.entities.enums;

public enum DepositStatus {
	Agendado(1),
	Taxa_Nao_encontrada(2);

	private int code;
	
	private DepositStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static DepositStatus valueOf(int code) {
		for(DepositStatus value : DepositStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("INVALID ORDER STATUS CODE");
	}
}
