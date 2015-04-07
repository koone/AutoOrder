package com.autoorder.service;

import java.util.List;

import com.autoorder.bo.Doctor;

/**
 * @autor Seaven
 * @time 上午12:59:45
 *
 */
public interface DoctorService {
	
	public Doctor queryDoctorByID(Long id);
	
	public List<Doctor> queryDoctorByOutPatientID(Long outPatientID, Integer regCount);
}
