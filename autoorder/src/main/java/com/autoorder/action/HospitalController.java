package com.autoorder.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@RequestMapping(method = RequestMethod.GET)
	public String queryHospital(ModelMap modelMap) {
		modelMap.addAttribute("test", "hello world");
		return "queryHospital";
	}
}
