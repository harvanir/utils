/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.controller;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (13 Jun 2018)
 *
 */
public enum Method {
	GET("GET"), POST("POST");
	private final String value;

	private Method(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}