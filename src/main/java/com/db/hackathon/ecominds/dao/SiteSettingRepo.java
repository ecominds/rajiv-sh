/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 20, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.hackathon.ecominds.entity.SiteSetting;

public interface SiteSettingRepo extends JpaRepository<SiteSetting, Integer>{

}