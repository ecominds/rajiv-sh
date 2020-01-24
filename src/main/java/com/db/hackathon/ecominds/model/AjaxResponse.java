/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 22, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AjaxResponse {
	private String id;
	private boolean error;
	private Object data;
}