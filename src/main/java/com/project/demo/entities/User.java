package com.project.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private int phone;
	private LocalDate bDay;
	private int age;
	private int dayBDay;
	private int monthBDay;
	private int yearBDay;
	private String password;

	public User() {
	}

	public User(Long id, String firstName, String lastName, String email, int phone, int yearBDay,
			int monthBDay, int dayBDay, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.dayBDay = dayBDay;
		this.monthBDay = monthBDay;
		this.yearBDay = yearBDay;
		this.password = password;
		setbDay(LocalDate.of(yearBDay, monthBDay, dayBDay));
		setAge(getbDay());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public LocalDate getbDay() {
		return bDay;
	}

	public void setbDay(LocalDate bDay) {
		this.bDay = bDay;
	}

	public int getDayBDay() {
		return dayBDay;
	}

	public void setDayBDay(int dayBDay) {
		this.dayBDay = dayBDay;
	}

	public int getMonthBDay() {
		return monthBDay;
	}

	public void setMonthBDay(int monthBDay) {
		this.monthBDay = monthBDay;
	}

	public int getYearBDay() {
		return yearBDay;
	}

	public void setYearBDay(int yearBDay) {
		this.yearBDay = yearBDay;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(LocalDate bday) {
		this.age = LocalDate.now().getYear() - bday.getYear();
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
