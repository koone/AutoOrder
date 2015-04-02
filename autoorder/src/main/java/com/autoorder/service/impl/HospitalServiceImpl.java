package com.autoorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoorder.bo.Hospital;
import com.autoorder.dao.HospitalMapper;
import com.autoorder.service.HospitalService;

/**
 * @autor Seaven
 * @time 上午1:38:02
 *
 */
@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalMapper hospitalMapper;
	
	/**
	 * {@inheritDoc}
	 */
	public Hospital getHosptial(Long id) {
		
		if (null != id) {
			return hospitalMapper.queryHaspitalByID(id);
		}
		
		return null;
	}
}
