package com.german.springboot.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.german.springboot.entity.Log;
import com.german.springboot.repository.LogRepository;

@Component
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(RequestTimeInterceptor.class);

	@Autowired
	private LogRepository logRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long startTime = System.currentTimeMillis();
		log.info("Request -- " + request.getRequestURI().toString() + " Tiempo --- " + (System.currentTimeMillis() - startTime) + " ms.");
		String url = request.getRequestURI().toString();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.isAuthenticated()) {
//			logRepository.save(new Log(new Date(), auth.getDetails().toString(), auth.getName(), url));	
		}
		super.afterCompletion(request, response, handler, ex);
	}
}
