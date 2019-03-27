package com.example.demo.test.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileViewController {
	
	@RequestMapping("/upload")
	public String goFileView() {
		return "upload";
	}
}
