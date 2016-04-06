package com.lenycer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lenycer.simple.Simple;
import com.lenycer.simple.SimpleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SimpleController {
	
	@Autowired SimpleService simpleService;
	
	/**
	 * controller test
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Map<String, String> simpleMap() {
		Map<String, String> map = new HashMap<>();
		map.put("lenycer", "test");
		return map;
	}

	/**
	 * select 단건.
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/simple", method=RequestMethod.GET)
	public Simple simple(Simple condition) {
		log.debug("log test");
		log.info("log info test");
		return simpleService.getSimple(condition.getId());
	}
	
	/**
	 * insert
	 * 일반적인 form parameter
	 * @param simple
	 * @return
	 */
	@RequestMapping(value="/simple", method=RequestMethod.POST)
	public int addSimple(Simple simple) {
		return simpleService.addSimple(simple);
	}
	
	/**
	 * insert
	 * json 형태로 받기 위해 @RequestBody 처리. 
	 * Contents-type : application/json 필요
	 * @param simple
	 * @return
	 */
	@RequestMapping(value="/simple-json", method=RequestMethod.POST)
	public int addSimpleJson(@RequestBody Simple simple) {
		return simpleService.addSimple(simple);
	}
	
	/**
	 * error 발생
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/error/resolver", method=RequestMethod.GET)
	public void error() throws Exception {
		throw new Exception("resolver error");
	}
	
}
