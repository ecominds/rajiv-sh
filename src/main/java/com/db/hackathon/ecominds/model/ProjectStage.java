/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.model;

public enum ProjectStage {
	STARTED(1),
	COMPLETED(2)
	;
	
	private ProjectStage(int id) {
		this.id = id;
	}
	public final int id;
	
	public static ProjectStage get(int id) {
		if(id == COMPLETED.id) {
			return COMPLETED;
		}
		return STARTED;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}