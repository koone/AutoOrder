/**
 * 
 */
package com.autoorder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoorder.bo.Orders;
import com.autoorder.dao.OrdersMapper;
import com.autoorder.service.OrdersService;

/**
 * @author hekai
 *
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	/**
	 *{@inheritDoc}
	 */
	public Orders getOrdersByID(Long id) {
		if (null == id) {
			return ordersMapper.queryOrdersByID(id);
		}
		
		return null;
	}

	/**
	 *{@inheritDoc}
	 */
	public List<Orders> getOrdersByBaiduUid(Long baiduUid) {
		if (null == baiduUid) {
			return ordersMapper.queryOrdersByBaiduUid(baiduUid);
		}
		
		return new ArrayList<Orders>();
	}

}
