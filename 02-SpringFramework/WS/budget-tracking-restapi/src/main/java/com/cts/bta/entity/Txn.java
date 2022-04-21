package com.cts.bta.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name="txns")
public class Txn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long txnId;

	@NotBlank(message = "This field is a mandate")
	private String header;
	
	@NotNull(message = "This field is a mandate")
	@Min(value = 100,message = "A minimum of 100 is expected")
	@Max(value = 100000,message = "A maximum of 100000 is expected")
	private Double amount;
	
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "No future dates allowed")
	private LocalDate txnDate;
	
	@NotNull(message = "This field is a mandate")
	@Enumerated(EnumType.STRING)
	private TxnType type;
	
	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(Long txnId, String header, Double amount, LocalDate txnDate, TxnType type) {
		super();
		this.txnId = txnId;
		this.header = header;
		this.amount = amount;
		this.txnDate = txnDate;
		this.type = type;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((txnDate == null) ? 0 : txnDate.hashCode());
		result = prime * result + ((txnId == null) ? 0 : txnId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Txn other = (Txn) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (txnDate == null) {
			if (other.txnDate != null)
				return false;
		} else if (!txnDate.equals(other.txnDate))
			return false;
		if (txnId == null) {
			if (other.txnId != null)
				return false;
		} else if (!txnId.equals(other.txnId))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Txn [txnId=" + txnId + ", header=" + header + ", amount=" + amount + ", txnDate=" + txnDate + ", type="
				+ type + "]";
	}
	
	
}
