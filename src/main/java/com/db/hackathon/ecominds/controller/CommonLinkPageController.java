/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.hackathon.ecominds.entity.ProjectInfo;
import com.db.hackathon.ecominds.model.ProjectDetails;
import com.db.hackathon.ecominds.service.CustomJdbcService;
import com.db.hackathon.ecominds.service.PageService;
import com.db.hackathon.ecominds.service.ProjectService;
import com.db.hackathon.ecominds.service.StripePaymentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CommonLinkPageController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
    private StripePaymentService paymentService;
	
	@Autowired
	private CustomJdbcService jdbcService;
	
	@Autowired
	private PageService pageService;
	
	@GetMapping({"/", "/index", "/index/", "/index.html", 
		"/home", "/home/", "/home.html"})
    public String getHomePage(ModelMap model) {
		
		model.addAttribute("stripePublicKey", paymentService.getPublicKey());
		
		model.addAttribute("txnDataReport", jdbcService.getCounters());
		
		List<ProjectInfo> entityCol = projectService.getAll(3);
		model.addAttribute("entityCol", entityCol);
		
        return pageService.getTemplate("index");
    }
	
	
	@GetMapping("/projectInfo.html")
    public String getProjectInfoPage(@RequestParam (defaultValue = "0") String projectRefId,
    		ModelMap model) {
		
		model.addAttribute("stripePublicKey", paymentService.getPublicKey());
		
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectRefId);
			if(projectId > 0) {
				ProjectDetails projectDtls = projectService.get(projectId);
				model.addAttribute("entity", projectDtls);
				return pageService.getTemplate("project-info");
			}
		}catch(Exception ex) {
			log.error("Not able to get the project -> " + projectId);
		}
		List<ProjectDetails> entityCol = projectService.getProjectDtls();
		model.addAttribute("entityCol", entityCol);
        return pageService.getTemplate("project-list");
    }
}