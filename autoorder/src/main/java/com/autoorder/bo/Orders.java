/**
 * 
 */
package com.autoorder.bo;

import java.util.Date;

/**
 * 
 * 预约单
 * @author Seaven
 *
 */
public class Orders {

	private Long id;

	private String patientName;
	
	private String patientIDCard;
	
	private String patientTelphone;
	
	private String patientHospitalCard;
	
	private Long hospitalID;
	
	private Long outPatientID;
	
	private Long doctorID;
	
	private Double regFees;
	
	private Date orderTime;

	private Long operatorBaiduID;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientIDCard() {
		return patientIDCard;
	}

	public void setPatientIDCard(String patientIDCard) {
		this.patientIDCard = patientIDCard;
	}

	public String getPatientTelphone() {
		return patientTelphone;
	}

	public void setPatientTelphone(String patientTelphone) {
		this.patientTelphone = patientTelphone;
	}

	public String getPatientHospitalCard() {
		return patientHospitalCard;
	}

	public void setPatientHospitalCard(String patientHospitalCard) {
		this.patientHospitalCard = patientHospitalCard;
	}

	public Long getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(Long hospitalID) {
		this.hospitalID = hospitalID;
	}

	public Long getOutPatientID() {
		return outPatientID;
	}

	public void setOutPatientID(Long outPatientID) {
		this.outPatientID = outPatientID;
	}

	public Long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Long doctorID) {
		this.doctorID = doctorID;
	}

	public Double getRegFees() {
		return regFees;
	}

	public void setRegFees(Double regFees) {
		this.regFees = regFees;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Long getOperatorBaiduID() {
		return operatorBaiduID;
	}

	public void setOperatorBaiduID(Long operatorBaiduID) {
		this.operatorBaiduID = operatorBaiduID;
	}
}
