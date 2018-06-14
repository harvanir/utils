/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.controller;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (13 Jun 2018)
 *
 */
@Service
public class DefaultExecutorFactory implements ExecutorFactory {
	private final Map<Method, WebExecutor> executorMap = new EnumMap<>(Method.class);
	private RestTemplate restTemplate;

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostConstruct
	public void init() {
		executorMap.put(Method.GET, new GetExecutor(restTemplate));
		executorMap.put(Method.POST, new PostExecutor(restTemplate));
	}

	@Override
	public WebExecutor getExecutor(Method method) {
		return executorMap.get(method);
	}
}