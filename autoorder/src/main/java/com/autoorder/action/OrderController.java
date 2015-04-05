package com.autoorder.action;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autoorder.bo.Order;

/**
 * @autor Seaven
 * @time 下午11:49:52
 *
 */
@Controller
@RequestMapping(value = "/order.do", method = RequestMethod.GET)
public class OrderController {

	/**
	 * 提交预约单
	 * @todo 待实现
	 * @return 状态码
	 */
	@ResponseBody
	@RequestMapping("/commit.do")
	public Map<String, Object> commitOrder() {
		
		return null;
	}
	
	/**
	 * 取得当前登陆用户的预约单
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/myorder.do")
	public List<Order> getLoginUserOrder() {
		
		return null;
	}
	
	/**
	 * 取消预约单= =
	 * @param orderID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cancelOrder.do")
	public Map<String, Object> cancelOrder(Long orderID) {
		return null;
	}
}
