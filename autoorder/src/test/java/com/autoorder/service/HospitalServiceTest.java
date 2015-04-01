package com.autoorder.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @autor Seaven
 * @time 上午1:44:05
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class HospitalServiceTest {

	@Resource(name = "hospitalService")
	private HospitalService hospitalService;
	
	@Test
	public void test() {
		System.out.println(hospitalService.getHosptial(1L));
	}
}
