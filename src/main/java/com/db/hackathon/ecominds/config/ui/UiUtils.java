/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 22, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.config.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.db.hackathon.ecominds.entity.SiteSetting;

@Component
public final class UiUtils {
	
	private Map<String, Boolean> prefCol;
	
	public void init(List<SiteSetting> entities) {
		prefCol = new HashMap<String, Boolean>();
		entities.stream().forEach(item -> {
			prefCol.put(item.getKeyToAccess(), item.isChecked());
		});
	}
	
	public boolean isChecked(String key) {
		return prefCol.containsKey(key);
	}
}