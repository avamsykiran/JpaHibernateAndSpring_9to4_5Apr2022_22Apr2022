package com.cts.jpademo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passports")
public class Passport {

	@Id
	@Column(name="pno")
	private String passportNumber;
	private String address;
	private LocalDate issueDate;
	
	@OneToOne(mappedBy = "passport",fetch = FetchType.LAZY)
	private Citizen holder;
	
	public Passport() {
		// TODO Auto-generated constructor stub
	}

	public Passport(String passportNumber, String address, LocalDate issueDate, Citizen holder) {
		super();
		this.passportNumber = passportNumber;
		this.address = address;
		this.issueDate = issueDate;
		this.holder = holder;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public Citizen getHolder() {
		return holder;
	}

	public void setHolder(Citizen holder) {
		this.holder = holder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((holder == null) ? 0 : holder.hashCode());
		result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
		result = prime * result + ((passportNumber == null) ? 0 : passportNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passport other = (Passport) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (holder == null) {
			if (other.holder != null)
				return false;
		} else if (!holder.equals(other.holder))
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		if (passportNumber == null) {
			if (other.passportNumber != null)
				return false;
		} else if (!passportNumber.equals(other.passportNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passport [passportNumber=" + passportNumber + ", address=" + address + ", issueDate=" + issueDate + "]";
	}
	
	
}
