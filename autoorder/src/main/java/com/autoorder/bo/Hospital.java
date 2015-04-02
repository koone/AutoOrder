package com.autoorder.bo;

/**
 * @autor Seaven
 * @time 上午12:59:03
 *
 */
public class Hospital {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String telphone;
	
	private Integer hospitalType;
	
	private Integer hospitalRank;
	
	private Integer hospitalArea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	public Integer getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(Integer hospitalType) {
		this.hospitalType = hospitalType;
	}

	public Integer getHospitalRank() {
		return hospitalRank;
	}

	public void setHospitalRank(Integer hospitalRank) {
		this.hospitalRank = hospitalRank;
	}

	public Integer getHospitalArea() {
		return hospitalArea;
	}

	public void setHospitalArea(Integer hospitalArea) {
		this.hospitalArea = hospitalArea;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", address=" + address
				+ ", telphone=" + telphone + ", hospitalType=" + hospitalType
				+ ", hospitalRank=" + hospitalRank + ", hospitalArea="
				+ hospitalArea + "]";
	}
}
