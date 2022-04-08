package com.cts.jpademo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("housing")
//@Table(name="hloans")
@Table(name="hloans_only")
public class HousingLoan extends Loan{

	private Double propertyValue;
	
	public HousingLoan() {
		// TODO Auto-generated constructor stub
	}

	public HousingLoan(Long loadnId, Double principle, Integer term, Double roi,Double propertyValue) {
		super(loadnId, principle, term, roi);
		this.propertyValue=propertyValue;
	}

	public Double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Double propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((propertyValue == null) ? 0 : propertyValue.hashCode());
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
		HousingLoan other = (HousingLoan) obj;
		if (propertyValue == null) {
			if (other.propertyValue != null)
				return false;
		} else if (!propertyValue.equals(other.propertyValue))
			return false;
		return true;
	}
	
	
}
