package com.lenycer.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lenycer.domain.simple.Simple;
import com.lenycer.domain.user.SimpleUserDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/view")
public class SimpleViewController {

	/**
	 * jsp view test 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/simple", method=RequestMethod.GET)
	public String simple(Model model) {
		Simple simple = new Simple();
		simple.setId(1);
		simple.setName("lenycer");
		model.addAttribute("simple", simple);
		return "simple";
	}
	
	/**
	 * user view
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user(Model model) {
		//spring security authentication 정보를 가져와 확인
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SimpleUserDetail simpleUserDetail = (SimpleUserDetail) authentication.getPrincipal();
		log.debug("username : {}", simpleUserDetail.getUsername());
		log.debug("nick : {}", simpleUserDetail.getNick());
		return "user";
	}
	
	/**
	 * view error
	 * @throws Exception
	 */
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public void error() throws Exception {
		throw new Exception("view error");
	}
	
	/**
	 * error view redirect
	 * @param e
	 * @return
	 */
//	@ExceptionHandler({Exception.class})
//	public ModelAndView handleError(Exception e) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("view-error");
//		model.addObject("ex", e);
//		return model;
//	}
}
