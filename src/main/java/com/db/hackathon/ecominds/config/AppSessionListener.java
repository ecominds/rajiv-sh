/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 22, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.config;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class AppSessionListener implements HttpSessionListener{
	
	private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        log.info("New session is created. Adding Session to the counter.");
        counter.incrementAndGet();
        updateSessionCounter(event);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        log.info("Session destroyed. Removing the Session from the counter.");
        counter.decrementAndGet();
        updateSessionCounter(event);
    }

    private void updateSessionCounter(HttpSessionEvent event){
    	event.getSession().getServletContext().setAttribute("activeSession", counter.get());
        log.info("Total active session are {} ",counter.get());
    }
}