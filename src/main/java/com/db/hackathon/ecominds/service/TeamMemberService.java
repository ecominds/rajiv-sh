/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 22, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.hackathon.ecominds.dao.TeamMemberRepo;
import com.db.hackathon.ecominds.entity.TeamMember;

@Service
public class TeamMemberService {
	@Autowired
	private TeamMemberRepo repo;
	
	public List<TeamMember> getAll(){
		return repo.findAll();
	}
}