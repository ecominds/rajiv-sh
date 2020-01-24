/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.ecominds.dao.ProjectRepo;
import com.db.hackathon.ecominds.entity.ProjectInfo;
import com.db.hackathon.ecominds.model.HomePageCounter;
import com.db.hackathon.ecominds.service.CustomJdbcService;
import com.db.hackathon.ecominds.service.PageService;
import com.db.hackathon.ecominds.service.StripePaymentService;

@RestController
@RequestMapping("/api")
public class AzureRestFunctionController {
	
	@Autowired
	private StripePaymentService paymentService;
	
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private CustomJdbcService jdbcService;

	@Autowired
	private PageService pageService;
	
	@GetMapping(value = "/get")
	public String getAll() {
		return paymentService.getPublicKey();
	}
	
	@GetMapping(value = "/rest")
	public List<ProjectInfo> getProject() {
		return projectRepo.findAll();
	}
	
	@GetMapping(value = "/getDataCounter")
	public HomePageCounter getDataCounter() {
		return jdbcService.getCounters();
	}
	
	
	
	@GetMapping(value = "/updateTemplate")
	public String updateTemplate(@RequestParam (defaultValue = "") String name) {
		return pageService.updateTemplate(name);
	}
}