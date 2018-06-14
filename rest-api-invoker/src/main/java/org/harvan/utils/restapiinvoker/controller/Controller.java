/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.harvan.utils.restapiinvoker.domain.Context;
import org.harvan.utils.restapiinvoker.domain.ContextUtils;
import org.harvan.utils.restapiinvoker.domain.ContractAfterSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (12 Jun 2018)
 *
 */
@RequestMapping("/rest-api-invoker")
@RestController
public class Controller {
	private final Logger logger = LogManager.getLogger(getClass());
	private ExecutorFactory executorFactory;

	@Autowired
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		this.executorFactory = executorFactory;
	}

	@PostMapping(path = "/invoke", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String postInvoke(Context context, @RequestHeader HttpHeaders headers) throws IOException {
		ContextUtils.initContext(context, headers);

		WebExecutor executor = executorFactory.getExecutor(Method.valueOf(context.getMethod()));
		Assert.notNull(executor, String.format("Executor not found for %s", context.getMethod()));

		int size = context.getPayloadBindingMap().size();
		List<Object> result = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			try {
				context.setCurrentLoop(i);
				result.add(executor.execute(context));
			} catch (Exception e) {
				logger.error("Error execute request.", e);

				result.add(e.toString());
			}
		}

		return result.toString();
	}

	@PostMapping("/test")
	public ContractAfterSales test(ContractAfterSales params) {
		return params;
	}
}