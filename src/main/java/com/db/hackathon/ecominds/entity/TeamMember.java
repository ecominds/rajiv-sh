/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 22, 2019
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
@Entity(name = "master_team_member")
public class TeamMember {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recordId;
	
	private String firstName;
	private String lastName;
	
	private String emailAdd;
	private String address;
	private String contactNo;
	
	private String gender;
	
	@Column(name = "img_url_path")
	private String imgPath;
	
	private int userRoleId;
	@Column(name = "about_me")
	private String about;

	@Column(name = "is_logged_in")
	private boolean loggedIn;
	
	private int statusId;
	
	private Instant createdDate;
}