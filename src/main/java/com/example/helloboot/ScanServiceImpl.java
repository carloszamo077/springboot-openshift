/**
 * Copyright 2021 Banco de Costa Rica.
 * 
 * All rights reserved.
 */
package com.example.helloboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScanServiceImpl implements ScanService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScanServiceImpl.class);

	@Override
	public Object lista(Object request) {
		LOGGER.debug("IN lista(): {}", request);

		LOGGER.debug("OUT lista(): {}", "");
		return null;
	}

}