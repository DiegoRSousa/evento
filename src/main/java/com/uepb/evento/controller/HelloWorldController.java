package com.uepb.evento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}
}
