/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.controller.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.ecominds.service.CustomJdbcService;

@RestController
@RequestMapping("/subscriber")
public class CommonRestPageController {

	@Autowired
	private CustomJdbcService customJdbcService;

	@GetMapping(value = "/getAll")
	public Set<String> getAll() {
		return customJdbcService.getAll();
	}

	@GetMapping(value = "/add")
	public String add(@RequestParam(defaultValue = "") String emailAddress) {
		boolean rsult = false;
		if (isValidEmail(emailAddress)) {
			rsult =  customJdbcService.addToSubscriber(emailAddress, "");
		}
		return rsult ? "success" : "false";
	}

	public static boolean isValidEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}