/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.exception;

public class RecordNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException() {
		super();
	}
	
	public RecordNotFoundException(String msg) {
		super(msg);
	}
}