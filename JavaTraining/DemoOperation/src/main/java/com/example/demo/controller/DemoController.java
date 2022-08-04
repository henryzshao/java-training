package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;
import com.example.demo.service.DemoServiceA;

@RestController
public class DemoController {
	
	@Autowired //Autowired by name
	DemoServiceA servicea;
	
	@Autowired //Autowired by qualifier
	@Qualifier("serviceB")
	DemoService serviceb;
	
	@GetMapping("/test")
	public void getUser() {
		servicea.getUser();
		serviceb.getUser();
		System.out.println("Yay");
	}
}
