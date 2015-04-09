package com.autoorder.dao;

import java.util.List;

import com.autoorder.bo.Orders;

/**
 * @autor Seaven
 * @time 上午2:36:41
 *
 */
public interface OrdersDAO {

	public Orders queryOrdersByID(Long id);
	
	public List<Orders> queryOrdersByBaiduUid(Long baiduUid);
}
