package com.lenycer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lenycer.simple.Simple;

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
}
