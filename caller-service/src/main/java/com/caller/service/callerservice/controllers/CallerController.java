package com.caller.service.callerservice.controllers;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.caller.service.callerservice.entity.User;

@RestController
//@slf4j
@RequestMapping("/api")
public class CallerController {
	private static final String URL = "http://localhost:8082/user/";
	
	private static final String deleteURL = "http://localhost:8082/user/{id}";
	private static final String putURL = "http://localhost:8082/user/{id}";
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/callotherservice")
	void getUserFromOtherservice() {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(URL, List.class);
//		(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
	}
	@PostMapping("/createUser")
	private void sendPostRequestToUserService(@RequestBody User user) {
//		User user1 =  new User();
//		user1.setName("user1");
//		user1.setAge(10);
//		user1.setSalary(10000);
		
		restTemplate.postForEntity(URL, user, String.class);
	}
	
//		delete
//	@RequestMapping(value="/deleteUser/{id}")
//	public String deleteUser(@PathVariable("id") Integer id) {
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//        return restTemplate.exchange(URL + id, HttpMethod.DELETE, entity, String.class).getBody();
//	}
	
	@RequestMapping(value="/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		
		 restTemplate.delete(deleteURL , id);
	}
	
	//not working yet
//	@RequestMapping(value="/updateUser/{id}")
//	public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
//		restTemplate.put(putURL, user);
//	}
	
//	update
	 @RequestMapping(value = "/updateUser/{id}")
	    public String updatePost(@PathVariable("id") int id, @RequestBody User user) {
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity<User> entity = new HttpEntity<>( user, httpHeaders);
	        return restTemplate.exchange(URL + id, HttpMethod.PUT, entity, String.class).getBody();
	    }
}
