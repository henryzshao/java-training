package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DemoRepository;

@Service("serviceA")
public class DemoServiceA implements DemoService{
	
	@Autowired //Autowire by Type
	DemoRepository repo;
	
	public void getUser() {
		System.out.println("    DemoServiceA");
		repo.getUser();
	}
}
