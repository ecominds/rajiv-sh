/**
 * @Developer   : Rajiv Kumar
 * @CreatedDate : Oct 22, 2019
 * @Version     : 1.0.0
 */
package com.db.hackathon.ecominds.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.hackathon.ecominds.config.ui.UiUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(urlPatterns = {"/admin/*", "/", "*.html", "/ajax/*"})
public class AppCustomConfig implements Filter{

	private ServletContext context;

	@Autowired
	private UiUtils uiUtils;;

	@Override
	public void init(FilterConfig filterConfig) {
		this.context = filterConfig.getServletContext();
		context.setAttribute("uiUtils", uiUtils);
		log.info("========================setServletContext" + this.context.getAttribute("uiUtils"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		log.info("Request URI is: " + req.getRequestURI());
		chain.doFilter(request, response);
	}
}