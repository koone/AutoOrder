package com.autoorder.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autoorder.bo.Doctor;
import com.autoorder.bo.Hospital;
import com.autoorder.bo.OutPatient;

/**
 * @autor Seaven
 * @time 下午11:16:01
 *
 */
@Controller
@RequestMapping(value = "/outPatient", method = RequestMethod.GET)
public class OutPatientController {

	/**
	 * 查询医院门诊
	 * @todo 待实现
	 */
	@ResponseBody
	@RequestMapping("/queryOutPatient.do?hospitalID=${hospitalId}")
	public Map<String, Object> getOutPatientByHospitalId(@PathVariable("hospitalId")Long hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<OutPatient> list = new ArrayList<OutPatient>();
		Hospital hospital = new Hospital();
	
		map.put("outPatientList", list);
		map.put("hospital", hospital);
		
		return map;
	}
	
	/**
	 * 根据预约时间和门诊ID查询可预约的医生= =
	 * @todo 待实现
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/")
	public Map<String, Object> getDoctorByPatient(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String orderTime = request.getParameter("orderTime");
		String hospitalRankStr = request.getParameter("patientID");
		
		Hospital hospital = new Hospital();
		OutPatient outPatient = new OutPatient();
		
		List<Doctor> list = new ArrayList<Doctor>();
		
		map.put("hospital", hospital);
		map.put("outPatient", outPatient);
		map.put("doctorList", list);
		
		return map;
	}
}
