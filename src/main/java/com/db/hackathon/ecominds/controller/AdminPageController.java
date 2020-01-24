<<<<<<< HEAD
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.hackathon.ecominds.config.ui.UiUtils;
import com.db.hackathon.ecominds.model.ProjectDetails;
import com.db.hackathon.ecominds.service.PreferenceService;
import com.db.hackathon.ecominds.service.ProjectService;
import com.db.hackathon.ecominds.service.TeamMemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminPageController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private PreferenceService preferenceService;
	
	@Autowired
	private UiUtils uiUtils;
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	@GetMapping({"/", "/index", "/index/", "/index.html", 
		"/home", "/home/", "/home.html", "/dashboard.html", "/rajiv"})
    public String getHomePage() {
		return "admin/index";
    }
	
	@GetMapping("/reports.html")
    public String reports() {
		return "admin/reports";
    }
	
	@GetMapping("/manageProfile.html")
    public String manageProfile(ModelMap model) {
		return "admin/manage-profile";
	}
	
	@GetMapping("/settings.html")
    public String preferences(ModelMap model) {
		model.addAttribute("entityCol", preferenceService.getAll());
		return "admin/app-settings";
	}
	
	@GetMapping("/teamMembers.html")
    public String teamMembers(ModelMap model) {
		if(uiUtils.isChecked("showTeamMembers")) {
			model.addAttribute("entityCol", teamMemberService.getAll());
		}
		return "admin/team-members";
	}
	
	@GetMapping("/manageProjects.html")
    public String manageProjects(ModelMap model) {
		List<ProjectDetails> entityCol = projectService.getProjectDtls();
		model.addAttribute("entityCol", entityCol);
		return "admin/manage-projects";
	}
	
	@GetMapping("/createProject.html")
    public String createProject(ModelMap model) {
		model.addAttribute("pageBodyTitle", "Create new Project");
		model.addAttribute("entity", ProjectDetails.builder().build());
		return "admin/update-project";
	}
	
	@GetMapping("/editProject.html")
    public String editProject(@RequestParam (defaultValue = "0") String projectRefId,
    		ModelMap model) {
		if(processProject(projectRefId, model)) {
			model.addAttribute("pageBodyTitle", "Edit Project");
			return "admin/update-project";
		}
		return "redirect:/manageProjects.html";
	}
	
	@GetMapping("/projectDetails.html")
    public String viewProject(@RequestParam (defaultValue = "0") String projectRefId,
    		ModelMap model) {
		if(processProject(projectRefId, model)) {
			return "admin/project-details";
		}
		return "redirect:/manageProjects.html";
	}
	
	private boolean processProject(String projectRefId, ModelMap model) {
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectRefId);
			if(projectId > 0) {
				ProjectDetails projectDtls = projectService.get(projectId);
				model.addAttribute("entity", projectDtls);
				return true;
			}
		}catch(Exception ex) {
			log.error("Not able to get the project -> " + projectId);
		}
		return false;
	}
	
	@GetMapping("/queryEditor.html")
    public String dbEditor(ModelMap model) {
		return "admin/query-editor";
	}
=======
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.hackathon.ecominds.config.ui.UiUtils;
import com.db.hackathon.ecominds.model.ProjectDetails;
import com.db.hackathon.ecominds.service.PreferenceService;
import com.db.hackathon.ecominds.service.ProjectService;
import com.db.hackathon.ecominds.service.TeamMemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminPageController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private PreferenceService preferenceService;
	
	@Autowired
	private UiUtils uiUtils;
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	@GetMapping({"/", "/index", "/index/", "/index.html", 
		"/home", "/home/", "/home.html", "/dashboard.html", "/rajiv"})
    public String getHomePage() {
		return "admin/index";
    }
	
	@GetMapping("/reports.html")
    public String reports() {
		return "admin/reports";
    }
	
	@GetMapping("/manageProfile.html")
    public String manageProfile(ModelMap model) {
		return "admin/manage-profile";
	}
	
	@GetMapping("/settings.html")
    public String preferences(ModelMap model) {
		model.addAttribute("entityCol", preferenceService.getAll());
		return "admin/app-settings";
	}
	
	@GetMapping("/teamMembers.html")
    public String teamMembers(ModelMap model) {
		if(uiUtils.isChecked("showTeamMembers")) {
			model.addAttribute("entityCol", teamMemberService.getAll());
		}
		return "admin/team-members";
	}
	
	@GetMapping("/manageProjects.html")
    public String manageProjects(ModelMap model) {
		List<ProjectDetails> entityCol = projectService.getProjectDtls();
		model.addAttribute("entityCol", entityCol);
		return "admin/manage-projects";
	}
	
	@GetMapping("/createProject.html")
    public String createProject(ModelMap model) {
		model.addAttribute("pageBodyTitle", "Create new Project");
		model.addAttribute("entity", ProjectDetails.builder().build());
		return "admin/update-project";
	}
	
	@GetMapping("/editProject.html")
    public String editProject(@RequestParam (defaultValue = "0") String projectRefId,
    		ModelMap model) {
		if(processProject(projectRefId, model)) {
			model.addAttribute("pageBodyTitle", "Edit Project");
			return "admin/update-project";
		}
		return "redirect:/manageProjects.html";
	}
	
	@GetMapping("/projectDetails.html")
    public String viewProject(@RequestParam (defaultValue = "0") String projectRefId,
    		ModelMap model) {
		if(processProject(projectRefId, model)) {
			return "admin/project-details";
		}
		return "redirect:/manageProjects.html";
	}
	
	private boolean processProject(String projectRefId, ModelMap model) {
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectRefId);
			if(projectId > 0) {
				ProjectDetails projectDtls = projectService.get(projectId);
				model.addAttribute("entity", projectDtls);
				return true;
			}
		}catch(Exception ex) {
			log.error("Not able to get the project -> " + projectId);
		}
		return false;
	}
	
	@GetMapping("/queryEditor.html")
    public String dbEditor(ModelMap model) {
		return "admin/query-editor";
	}
>>>>>>> c0321aeaca5611185fd32fc903e670f98bcf9f01
}