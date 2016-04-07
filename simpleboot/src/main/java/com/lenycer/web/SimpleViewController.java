package com.lenycer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lenycer.domain.simple.Simple;

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
