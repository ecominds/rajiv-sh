/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.hackathon.ecominds.entity.CustomerInfo;

public interface CustomerRepo extends JpaRepository<CustomerInfo, Integer>{
	
}