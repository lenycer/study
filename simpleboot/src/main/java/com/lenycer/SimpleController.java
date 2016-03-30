package com.lenycer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Map<String, String> simple() {
		Map<String, String> map = new HashMap<>();
		map.put("lenycer", "test");
		return map;
	}

}
