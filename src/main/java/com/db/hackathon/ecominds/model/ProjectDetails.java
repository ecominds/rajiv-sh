/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.model;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDetails {
	private Integer recordId;
	private String name;
	private String title;
	
	private String shortDesc;
	private String longDesc;
	
	private String imgUrlPath;
	
	private String projectInitiator;
	
	private Double targetAmt;
	private Double fundRaised;
	private int completed;
	
	private Instant startDate;
	private Instant expectedClosureDate;
	
	private ProjectStage projectStage;
	private boolean active;
	
	List<SponsorDetails> sponsorCol;
}