package com.company.controllers;

import java.util.List;

import com.company.entities.Users;
import com.company.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControllers {

    @Autowired
	private UserRepository userRepo;

	@GetMapping("")
	public String viewHomePage(){
		return "index";
	}

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "welcome";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
    model.addAttribute("user", new Users());
     
    return "register";
	}

	
	@PostMapping("/process_register")
	public String processRegister(Users user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = passwordEncoder.encode(user.getPassword());
    	user.setPassword(encodedPassword);
     
    	userRepo.save(user);
     
    	return "register_success";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
    	List<Users> listUsers = userRepo.findAll();
    	model.addAttribute("listUsers", listUsers);
     
    	return "users";
	}
}