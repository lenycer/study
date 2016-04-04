package com.lenycer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleViewController {

	@RequestMapping(value="/simple", method=RequestMethod.GET)
	public String simple(Model model) {
		model.addAttribute("name", "hello lenycer");
		return "simple";
	}
	
	public static class Simple {
		private int id;
		private String name;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
