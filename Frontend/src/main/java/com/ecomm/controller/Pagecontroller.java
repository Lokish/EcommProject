package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pagecontroller 
{
	@RequestMapping("/login")
	public String showLoginPage()
	{
		return "login";
	}
	
	@RequestMapping("/register")
	public String showRegisterPage()
	{
		return "register";
	}
}
