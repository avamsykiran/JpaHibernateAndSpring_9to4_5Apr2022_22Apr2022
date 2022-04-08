package com.cts.jpademo.models;

public class DeptWiseEmpCount {

	private String deptName;
	private long empCount;
	
	public DeptWiseEmpCount() {
		// TODO Auto-generated constructor stub
	}

	public DeptWiseEmpCount(String deptName, long empCount) {
		super();
		this.deptName = deptName;
		this.empCount = empCount;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getEmpCount() {
		return empCount;
	}

	public void setEmpCount(long empCount) {
		this.empCount = empCount;
	}

	@Override
	public String toString() {
		return "DeptWiseEmpCount [deptName=" + deptName + ", empCount=" + empCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + (int) (empCount ^ (empCount >>> 32));
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
		DeptWiseEmpCount other = (DeptWiseEmpCount) obj;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (empCount != other.empCount)
			return false;
		return true;
	}


	
	
}
