package com.project.demo.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
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
	private int monthDeosit;
	private int yearDeosit;
	
	private Integer account;
	
	private double amount;

	public Deposit() {

	}



	public Deposit(Long id, int dataDeosit, int monthDeosit, int yearDeosit, Integer account, double amount) {
		super();
		this.id = id;
		this.dataDeosit = dataDeosit;
		this.monthDeosit = monthDeosit;
		this.yearDeosit = yearDeosit;
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

	public int getMonthDeosit() {
		return monthDeosit;
	}

	public void setMonthDeosit(int monthDeosit) {
		this.monthDeosit = monthDeosit;
	}

	public int getYearDeosit() {
		return yearDeosit;
	}

	public void setYearDeosit(int yearDeosit) {
		this.yearDeosit = yearDeosit;
	}
	
	
	public int getTotalDataDeposit() {
		int data = getDataDeosit();
		int month = getMonthDeosit();
		int year = getYearDeosit();
		
		return (data+month)+year;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		
		double total = 0;
		
		if(amount <= 1000) {
			total = typeTaxa(1, amount);
		}
		else if(1000 < amount && amount <= 2000) {
			total = typeTaxa(2, amount);
		}
		else if(2000 < amount){
			total = typeTaxa(3, amount);
		}

		this.amount = total;
	}
	
	
	public double typeTaxa(int type, double amount) {
		int dataDeposit = getTotalDataDeposit();

		Instant now = Instant.now();
		
		String date = now.toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date d = Date.from(Instant.parse(date));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);

		int day = cal.get(Calendar.DATE);
		int month = 1 + cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int today = day + month + year;
		
		
		if(type == 1) {
			
			if(today == dataDeposit) {
				Double aux = amount;
				
				aux = aux*3;
				aux = (aux/100);
				amount = (amount-3)-aux;
				
				System.out.println(amount);
				System.out.println(amount);
			}else {
				System.out.println("data invalida");
				System.out.println("data invalida");
			}
	
		}
		if(type == 2) {
			Double aux = amount;
			
			aux = aux*3;
			aux = (aux/100);
			amount = (amount-3)-aux;
		}
		if(type == 3) {

			if (today < dataDeposit && dataDeposit < (today+10)) {
				amount = 11;
			}
			else if ((today+10) < dataDeposit && dataDeposit <= (today+20)) {
				amount = 12;
			}
			else if ((today+20) < dataDeposit && dataDeposit <= (today+30)) {
				amount = 13;
			}
			else if ((today+30) < dataDeposit && dataDeposit <= (today+40)) {
				amount = 14;
			}
			else if ((today+10) < dataDeposit) {
				
			}
			
		}
		else if(type > 3){
			
		}
			
		return amount;
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
