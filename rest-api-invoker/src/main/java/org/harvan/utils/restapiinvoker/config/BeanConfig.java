/*
 * Copyright 2018-2018 the original author or authors.
 */

package org.harvan.utils.restapiinvoker.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Harvan Irsyadi
 * @version 1.0.0
 * @since 1.0.0 (12 Jun 2018)
 *
 */
@Configuration
public class BeanConfig {
	@Bean
	public RestTemplate restTemplate() {
		PoolingHttpClientConnectionManager pccm = new PoolingHttpClientConnectionManager();
		HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(pccm).build();
		HttpComponentsClientHttpRequestFactory hcchrf = new HttpComponentsClientHttpRequestFactory();
		hcchrf.setHttpClient(httpClient);

		return new RestTemplate(hcchrf);
	}
}