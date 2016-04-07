package com.lenycer.service.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenycer.domain.simple.Simple;

@Service
public class SimpleService {

	@Autowired SimpleMapper simpleMapper;
	
	public Simple getSimple(int id) {
		return simpleMapper.selectSimple(id);
	}
	
	public int addSimple(Simple simple) {
		return simpleMapper.insertSimple(simple);
	}
}
