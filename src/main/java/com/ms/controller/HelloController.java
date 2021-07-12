package com.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{

	@RequestMapping("/hello")
	public ModelAndView jumpindex() {
		ModelAndView mav =new ModelAndView("redirect:/index");
		return mav;
		
	}
	
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav =new ModelAndView("hello");
//		mav.addObject("mess", "ÄãºÃ£¬ÃÈÉ­¹¤×÷ÊÒ");
//		return mav;
//	}
	
}
