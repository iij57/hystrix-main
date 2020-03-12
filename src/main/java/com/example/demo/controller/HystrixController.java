package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HystrixService;

@RestController
public class HystrixController {
	
	@Autowired
	private HystrixService hystrixService;
	
	@GetMapping("/successTest")
	public String success() {
		return hystrixService.successService();
	}
	
	@GetMapping("/sleepTest/{sleeptime}")
	public String sleep(@PathVariable("sleeptime") int sleeptime) {
		return hystrixService.sleepService(sleeptime);
	}
	
	@GetMapping("/exceptionTest")
	public String exception() {
		return hystrixService.exceptionService();
	}
	

}
