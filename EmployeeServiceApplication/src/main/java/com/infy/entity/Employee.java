package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infy.dto.EmployeeDTO;

@Entity
@Table
public class Employee {

	

	@Id
	private Integer empId;
	private String empName;
	private String empAddress;
	
	
	
	@OneToOne
	@JoinColumn(name="asset_id",unique = true)
	private Asset asset;
	


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", asset=" + asset
				+ "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	@Override
	public int hashCode() {
		return 31;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if (this.getEmpId() == null) {
			if (other.getEmpId() != null)
				return false;
		} else if (!this.getEmpId().equals(other.getEmpId()))
			return false;
		return true;
	}
	
	
	
	
	
}
