package com.qhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class IndexController {
	
	
		
		@RequestMapping("/indexpage")
		public String toShowUser(){
			return "index";
		}

}
