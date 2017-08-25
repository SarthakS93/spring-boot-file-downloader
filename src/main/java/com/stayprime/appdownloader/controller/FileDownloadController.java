package com.stayprime.appdownloader.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * File Download controller
 * Used below link as resource
 * http://memorynotfound.com/spring-mvc-download-file-examples/
 * @author sarthak
 *
 */
@Controller
@RequestMapping("/")
public class FileDownloadController {
	
	private static final Logger log = LoggerFactory.getLogger(FileDownloadController.class);
	
	/**
	 * Controller to start download of file of given path
	 * @param path
	 * @param response
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/app", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void func(@RequestParam("path") String path, HttpServletResponse response) throws IOException, FileNotFoundException {
		log.info("Dowload file - {}", path);
		File file = getFile(path);
	    InputStream in = new FileInputStream(file);
	    response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
	    response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
	    response.setHeader("Content-Length", String.valueOf(file.length()));
	    FileCopyUtils.copy(in, response.getOutputStream());
	}

	private File getFile(String path) throws FileNotFoundException {
		File file = new File(path);
		if (!file.exists()) {
			log.info("File with path - {} not found", path);
            throw new FileNotFoundException();		
        }
		log.info("File fetched from system, now starting download");
		return file;
	}
	
}
