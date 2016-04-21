package com.lenycer.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lenycer.domain.user.SimpleUser;
import com.lenycer.domain.user.SimpleUserDetail;
import com.lenycer.service.user.SimpleUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * login 관련 
 * @author 현석
 *
 */
@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	private SimpleUserService SimpleUserService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	/**
	 * 회원 가입 페이지
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	/**
	 * 회원가입 및 인증 저장
	 * @param simpleUser
	 * @param authority
	 * @return
	 */
	@RequestMapping(value="/register/user", method=RequestMethod.POST)
	public String registerUSer(SimpleUser simpleUser, String authority) {
		List<String> role = new ArrayList<>();
		role.add(authority);
		simpleUser.setRole(role);
		//TODO password 암호화 하여 insert 할 필요 있음. 암호화 하여 넣을거면 SecurityConfig에서도 auth.passwordEncoder 적용을 해야 함.
		
		SimpleUserService.addSimpleUser(simpleUser);
		
		//인증정보를 생성하여 인증 저장
		SimpleUserDetail simpleUserDetail = new SimpleUserDetail(simpleUser);
		Authentication authentication = new UsernamePasswordAuthenticationToken(simpleUserDetail, null, simpleUserDetail.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/";
	}
}
