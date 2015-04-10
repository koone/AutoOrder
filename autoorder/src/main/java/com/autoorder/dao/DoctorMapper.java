package com.autoorder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autoorder.bo.Doctor;

/**
 * @autor Seaven
 * @time 上午12:55:56
 *
 */
public interface DoctorMapper {
	
	public Doctor queryDoctorByID(Long id);
	
	public List<Doctor> queryDoctorByOutPatientID(@Param("outPatientID")Long outPatientID);

}