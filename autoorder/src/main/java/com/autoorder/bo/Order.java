/**
 * 
 */
package com.autoorder.bo;

/**
 * 
 * 预约单
 * @author Seaven
 *
 */
public class Order {

	private Long id;

	private String patientName;
	
	private String patientIDCard;
	
	private String patientTelphone;
	
	private String patientHospitalCard;
	
	private Long hospitalID;
	
	private Long outPatientID;
	
	private Long doctorID;

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
}
