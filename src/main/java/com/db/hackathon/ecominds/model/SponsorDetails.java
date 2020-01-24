/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SponsorDetails {
	private String name;
	private String email;
	private String imgUrlPath;
	private double amtDonated;
	
	private int statusId;
}