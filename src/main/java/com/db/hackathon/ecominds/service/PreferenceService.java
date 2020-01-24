/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 20, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.hackathon.ecominds.config.ui.UiUtils;
import com.db.hackathon.ecominds.dao.SiteSettingRepo;
import com.db.hackathon.ecominds.entity.SiteSetting;

@Service
public class PreferenceService {

	@Autowired
	private SiteSettingRepo repo;
	
	@Autowired
	private UiUtils uiUtils;
	
	private List<SiteSetting> entities;
	
	@PostConstruct
	public void initAll() {
		entities = repo.findAll();
		uiUtils.init(entities);
	}
	
	public List<SiteSetting> getAll() {
		synchronized (this) {
			if(entities == null) {
				initAll();
			}
		}
		return entities;
	}
	
	public void updateChecked(List<Integer> checkedRecordCol) {
		synchronized (entities) {
			entities.stream().forEach(item -> {
				if(checkedRecordCol.contains(item.getRecordId())) {
					item.setChecked(true);
				}else {
					item.setChecked(false);
				}
			});
			repo.saveAll(entities);
			uiUtils.init(entities);
		}
	}
}
