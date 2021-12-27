package com.caller.service.callerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallerController {
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/callotherservice")
	void getUserFromOtherservice() {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:8081/user", List.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
	}
}
