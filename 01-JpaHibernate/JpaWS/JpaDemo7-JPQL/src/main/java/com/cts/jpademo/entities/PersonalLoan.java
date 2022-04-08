package com.cts.jpademo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("personal")
//@Table(name="ploans")
@Table(name="ploans_only")
public class PersonalLoan extends Loan{
	
	private String purpose;
	
	public PersonalLoan() {
		// TODO Auto-generated constructor stub
	}

	public PersonalLoan(Long loadnId, Double principle, Integer term, Double roi,String purpose) {
		super(loadnId, principle, term, roi);
		this.purpose=purpose;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalLoan other = (PersonalLoan) obj;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		return true;
	}
	
	

}
