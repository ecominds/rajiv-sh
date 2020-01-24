/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db.hackathon.ecominds.entity.ProjectInfo;

public interface ProjectRepo extends JpaRepository<ProjectInfo, Integer>{
	/*
	 * @Query("SELECT p FROM ProjectInfo p WHERE p.activeflag = :activeflag") public
	 * List<ProjectInfo> findActiveProjects(@Param("activeflag") int activeflag);
	 */
}