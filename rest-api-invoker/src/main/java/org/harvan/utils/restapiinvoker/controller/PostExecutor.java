/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.harvan.utils.restapiinvoker.domain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (13 Jun 2018)
 *
 */
public class PostExecutor implements WebExecutor {
	private final Logger logger = LogManager.getLogger(getClass());
	private RestTemplate rt;

	public PostExecutor(RestTemplate rt) {
		this.rt = rt;
	}

	private String getKey(Map.Entry<String, Object> entry) {
		StringBuilder buff = new StringBuilder();
		buff.append("${").append(entry.getKey()).append("}");
		String key = buff.toString();

		if (logger.isDebugEnabled()) {
			logger.debug("key: " + key);
		}

		return key;
	}

	@Override
	public String execute(Context context) {
		String payload = context.getPayload();

		if (logger.isDebugEnabled()) {
			logger.debug("payload before: " + payload);
		}

		int loop = context.getCurrentLoop();
		for (Map.Entry<String, Object> entry : context.getPayloadBindingMap().get(loop).entrySet()) {
			payload = payload.replace(getKey(entry), entry.getValue().toString());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("payload after: " + payload);
		}

		HttpEntity<String> request = new HttpEntity<>(payload, context.getHeaderMap());

		return rt.postForObject(context.getUrl(), request, String.class);
	}
}