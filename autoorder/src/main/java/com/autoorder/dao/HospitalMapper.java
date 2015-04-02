package com.autoorder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autoorder.bo.Hospital;

/**
 * @autor Seaven
 * @time 上午1:32:12
 *
 */
public interface HospitalMapper {

	public Hospital queryHospitalByID(Long id);
	
	public List<Hospital> queryHospitalByCondition(@Param("queryBean")Hospital queryBean);
}
