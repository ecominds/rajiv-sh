/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 20, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.controller.rest;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.ecominds.model.AjaxResponse;
import com.db.hackathon.ecominds.service.PreferenceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ajax")
@Slf4j
public class AjaxPostRequestController {
	
	@Autowired
	private PreferenceService preferenceService;
	
	@PostMapping(value = "/executeQuery.html")
	public String add(@RequestParam(defaultValue = "") String queryTxt) {
		log.info(queryTxt);
		return "success";
	}
	
	@PostMapping(value = "/updateSettings.html")
	public AjaxResponse updatePref(HttpServletRequest request) {
		List<Integer> checkedRecordCol = new ArrayList<>();
		Enumeration<String> keys = request.getParameterNames();
		while(keys.hasMoreElements()) {
			checkedRecordCol.add(new Integer(keys.nextElement().replace("txt-", "")));
		}
		if(checkedRecordCol.size()> 0) {
			preferenceService.updateChecked(checkedRecordCol);
			return AjaxResponse.builder().data("success").build();
		}
		
		return AjaxResponse.builder().error(true).data("No data to update").build();
	}
}