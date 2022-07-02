package com.project.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.demo.entities.enums.DepositStatus;

@Entity
@Table(name = "tb_deposit")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int dataDeposit;
	private Integer account;
	private float amount;

	private Integer depositStatus;

	public Deposit() {

	}

	public Deposit(Long id, int dataDeposit, DepositStatus depositStatus, Integer account, float amount) {
		super();
		this.id = id;
		this.dataDeposit = dataDeposit;
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

	public int getDataDeposit() {
		return dataDeposit;
	}

	public void setDataDeposit(int dataDeposit) {
		this.dataDeposit = dataDeposit;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		
		float total = 0;

		if (0 < amount && amount <= 1000) {
			total = typeTaxa(1, amount);
		}
		else if (1000 < amount && amount <= 2000) {
			total = typeTaxa(2, amount);
		}
		else if (2000 < amount) {
			total = typeTaxa(3, amount);
		} else if ( valueOf(amount) == null || amount < 0) {
			amount = 0;
			setDepositStatus(DepositStatus.Taxa_Nao_encontrada);
		}

		this.amount = total;
	}

	private Object valueOf(float amount2) {
		return null;
	}

	public float typeTaxa(int type, float amount) {

		int dataDeposit = getDataDeposit();
		float response = (float) 0.0;
		float aux = amount;
		if (type == 1) {

			if (0 == dataDeposit || amount <= 1000) {

				aux = aux * 3;
				aux = (aux / 100);
				response = (amount - 3) - aux;
				setDepositStatus(DepositStatus.Agendado);

			} else {
				amount = 0;
				setDepositStatus(DepositStatus.Taxa_Nao_encontrada);
			}

		}
		if (type == 2) {

			aux = aux * 3;
			aux = (aux / 100);
			response = (amount - 3) - aux;

			setDepositStatus(DepositStatus.Agendado);
		}
		if (type == 3) {

			if (10 < dataDeposit && dataDeposit <= 20) {

				aux = (float) (aux * 8.2);
				aux = (aux / 100);
				response = amount - aux;

				setDepositStatus(DepositStatus.Agendado);
			} else if (20 < dataDeposit && dataDeposit <= 30) {

				aux = (float) (aux * 6.9);
				aux = (aux / 100);
				response = amount - aux;

				setDepositStatus(DepositStatus.Agendado);
			} else if (30 < dataDeposit && dataDeposit <= 40) {

				aux = (float) (aux * 4.7);
				aux = (aux / 100);
				response = amount - aux;

				setDepositStatus(DepositStatus.Agendado);
			} else if (40 < dataDeposit) {

				aux = (float) (aux * 1.7);
				aux = (aux / 100);
				response = amount - aux;

				setDepositStatus(DepositStatus.Agendado);
			} else {
				amount = 0;
				setDepositStatus(DepositStatus.Taxa_Nao_encontrada);
			}
		} else if (type > 3) {
			amount = 0;
			setDepositStatus(DepositStatus.Taxa_Nao_encontrada);
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
