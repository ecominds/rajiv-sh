/**
 * Deutsche Bank
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 9, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@ServletComponentScan
public class GreenGuardianWebAppStarter implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(GreenGuardianWebAppStarter.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		log.info("Message from ---------------------- GreenGuardianWebAppStarter");
		System.out.println("-----------------------------------HELLO WORLD");
        return builder.sources(GreenGuardianWebAppStarter.class);
    }

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void run(String... args) throws Exception {
		try(Connection conn = dataSource.getConnection()){
			try(ResultSet rs = conn.prepareStatement("select count(1) from master_user_role").executeQuery()){
				if(rs.next()) {
					if(rs.getInt(1) == 0) {
						log.info("Starting Initialization ...");
						Resource initData = new ClassPathResource("data-init.sql");
						DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initData);
					    DatabasePopulatorUtils.execute(databasePopulator, dataSource);
					    log.info("Initialization COMPLETED");
					}else {
						log.warn("ALREADY INITIALIZED");
					}
				}
			}catch(Exception ex) {
				log.error("Exception in Initialization => ", ex);
			}
		}
	}
}