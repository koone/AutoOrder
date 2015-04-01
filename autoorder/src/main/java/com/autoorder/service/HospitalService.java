package com.autoorder.service;

import com.autoorder.bo.Hospital;

/**
 * @autor Seaven
 * @time 上午1:36:41
 *
 */
public interface HospitalService {
	
	/**
	 * id查找医院
	 * @param id
	 * @return
	 */
	public Hospital getHosptial(Long id);
}
