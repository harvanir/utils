/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.controller;

import org.harvan.utils.restapiinvoker.domain.Context;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface WebExecutor {
	public String execute(Context context);
}