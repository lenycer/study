package com.lenycer.config;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenycer.domain.error.SimpleBootError;

import lombok.extern.slf4j.Slf4j;

/**
 * AbstractExceptionResolver 구현
 * 한 project에서 공통으로 exceptoin을 처리하면서 accept에 따라 다르게 처리해야 할 경우.
 * @author 현석
 *
 */
@Slf4j
@Component
public class SimpleBootExceptionResolver extends AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse res, Object handler,
			Exception exception) {
		ModelAndView model = new ModelAndView();
		try {
			String accept = req.getHeader(HttpHeaders.ACCEPT);
			String contentType = req.getHeader(HttpHeaders.CONTENT_TYPE);
			log.debug("exception accept : {}", accept);
			log.debug("exception contentType : {}", contentType);
			//TODO null2string and case sensitive ignore and error object define
			if("application/json".equals(accept) || "application/json".equals(contentType)) {
				ObjectMapper mapper = new ObjectMapper();
				SimpleBootError error = new SimpleBootError();
				error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				error.setReasonPhrase(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
				error.setErrorMessage(exception.getMessage());
				String json = mapper.writeValueAsString(error);
				log.debug("exception json : {}", json);
				PrintWriter out = res.getWriter();
				out.print(json);
				out.flush();
				out.close(); //close 처리?
			} else {
				model.setViewName("view-error");
				model.addObject("ex", exception);
			}
		} catch(Exception e) {
			log.error("Exception Resolver Error : {}", e);
		}
		return model;
	}

}
