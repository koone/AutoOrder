package com.autoorder.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autoorder.bo.Hospital;
import com.autoorder.service.HospitalService;
import com.autoorder.service.KeyValueService;

@Controller
@RequestMapping(value = "/hospital", method = RequestMethod.GET)
public class HospitalController {

	@Resource(name = "hospitalService")
	private HospitalService hospitalService;
	
	@Resource(name = "keyValueService")
	private KeyValueService keyValueSerivce;
	
	@ResponseBody
	@RequestMapping("/query.do")
	public List<Hospital> queryHospital(HttpServletRequest request) {

		List<Hospital> list = new ArrayList<Hospital>();
		
		String hospitalAreaStr = request.getParameter("hospitalArea");
		String hospitalTypeStr = request.getParameter("hospitalType");
		String hospitalRankStr = request.getParameter("hospitalRank");
		
		Hospital queryBean = new Hospital();
		
		if (!StringUtils.isEmpty(hospitalAreaStr)) {
			queryBean.setHospitalType(new Integer(hospitalTypeStr));
		}
		
		if (!StringUtils.isEmpty(hospitalRankStr)) {
			queryBean.setHospitalRank(new Integer(hospitalRankStr));
		}
		
		if (!StringUtils.isEmpty(hospitalTypeStr)) {
			queryBean.setHospitalType(new Integer(hospitalTypeStr));
		}
		
		list = hospitalService.queryHospitalByCondition(queryBean);
		
		return list; 
	}
	
	@ResponseBody
	@RequestMapping("/init.do")
	public Map<String, Object> initQueryHospital() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String[] keys = new String[] {"HospitalType", "HospitalRank", "HospitalArea"};
		
		map = keyValueSerivce.getKeyValuesByName(keys);
		
		return map;
	}
}
