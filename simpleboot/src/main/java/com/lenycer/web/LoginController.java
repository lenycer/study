package com.lenycer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lenycer.domain.simple.Simple;

import lombok.extern.slf4j.Slf4j;

/**
 * login 관련 
 * @author 현석
 *
 */
@Slf4j
@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
}
