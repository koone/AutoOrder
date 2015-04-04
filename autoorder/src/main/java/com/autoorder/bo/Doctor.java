package com.autoorder.bo;

/**
 * @autor Seaven
 * @time 下午8:38:43
 *
 */
public class Doctor {

	private Long id;
	
	private String doctorName;
	
	/**
	 * 医生级别：主任，副主任，xxx，xxx...
	 */
	private String doctorRank;
	
	/**
	 * 挂号费
	 */
	private Double regFees;
	
	/**
	 * 专长。。负责什么什么病= =
	 */
	private String descripe;
	
	/**
	 * 挂号数，单位：单/天
	 */
	private Integer regCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorRank() {
		return doctorRank;
	}

	public void setDoctorRank(String doctorRank) {
		this.doctorRank = doctorRank;
	}

	public Double getRegFees() {
		return regFees;
	}

	public void setRegFees(Double regFees) {
		this.regFees = regFees;
	}

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	public Integer getRegCount() {
		return regCount;
	}

	public void setRegCount(Integer regCount) {
		this.regCount = regCount;
	}
}
