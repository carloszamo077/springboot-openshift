/**
 * Copyright 2021 Banco de Costa Rica.
 * 
 * All rights reserved.
 */
package com.example.helloboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(value = "ScanController Controller")
public class ScanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScanController.class);

	@Autowired
	private ScanService scanService;

	@ApiOperation(value = "Scan", notes = "SafeWatch Scan")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class) })
	@RequestMapping(value = "/lista/v1", method = RequestMethod.GET)
	public ResponseEntity<Object> lista(@RequestParam String texto) {
		LOGGER.debug("REQUEST: {}", texto);

		Object body = scanService.lista(texto);

		String resp = System.getenv().getOrDefault("HOSTNAME", "localhost");

		LOGGER.debug("RESPONSE: {}", body);
		return ResponseEntity.ok(resp);
	}
}