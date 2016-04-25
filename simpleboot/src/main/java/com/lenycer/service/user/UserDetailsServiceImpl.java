package com.lenycer.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenycer.domain.user.SimpleUser;
import com.lenycer.domain.user.SimpleUserDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SimpleUserMapper simpleUserMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.debug("Test SimpleUserServiceImpl===========");
		SimpleUser simpleUser = simpleUserMapper.selectSimpleUser(username);
		if(simpleUser != null) {
			simpleUser.setRole(simpleUserMapper.selectSimpleUserAuthorites(username));
		} else {
			throw new UsernameNotFoundException(username);
		}
		return new SimpleUserDetail(simpleUser);
	}
}
