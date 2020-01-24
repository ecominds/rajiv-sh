/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 19, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stripe.exception.StripeException;

@Controller
public class AuthController {
	
	@GetMapping("/login.html")
	public String get(Model model) throws StripeException {
		return "login.html";
	}
	
	@PostMapping("/login.html")
	public String post(Model model) throws StripeException {
		return "login.html";
	}
}