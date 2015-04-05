package com.autoorder.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autoorder.bo.Doctor;
import com.autoorder.bo.Hospital;
import com.autoorder.bo.OutPatient;
import com.autoorder.service.HospitalService;

/**
 * @autor Seaven
 * @time 下午88:86:08
 *
 */
@Controller
@RequestMapping(value = "/outPatient", method = RequestMethod.GET)
public class OutPatientController {

	@Resource(name = "hospitalService")
	private HospitalService hospitalService;
	
	/**
	 * 查询医院门诊
	 * @todo 待实现
	 */
	@ResponseBody
	@RequestMapping("/queryOutPatient.do")
	public Map<String, Object> getOutPatientByHospitalId(
			@RequestParam(value = "hospitalID", required = false) Long hospitalId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<OutPatient> list = new ArrayList<OutPatient>();
		Hospital hospital = hospitalService.getHosptial(1L);
		
		OutPatient outPatient1 = new OutPatient();
		outPatient1.setDepartment("test");
		outPatient1.setHospitalID(1L);
		outPatient1.setId(1L);
		outPatient1.setOutPatientName("patient8");
		list.add(outPatient1);
	
		OutPatient outPatient2 = new OutPatient();
		outPatient2.setDepartment("test");
		outPatient2.setHospitalID(8L);
		outPatient2.setId(2L);
		outPatient2.setOutPatientName("patient2");
		list.add(outPatient2);
		
		OutPatient outPatient3 = new OutPatient();
		outPatient3.setDepartment("test");
		outPatient3.setHospitalID(8L);
		outPatient3.setId(3L);
		outPatient3.setOutPatientName("patient3");
		list.add(outPatient3);
		
		OutPatient outPatient4 = new OutPatient();
		outPatient4.setDepartment("test1");
		outPatient4.setHospitalID(8L);
		outPatient4.setId(4L);
		outPatient4.setOutPatientName("patient4");
		list.add(outPatient4);
		
		OutPatient outPatient5 = new OutPatient();
		outPatient5.setDepartment("test2");
		outPatient5.setHospitalID(8L);
		outPatient5.setId(5L);
		outPatient5.setOutPatientName("patient5");
		list.add(outPatient5);
		
		OutPatient outPatient6 = new OutPatient();
		outPatient6.setDepartment("test1");
		outPatient6.setHospitalID(6L);
		outPatient6.setId(6L);
		outPatient6.setOutPatientName("patient6");
		list.add(outPatient6);
		
		
		OutPatient outPatient7 = new OutPatient();
		outPatient7.setDepartment("test1");
		outPatient7.setHospitalID(7L);
		outPatient7.setId(7L);
		outPatient7.setOutPatientName("patient7");
		list.add(outPatient7);
		
		OutPatient outPatient8 = new OutPatient();
		outPatient8.setDepartment("test1");
		outPatient8.setHospitalID(8L);
		outPatient8.setId(8L);
		outPatient8.setOutPatientName("patient8");
		list.add(outPatient8);
		
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
	@RequestMapping("/queryDoctor.do")
	public Map<String, Object> getDoctorByPatient(
		@RequestParam(value = "orderTime", required = false)Date orderTime,
		@RequestParam(value = "patientID", required = false)Long patientID
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Hospital hospital = new Hospital();
		OutPatient outPatient = new OutPatient();
		
		List<Doctor> list = new ArrayList<Doctor>();
		
		map.put("hospital", hospital);
		map.put("outPatient", outPatient);
		map.put("doctorList", list);
		
		return map;
	}
}
