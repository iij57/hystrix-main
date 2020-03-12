package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {

	@Autowired
	private RestTemplateBuilder restTemplate;
	
	@HystrixCommand(fallbackMethod = "defaultHystrix")
	public String successService() {
		return restTemplate.build().getForObject("http://localhost:8081/success", String.class);
	}
	
	@HystrixCommand(fallbackMethod = "defaultHystrix")
	public String sleepService(int sleeptime) {
		String returnString = restTemplate.build().getForObject("http://localhost:8081/sleep/"+sleeptime, String.class);
		System.out.println("return : " + returnString);
		return returnString;
	}
	
	@HystrixCommand(fallbackMethod = "defaultHystrix")
	public String exceptionService() {
		return restTemplate.build().getForObject("http://localhost:8081/exception", String.class);
	}
	
	public String defaultHystrix() {
        return "Circut open!!";
    }
	
    public String defaultHystrix(int sleeptime) {
        return "Circut open!! " + sleeptime;
    }
	
	
}
