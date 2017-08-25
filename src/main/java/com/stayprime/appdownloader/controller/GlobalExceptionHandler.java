package com.stayprime.appdownloader.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception Handler class
 * @author sarthak
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = FileNotFoundException.class)
    public void handle(FileNotFoundException ex, HttpServletResponse response) throws IOException {
        log.error("Handling file not found exception");
        response.sendError(404, ex.getMessage());
    }

    @ExceptionHandler(value = IOException.class)
    public void handle(IOException ex, HttpServletResponse response) throws IOException {
        log.error("Handling io exception");
        response.sendError(500, ex.getMessage());
    }
}
