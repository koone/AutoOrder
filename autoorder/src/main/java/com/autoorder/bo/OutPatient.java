package com.autoorder.bo;

/**
 * 
 * 医院具体门诊
 * @autor Seaven
 * @time 下午7:45:03
 *
 */
public class OutPatient {

	private Long id;
	
	private Long hospitalID;
	
	/**
	 * 科室：如五官科，心脑科......
	 */
	private String department;
	
	/**
	 * 门诊名称：心外科门诊....
	 */
	private String outPatientName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(Long hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOutPatientName() {
		return outPatientName;
	}

	public void setOutPatientName(String outPatientName) {
		this.outPatientName = outPatientName;
	}
}
