package com.autoorder.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autoorder.bo.Doctor;
import com.autoorder.bo.Hospital;
import com.autoorder.bo.OutPatient;
import com.autoorder.service.HospitalService;
import com.autoorder.service.OutPatientService;

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

	@Resource(name = "outPatientService")
	private OutPatientService outPatientService;
	
	/**
	 * 查询医院门诊
	 */
	@ResponseBody
	@RequestMapping("/queryOutPatient.do")
	public Map<String, Object> getOutPatientByHospitalId(
			@RequestParam(value = "hospitalID", required = false) Long hospitalId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<OutPatient> list = outPatientService.getOutPatientByHospital(hospitalId);
		Hospital hospital = hospitalService.getHosptial(hospitalId);
		
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
		@RequestParam(value = "orderTime", required = false)
		@DateTimeFormat(pattern="yyyy-MM-dd")Date orderTime,
		@RequestParam(value = "outPatientID", required = false)Long patientID
			) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Hospital hospital = new Hospital();
		hospital.setName("testHospital");
		
		OutPatient outPatient = new OutPatient();
		outPatient.setDepartment("departmentID");
		outPatient.setOutPatientName("outPatientName");
		
		List<Doctor> list = new ArrayList<Doctor>();
		
		Doctor doctor = new Doctor();
		doctor.setDescripe("testsetsetsettsetse");
		doctor.setDoctorName("qqqq");
		doctor.setDoctorRank("ettwetret");
		doctor.setRegFees(100D);
		list.add(doctor);
		
		Doctor doctor1 = new Doctor();
		doctor1.setDescripe("zxczxczxczzxc");
		doctor1.setDoctorName("xxxx");
		doctor1.setDoctorRank("sdfgssdf");
		doctor1.setRegFees(1100D);
		list.add(doctor1);
		
		map.put("hospital", hospital);
		map.put("outPatient", outPatient);
		map.put("doctorList", list);
		
		return map;
	}
}
