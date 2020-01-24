/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 19, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public final class PageService {
	
	private List<String> templateBasePath = 
			Arrays.asList("light-layout", "warm-layout");
	private String currentTemplate = templateBasePath.get(0);

	public String updateTemplate(String name) {
		return this.currentTemplate;
	}
	
	public String getTemplate(String mainPageName) {
		return this.currentTemplate + "/" + mainPageName;
	}
	
	public List<String> getAll(){
		return templateBasePath;
	}
}