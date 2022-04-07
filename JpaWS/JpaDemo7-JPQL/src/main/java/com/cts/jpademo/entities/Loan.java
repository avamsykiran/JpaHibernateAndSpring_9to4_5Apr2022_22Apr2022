package com.cts.jpademo.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
/*
 * @Table(name="all_loans")
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 * @DiscriminatorColumn(name="loan_type", discriminatorType = DiscriminatorType.STRING)
 * @DiscriminatorValue("normal")
 */
/*@Table(name="loans")
@Inheritance(strategy = InheritanceType.JOINED)
*/
@Table(name="loans_only")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Loan {

	@Id
	private Long loadnId;
	private Double principal;
	private Integer term;
	private Double roi;
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}

	public Loan(Long loadnId, Double principle, Integer term, Double roi) {
		super();
		this.loadnId = loadnId;
		this.principal = principle;
		this.term = term;
		this.roi = roi;
	}

	public Long getLoadnId() {
		return loadnId;
	}

	public void setLoadnId(Long loadnId) {
		this.loadnId = loadnId;
	}

	public Double getPrinciple() {
		return principal;
	}

	public void setPrinciple(Double principle) {
		this.principal = principle;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Double getRoi() {
		return roi;
	}

	public void setRoi(Double roi) {
		this.roi = roi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loadnId == null) ? 0 : loadnId.hashCode());
		result = prime * result + ((principal == null) ? 0 : principal.hashCode());
		result = prime * result + ((roi == null) ? 0 : roi.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		Loan other = (Loan) obj;
		if (loadnId == null) {
			if (other.loadnId != null)
				return false;
		} else if (!loadnId.equals(other.loadnId))
			return false;
		if (principal == null) {
			if (other.principal != null)
				return false;
		} else if (!principal.equals(other.principal))
			return false;
		if (roi == null) {
			if (other.roi != null)
				return false;
		} else if (!roi.equals(other.roi))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		return true;
	}
	
	
}
