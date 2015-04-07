package com.autoorder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoorder.bo.OutPatient;
import com.autoorder.dao.OutPatientMapper;
import com.autoorder.service.OutPatientService;

/**
 * @autor Seaven
 * @time 上午12:38:19
 *
 */
@Service("outPatientService")
public class OutPatientServiceImpl implements OutPatientService {

	@Autowired
	private OutPatientMapper outPatientMapper;
	
	/**
	 * {@inheritDoc}
	 */
	public OutPatient getOutPatientByID(Long id) {
		if (null != id) {
			return outPatientMapper.queryOutPatientByID(id); 
		}
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<OutPatient> getOutPatientByHospital(Long hospitalID) {
		if (null != hospitalID) {
			return outPatientMapper.queryOutPatientByHospitalID(hospitalID);
		}
		
		return new ArrayList<OutPatient>();
	}

}
