package com.project.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_deposit")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private int dataDeosit;	
	private Integer account;
	private double amount;

	public Deposit() {

	}



	public Deposit(Long id, int dataDeosit, Integer account, double amount) {
		super();
		this.id = id;
		this.dataDeosit = dataDeosit;
		this.account = account;
		setAmount(amount);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}
	
	public int getDataDeosit() {
		return dataDeosit;
	}

	public void setDataDeosit(int dataDeosit) {
		this.dataDeosit = dataDeosit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		
		double total = 0;
		
		if(amount <= 1000 ) {
			total = typeTaxa(1, amount);
		}
		if(1000 < amount && amount <= 2000) {
			total = typeTaxa(2, amount);
		}
		if(2000 < amount){
			total = typeTaxa(3, amount);
		}
		else {
			System.out.println("data invalida");
		}

		this.amount = total;
	}
	
	public double typeTaxa(int type, double amount) {
		
		int dataDeposit = getDataDeosit();
		int statusDeposito = 0;
		Double response = 0.0;
		
		if(type == 1) {
			
			if(0 == dataDeposit) {
				Double aux = amount;
				
				aux = aux*3;
				aux = (aux/100);
				response = (amount-3)-aux;
				statusDeposito = 1;
			}
			
			if(0 < dataDeposit) {
				type = 3;
			}
			else {
				statusDeposito = 2;
				System.out.println("data invalida");
			}
	
		}
		if(type == 2) {
			Double aux = amount;
			
			aux = aux*3;
			aux = (aux/100);
			response = (amount-3)-aux;
			
			statusDeposito = 1;
		}
		if(type == 3) {

			if (10 < dataDeposit && dataDeposit <= 20) {
				Double aux = amount;
				
				aux = aux*8.2;
				aux = (aux/100);
				response = amount-aux;
				
				statusDeposito = 1;
			}
			else if (20 < dataDeposit && dataDeposit <= 30) {
				Double aux = amount;
				
				aux = aux*6.9;
				aux = (aux/100);
				response = amount-aux;
				
				statusDeposito = 1;
			}
			else if (30 < dataDeposit && dataDeposit <= 40) {
				Double aux = amount;
				
				aux = aux*4.7;
				aux = (aux/100);
				response = amount-aux;
				
				statusDeposito = 1;
			}
			else if (40 < dataDeposit) {
				Double aux = amount;
				
				aux = aux*1.7;
				aux = (aux/100);
				response = amount-aux;
				
				statusDeposito = 1;
			}
			else {
				statusDeposito = 2;
				System.out.println("NAO FOI POSSIVEL ENCONTRA UMA TAXA PARA ESTA DATA E VALOR");
			}
		}
		else if(type > 3){
			statusDeposito = 2;
			System.out.println("NAO FOI POSSIVEL ENCONTRA UMA TAXA PARA ESTA DATA E VALOR");
		}
			
		return response;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposit other = (Deposit) obj;
		return Objects.equals(id, other.id);
	}

}
