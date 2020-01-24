/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 22, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.hackathon.ecominds.entity.TeamMember;

public interface TeamMemberRepo extends JpaRepository<TeamMember, Integer> {

}