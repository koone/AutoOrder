/**
 * 
 */
package com.autoorder.service;

import java.util.List;

import com.autoorder.bo.Orders;

/**
 * @author hekai
 *
 */
public interface OrdersService {

	public Orders getOrdersByID(Long id);
	
	public List<Orders> getOrdersByBaiduUid(Long baiduUid);
}
