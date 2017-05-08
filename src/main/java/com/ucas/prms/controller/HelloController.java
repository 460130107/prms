package com.ucas.prms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv =new ModelAndView();
		mv.addObject("msg","hello springmvc");
		mv.setViewName("hello");
		return mv;
	}

}
