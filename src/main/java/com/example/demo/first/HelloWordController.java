package com.example.demo.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWordController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String printHello() {
		return "webSocket";
	}
	
	@RequestMapping(value="/index1",method=RequestMethod.GET)
	public String printHello1() {
		return "hello world1";
	}
	@RequestMapping(value="/index2",method=RequestMethod.GET)
	public String printHello2() {
		return "hello world2";
	}
}
