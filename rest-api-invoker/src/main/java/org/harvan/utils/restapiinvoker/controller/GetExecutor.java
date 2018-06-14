/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.controller;

import org.harvan.utils.restapiinvoker.domain.Context;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (13 Jun 2018)
 *
 */
public class GetExecutor implements WebExecutor {
	private RestTemplate rt;

	public GetExecutor(RestTemplate rt) {
		this.rt = rt;
	}

	@Override
	public String execute(Context context) {
		return rt.getForObject(context.getUrl(), String.class);
	}
}