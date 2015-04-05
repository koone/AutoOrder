package com.autoorder.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Hospital> queryHospital(
		@RequestParam(value = "hospitalArea", required = false)Integer hospitalArea,
		@RequestParam(value = "hospitalType", required = false)Integer hospitalType,
		@RequestParam(value = "hospitalRank", required = false)Integer hospitalRank) {

		List<Hospital> list = new ArrayList<Hospital>();
		
		Hospital queryBean = new Hospital();
		
		queryBean.setHospitalType(hospitalType);
		queryBean.setHospitalRank(hospitalRank);
		queryBean.setHospitalType(hospitalType);
		
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
