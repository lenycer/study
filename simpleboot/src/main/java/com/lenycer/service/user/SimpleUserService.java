package com.lenycer.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenycer.domain.user.SimpleUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimpleUserService {

	@Autowired
	private SimpleUserMapper simpleUserMapper;
	
	@Transactional
	public int addSimpleUser(SimpleUser simpleUser) {
		int result = simpleUserMapper.insertSimpleUser(simpleUser);
		if(result > 0) {
			if(simpleUser.getRole() != null) {
				for(String role : simpleUser.getRole()) {
					result += simpleUserMapper.insertSimpleUserAuthority(simpleUser.getUsername(), role);
				}
			}
		}
		//result count < 2 일 경우 rollback 처리 필요
		return result;
	}
	
}
