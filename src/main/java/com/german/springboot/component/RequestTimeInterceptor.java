package com.german.springboot.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(RequestTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long startTime = System.currentTimeMillis();
		log.info("Request -- " + request.getRequestURI().toString() + " Tiempo --- " + (System.currentTimeMillis() - startTime) + " ms.");
		super.afterCompletion(request, response, handler, ex);
	}
}
