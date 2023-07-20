package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.impl.UtilService;
import com.app.util.constant.UtilConstant;

@RestController
@RequestMapping("/")
public class AppController {
	
	@GetMapping
	public String checkApp() {
		return UtilConstant.SUCCESS;
	}
	
}
