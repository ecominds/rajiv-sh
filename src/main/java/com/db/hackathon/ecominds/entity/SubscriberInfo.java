/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
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
@Entity(name = "master_subscriber_info")
public class SubscriberInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recordId;
	
	@Column(name = "subscriber_name")
	private String name;
	
	@Column(name = "subscriber_email")
	private String email;
	
	@Column(name = "is_email_sent")
	private boolean emailSent;
	
	private Instant createdDate;
}