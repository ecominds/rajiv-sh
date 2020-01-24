/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.hackathon.ecominds.model.HomePageCounter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomJdbcService {
	
	@Autowired
	private DataSource dataSource;
	
	public boolean addToSubscriber(String emailAddress, String userName) {
		boolean result = false;
		try(Connection conn = dataSource.getConnection()){
			try(PreparedStatement psmt = conn.prepareStatement("INSERT INTO master_subscriber_info (subscriber_email, subscriber_name) VALUES(?,?)")){
				psmt.setString(1, emailAddress);
				psmt.setString(2, userName);
				if(psmt.executeUpdate() == 1) {
					result = true;
				}
			}
		}catch(Exception ex) {
			log.error("Error in addToSubscriber for " + emailAddress, ex);
		}
		return result;
	}
	
	public Set<String> getAll() {
		Set<String> col = new TreeSet<String>();
		try(Connection conn = dataSource.getConnection()){
			try(PreparedStatement psmt = conn.prepareStatement("SELECT TOP (1000) * FROM dbo.master_subscriber_info")){
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					col.add(rs.getString("subscriber_email"));
				}
			}
		}catch(Exception ex) {
			log.error("Error in getAll subscriber", ex);
		}
		return col;
	}
	
	public HomePageCounter getCounters() {
		HomePageCounter counter = new HomePageCounter();
		try(Connection conn = dataSource.getConnection()){
			try(PreparedStatement psmt = conn.prepareStatement("select count(distinct u.record_id) user_count, count(distinct p.record_id) project, sum(t.txn_amt) amount from\r\n" + 
					"master_project_info p, master_user_info u, txn_project_ledger t where\r\n" + 
					"u.record_id=t.user_ref_id and p.record_id=t.project_ref_id and p.is_active=1 and u.user_status_id=1")){
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					counter.setUserCount("" + rs.getInt(1));
					counter.setProject("" + rs.getInt(2));
					counter.setAmount("" + rs.getDouble(3));
				}
			}
		}catch(Exception ex) {
			log.error("Error in getCounters", ex);
		}
		return counter;
	}
	
	public double getRaisedFundAmt(int recordId) {
		double amt = 0;
		try(Connection conn = dataSource.getConnection()){
			try(PreparedStatement psmt = conn.prepareStatement("SELECT SUM(txn_amt) FROM txn_project_ledger where project_ref_id=?")){
				psmt.setInt(1, recordId);
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					amt = rs.getDouble(1);
				}
			}
		}catch(Exception ex) {
			log.error("Error in getCounters", ex);
		}
		return amt;
	}
}