package com.autoorder.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autoorder.bo.Orders;

/**
 * @autor Seaven
 * @time 上午2:36:41
 *
 */
public interface OrdersMapper {

	public Orders queryOrdersByID(Long id);
	
	public List<Orders> queryOrdersByBaiduUid(Long baiduUid);
	
	public Long countOrdersByDoctorID(@Param("doctorID")Long doctorID, @Param("orderTime")Date orderTime);
}
