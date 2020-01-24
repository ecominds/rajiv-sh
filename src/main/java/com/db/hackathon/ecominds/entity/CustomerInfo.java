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
@Entity(name = "master_user_info")
public class CustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recordId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailAdd;
	
	private int userRoleId;
	
	private String authSource;
	
	@Column(name = "is_logged_in")
	private boolean loggedIn;
	
	private int userStatusId;
	
	private Instant createdDate;
}