package com.lenycer.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lenycer.domain.simple.Simple;
import com.lenycer.service.simple.SimpleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SimpleController {
	
	@Autowired SimpleService simpleService;
	
	@Value("${name}")
	private String name;
	
	/**
	 * controller test
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Map<String, String> simpleMap() {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
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
	 * error 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/rest/error", method=RequestMethod.GET)
	public void error() throws Exception {
		throw new Exception("rest error");
	}
	
	/**
	 * error json return
	 * @ExceptionHandler : only one controller 
	 * @ControllerAdvice : to apply all controller
	 * @param e
	 * @return
	 */
//	@ExceptionHandler({Exception.class})
//	@ResponseStatus(HttpStatus.BAD_REQUEST) //optional
//	public Simple handleError(Exception e) {
//		Simple simple = new Simple();
//		simple.setId(9999);
//		simple.setName(e.getMessage());
//		return simple;
//	}
}
