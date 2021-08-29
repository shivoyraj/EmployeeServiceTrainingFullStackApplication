package com.infy.dto;



public class EmployeeDTO {

	
  
	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", assetDTO="
				+ assetDTO + "]";
	}
	private Integer empId;
	private String empName;
	private String empAddress;
	private AssetDTO assetDTO;
	
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

	public AssetDTO getAsset() {
		return assetDTO;
	}
	public void setAsset(AssetDTO asset) {
		this.assetDTO = asset;
	}

	
}
