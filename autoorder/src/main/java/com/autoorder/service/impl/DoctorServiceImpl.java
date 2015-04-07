package com.autoorder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoorder.bo.Doctor;
import com.autoorder.dao.DoctorMapper;
import com.autoorder.service.DoctorService;

/**
 * @autor Seaven
 * @time 上午1:00:33
 *
 */
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorMapper doctorMapper;
	
	/**
	 * {@inheritDoc}
	 */
	public Doctor queryDoctorByID(Long id) {
		if (null != id) {
			return doctorMapper.queryDoctorByID(id);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Doctor> queryDoctorByOutPatientID(Long outPatientID,
			Integer regCount) {
		
		if (null != outPatientID) {
			return doctorMapper.queryDoctorByOutPatientID(outPatientID, regCount);
		}
		return new ArrayList<Doctor>();
	}

}
