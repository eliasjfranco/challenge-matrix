package com.matrix.challenge.util;

import java.io.IOException;
import java.util.Enumeration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		loggingActivity(req);
		filterChain.doFilter(req, res);
	}
	
	private void loggingActivity(HttpServletRequest req) {
		String params = "";
		Enumeration<String> parameters = req.getParameterNames();
		while (parameters.hasMoreElements()) {
			String p = parameters.nextElement();
			params = params.concat(p).concat(": " ).concat(req.getParameter(p)).concat(" ");
		}
		if (params.isEmpty())
			log.info("Request path: " + req.getServletPath() + " method: " + req.getMethod() + " without Parameters");
		else
			log.info("Request path: " + req.getServletPath() + " method: " + req.getMethod() + " Parameters: " + params);
	}

}
