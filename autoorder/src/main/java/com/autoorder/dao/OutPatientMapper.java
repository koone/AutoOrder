package com.autoorder.dao;

import java.util.List;

import com.autoorder.bo.OutPatient;

/**
 * @autor Seaven
 * @time 上午12:35:27
 *
 */
public interface OutPatientMapper {

	public OutPatient queryOutPatientByID(Long id);
	
	public List<OutPatient> queryOutPatientByHospitalID(Long hospitalID);
}
