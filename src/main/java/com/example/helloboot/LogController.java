/**
 * Copyright 2021 Banco de Costa Rica.
 * 
 * All rights reserved.
 */
package com.example.helloboot;

import java.io.File;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(value = "LogController Controller")
public class LogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

	@Value("${logging.file.name}")
	private String loggingFileName;

	@ApiOperation(value = "Api de Logs", notes = "Api donde se pueden visualizar hasta 150KB de logs")
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String log() {
		String content = null;
		try {
			File file = ResourceUtils.getFile(loggingFileName);

			LOGGER.info("Archivo de log encontrado: {}", file.exists());
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (Exception e) {
			LOGGER.error("Error leyendo el archivo de log: {}", loggingFileName, e);
			content = e.getMessage();
		}
		return content;
	}
}