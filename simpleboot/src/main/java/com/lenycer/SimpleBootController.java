package com.lenycer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenycer.sample.SampleBeans;

@RestController
public class SimpleBootController {

	@Autowired SampleBeans sampleBeans;
	
	@RequestMapping(value="/")
	public Map<String, String> getSimple() {
		sampleBeans.getTest();
		Map<String, String> simple = new HashMap<>();
		simple.put("lenycer", "hello");
		return simple;
	}
}
