/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.domain;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (13 Jun 2018)
 *
 */
public class ContextUtils {
	private static final Logger logger = LogManager.getLogger(ContextUtils.class);
	private static ObjectMapper mapper = new ObjectMapper();

	private ContextUtils() {
	}

	public static void initContext(Context context, HttpHeaders headers) throws IOException {
		context.setMethod(context.getMethod().trim().toUpperCase());

		initBindingMap(context);
		initHeader(context, headers);
	}

	private static void initBindingMap(Context context) throws IOException {
		if (context.getPayloadBindingMap() == null) {
			if (StringUtils.isEmpty(context.getPayloadBinding())) {
				context.setPayloadBindingMap(Collections.emptyList());
			} else {
				TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {
				};
				context.setPayloadBindingMap(mapper.readValue(context.getPayloadBinding(), typeRef));
			}

			if (logger.isDebugEnabled()) {
				logger.debug("payloadBindingMap: " + context.getPayloadBindingMap());
			}
		}
	}

	private static void initHeader(Context context, HttpHeaders headers) throws IOException {
		context.setHeaderMap(headers);

		if (!StringUtils.isEmpty(context.getHeaders())) {
			TypeReference<HashMap<String, List<String>>> typeRef = new TypeReference<HashMap<String, List<String>>>() {
			};
			headers.clear();
			headers.putAll(mapper.readValue(context.getHeaders(), typeRef));

			context.setHeaderMap(headers);
		}
	}
}