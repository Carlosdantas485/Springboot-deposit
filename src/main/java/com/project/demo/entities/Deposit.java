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
	
	private int account;
	private Double balance;
	private int dataDeposit;
	private int monthDeposit;
	private int yearDeposit;
	
	public Deposit() {

	}

	public Deposit(Long id, int account, Double balance, int dataDeposit, int monthDeposit, int yearDeposit) {
		super();
		this.id = id;
		this.account = account;
		this.balance = balance;
		this.dataDeposit = dataDeposit;
		this.monthDeposit =monthDeposit;
		this.yearDeposit = yearDeposit;
	
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getAccount() {
		return account;
	}


	public void setAccount(int account) {
		this.account = account;
	}


	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getDataDeposit() {
		return dataDeposit;
	}

	public void setDataDeposit(int dataDeposit) {
		this.dataDeposit = dataDeposit;
	}

	public int getMonthDeposit() {
		return monthDeposit;
	}

	public void setMonthDeposit(int monthDeposit) {
		this.monthDeposit = monthDeposit;
	}	

	public int getYearDeposit() {
		return yearDeposit;
	}

	public void setYearDeposit(int yearDeposit) {
		this.yearDeposit = yearDeposit;
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
