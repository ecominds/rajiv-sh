/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 20, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "master_site_settings")
public class SiteSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recordId;
	
	@Column(name = "key_to_access")
	private String keyToAccess;
	
	private String title;
	
	private String shortDesc;
	
	@Column(name = "is_checked")
	private boolean checked;
	
	@Column(name = "is_active")
	private boolean active;
	
	private Instant createdDate;
}