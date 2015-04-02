package com.autoorder.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
	@RequestMapping("/id/{id}.do")
	public Hospital queryHospital(@PathVariable("id") Long id) {

		Hospital hospital = hospitalService.getHosptial(id);
		
		return hospital;
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
