package com.autoorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoorder.bo.Doctor;
import com.autoorder.dao.DoctorMapper;
import com.autoorder.dao.OrdersMapper;
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
	
	@Autowired
	private OrdersMapper ordersMapper;
	
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
	 *{@inheritDoc}
	 */
	public List<Doctor> getAvaibleDoctorByOutPatientID(Long outPatientID, Date orderTime) {
		// TODO Auto-generated method stub
		
		List<Doctor> list = doctorMapper.queryDoctorByOutPatientID(outPatientID);
		List<Doctor> result = new ArrayList<Doctor>();
		for (Doctor doctor : list) {
			Long regCount = ordersMapper.countOrdersByDoctorID(doctor.getId(), orderTime);
			
			if (regCount < doctor.getRegCount()) {
				result.add(doctor);
			}
		}
		
		return result;
	}

}
