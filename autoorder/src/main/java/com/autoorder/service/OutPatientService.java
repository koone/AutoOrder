package com.autoorder.service;

import java.util.List;

import com.autoorder.bo.OutPatient;

/**
 * @autor Seaven
 * @time 上午12:36:49
 *
 */
public interface OutPatientService {
	
	public OutPatient getOutPatientByID(Long id);
	
	public List<OutPatient> getOutPatientByHospital(Long hospitalID);
}
