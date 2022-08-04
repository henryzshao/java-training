package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DemoRepository;

@Service("serviceB")
public class DemoServiceB implements DemoService{
	
	@Autowired //Field-based Depedency Injection
	DemoRepository repo1;
	DemoRepository repo2;
	DemoRepository repo3;
	
	//Construct-based Dependency Injection
	DemoServiceB (DemoRepository repo){
		this.repo2 = repo;
	}
	
	//Setter-based Dependency Injection
	public void setDemoRepository (DemoRepository repo) {
		this.repo3 = repo;
	}
	
	public void getUser() {
		System.out.println("    DemoServiceB");
		repo1.getUser();
		repo2.getUser();
		repo3.getUser();
	}
}
