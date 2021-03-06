package com.project.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.demo.entities.enums.DepositStatus;

@Entity
@Table(name = "tb_deposits")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int dayDeposit;
	private int monthDeposit;
	private int yearDeposit;

	private LocalDate dataDeposit;

	private LocalDate dataNow = LocalDate.now();

	private Integer depositStatus;
	private Integer account;
	private float amount;

	public Deposit() {

	}

	public Deposit(Long id, int dayDeposit, int monthDeposit, int yearDeposit, Integer account, float amount) {
		super();
		this.id = id;
		this.dayDeposit = dayDeposit;
		this.monthDeposit = monthDeposit;
		this.yearDeposit = yearDeposit;
		this.dataNow = LocalDate.now();
		this.account = account;
		this.amount = amount;
		setDataDeposit(LocalDate.of(yearDeposit, monthDeposit, dayDeposit));
		setDepositStatus(DepositStatus.Erro);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDayDeposit() {
		return dayDeposit;
	}

	public void setDayDeposit(int dayDeposit) {
		this.dayDeposit = dayDeposit;
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

	public LocalDate getDataDeposit() {
		return dataDeposit;
	}

	public void setDataDeposit(LocalDate datadeposit) {
		this.dataDeposit = datadeposit;
	}

	public LocalDate getDataNow() {
		return dataNow;
	}

	public void setDataNow(LocalDate dataNow) {
		this.dataNow = LocalDate.now();
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {

		float total = 0;

		if (0 < amount && amount <= 1000) {
			total = typeTaxa(1, amount);
		}
		if (1000 < amount && amount <= 2000) {
			total = typeTaxa(2, amount);
		}
		if (2000 < amount) {
			total = typeTaxa(3, amount);
		}

		this.amount = total;
	}

	public float typeTaxa(int type, float amount) {

		float response = (float) 0.0;
		float aux = amount;
		boolean alertDeposit = false;

		LocalDate datadeposit = LocalDate.of(getYearDeposit(), getMonthDeposit(), getDayDeposit());

		
		setDataDeposit(datadeposit);

		int comparData = datadeposit.compareTo(getDataNow());

		if (type == 1) {

			if (0 <= comparData && amount <= 1000) {

				aux = aux * 3;
				aux = (aux / 100);
				response = (amount - 3) - aux;

				alertDeposit = true;

			} else {
				amount = 0;

			}

		}
		if (type == 2) {

			aux = aux * 3;
			aux = (aux / 100);
			response = (amount - 3) - aux;

			alertDeposit = true;

		}
		if (type == 3) {

			if (10 < comparData && comparData <= 20) {

				aux = (float) (aux * 8.2);
				aux = (aux / 100);
				response = amount - aux;

				alertDeposit = true;

			}

			else if (20 < comparData && comparData <= 30) {

				aux = (float) (aux * 6.9);
				aux = (aux / 100);
				response = amount - aux;

				alertDeposit = true;

			} else if (30 < comparData && comparData <= 40) {

				aux = (float) (aux * 4.7);
				aux = (aux / 100);
				response = amount - aux;

				alertDeposit = true;

			} else if (40 < comparData) {

				aux = (float) (aux * 1.7);
				aux = (aux / 100);
				response = amount - aux;

				alertDeposit = true;

			}

		}

		if (alertDeposit == false) {
			setDepositStatus(DepositStatus.Erro);

		} else if (alertDeposit == true) {
			setDepositStatus(DepositStatus.Agendado);
		}

		return response;
	}

	public DepositStatus getDepositStatus() {
		return DepositStatus.valueOf(depositStatus);
	}

	public void setDepositStatus(DepositStatus depositStatus) {
		if (depositStatus != null) {
			this.depositStatus = depositStatus.getCode();
		}
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
