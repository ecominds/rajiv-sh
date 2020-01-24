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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "master_project_info")
public class ProjectInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recordId;
	
	@Column(name = "project_name")
	private String name;
	
	@Column(name = "project_title")
	private String title;
	
	private String shortDesc;
	private String longDesc;
	
	private String imgUrlPath;
	
	private String projectInitiator;
	
	private Double targetAmt;
	
	private Instant startDate;
	private Instant expectedClosureDate;
	
	private int completionStageId;
	
	@Column(name = "is_active")
	private boolean active;
	
	private Instant createdDate;
}