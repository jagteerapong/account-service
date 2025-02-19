package com.account.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.response.ResponseMessage;

@RestController
@RequestMapping(path = "/cache", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CacheController {
	private static final Logger log = LogManager.getLogger(CacheController.class);
	
	private final CacheManager cacheManager;
	
	public CacheController(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	@GetMapping(value = "/clear-cache")
	public ResponseEntity<ResponseMessage> clearCache() {
		log.info("clear-cache start");
		for(String cacheName : cacheManager.getCacheNames()) {
			cacheManager.getCache(cacheName).clear();
			log.info("clear-cache name : {}", cacheName);
		}
		log.info("clear-cache succes");
		return new ResponseEntity<>(new ResponseMessage(), HttpStatus.OK);
	}
}
