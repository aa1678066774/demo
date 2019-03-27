package com.example.demo.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by vitamin on 2019/3/21.
 */
@RestController
@RequestMapping("/user")
public class TestController {
	@GetMapping
	public String getUsers() {
		return "Hello Spring Security";
	}

}
