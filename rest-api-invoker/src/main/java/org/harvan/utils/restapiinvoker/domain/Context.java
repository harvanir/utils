/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (12 Jun 2018)
 *
 */
public class Context implements Serializable {
	private static final long serialVersionUID = 8627458932335453425L;
	private String url;
	private String method;
	private String payload;
	private String payloadBinding;
	private transient List<HashMap<String, Object>> payloadBindingMap;
	private Integer currentLoop;
	private String headers;
	private HttpHeaders headerMap;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getPayloadBinding() {
		return payloadBinding;
	}

	public void setPayloadBinding(String payloadBinding) {
		this.payloadBinding = payloadBinding;
	}

	public List<HashMap<String, Object>> getPayloadBindingMap() {
		return payloadBindingMap;
	}

	public void setPayloadBindingMap(List<HashMap<String, Object>> payloadBindingMap) {
		this.payloadBindingMap = payloadBindingMap;
	}

	public Integer getCurrentLoop() {
		return currentLoop;
	}

	public void setCurrentLoop(Integer currentLoop) {
		this.currentLoop = currentLoop;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public HttpHeaders getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(HttpHeaders headerMap) {
		this.headerMap = headerMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Context [url=");
		builder.append(url);
		builder.append(", method=");
		builder.append(method);
		builder.append(", payload=");
		builder.append(payload);
		builder.append(", payloadBinding=");
		builder.append(payloadBinding);
		builder.append(", payloadBindingMap=");
		builder.append(payloadBindingMap);
		builder.append(", currentLoop=");
		builder.append(currentLoop);
		builder.append(", headers=");
		builder.append(headers);
		builder.append(", headerMap=");
		builder.append(headerMap);
		builder.append("]");
		return builder.toString();
	}
}