package com.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UIController {
	@GetMapping("/hello")
	public String getHello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		return "hello";

	}

}
