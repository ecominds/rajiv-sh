/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.hackathon.ecominds.dao.ProjectRepo;
import com.db.hackathon.ecominds.entity.ProjectInfo;
import com.db.hackathon.ecominds.exception.RecordNotFoundException;
import com.db.hackathon.ecominds.model.ProjectDetails;
import com.db.hackathon.ecominds.model.ProjectStage;
import com.db.hackathon.ecominds.model.SponsorDetails;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private CustomJdbcService jdbcService;
	
	public List<ProjectInfo> getAll() {
		return getAll(9);
	}
	
	public List<ProjectInfo> getAll(int maxLimit) {
		List<ProjectInfo> col =  projectRepo.findAll();
		return col.stream().filter(p -> p.isActive())
		.limit(maxLimit)
		.collect(Collectors.toList());
	}
	
	public ProjectDetails get(int recordId)throws RecordNotFoundException {
		ProjectInfo projectInfo = projectRepo.findById(recordId).orElseThrow(() -> new RecordNotFoundException("Not found"));
		ProjectDetails obj = convert(projectInfo);
		return updateFundRaisedVal(obj);
	}

	/**
	 * @param projectInfo
	 * @return
	 */
	private ProjectDetails convert(ProjectInfo projectInfo) {
		ProjectDetails obj = ProjectDetails.builder().
		recordId(projectInfo.getRecordId()).
		name(projectInfo.getName()).
		title(projectInfo.getTitle()).
		shortDesc(projectInfo.getShortDesc()).
		longDesc(projectInfo.getLongDesc()).
		imgUrlPath(projectInfo.getImgUrlPath()).
		projectInitiator(projectInfo.getProjectInitiator()).
		targetAmt(projectInfo.getTargetAmt()).
		projectStage(ProjectStage.get(projectInfo.getCompletionStageId())).
		startDate(projectInfo.getStartDate()).
		expectedClosureDate(projectInfo.getExpectedClosureDate()).
		active(projectInfo.isActive()).build();
		return obj;
	}

	/**
	 * @param obj
	 */
	private ProjectDetails updateFundRaisedVal(ProjectDetails obj) {
		double rasiedFundAmt = jdbcService.getRaisedFundAmt(obj.getRecordId());
		obj.setFundRaised(rasiedFundAmt);
		
		int completddPercentage = (int)(rasiedFundAmt * 100/obj.getTargetAmt());
		obj.setCompleted(completddPercentage);
		if(rasiedFundAmt >= obj.getTargetAmt()) {
			completddPercentage = 100;
			obj.setProjectStage(ProjectStage.COMPLETED);
		}
		return obj;
	}

	public List<ProjectDetails> getProjectDtls() {
		List<ProjectInfo> col = getAll();
		List<ProjectDetails> resultCol = col.stream()
				.map(info -> {
					ProjectDetails dtls = convert(info);
					updateSponsors(dtls);
					return updateFundRaisedVal(dtls);
				})
				.collect(Collectors.toList());
		return resultCol;
	}
	
	// TODO -- Dummy Code
	private void updateSponsors(ProjectDetails dtls) {
		Stream<String> stream = null;
		if(dtls.getRecordId() == 1) {
			stream = Stream.of("user4-128x128.png", "user1-128x128.png", "user2-128x128.png");
		}
		else if(dtls.getRecordId() == 2) {
			stream = Stream.of("user3-128x128.png", "user2-128x128.png");
		}else if(dtls.getRecordId() == 2) {
			stream = Stream.of("rajiv-128x128.png", "user4-128x128.png");
		}else {
			stream = Stream.of("user4-128x128.png", "user2-128x128.png");
		}
		List<SponsorDetails> sponsorCol = stream.map(imgName -> SponsorDetails.builder().imgUrlPath(imgName).build())
				.collect(Collectors.toList());
		dtls.setSponsorCol(sponsorCol);
	}

	/**
	 * @return
	 */
	public Object getTeamMembers() {
		return null;
	}
}