package com.autoorder.service;

import java.util.List;

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
	
	/**
	 * 条件查询
	 * @param queryBean
	 * @return
	 */
	public List<Hospital> queryHospitalByCondition(Hospital queryBean);
}
