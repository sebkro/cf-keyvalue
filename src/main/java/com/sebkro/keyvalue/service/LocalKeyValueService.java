package com.sebkro.keyvalue.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class LocalKeyValueService implements KeyValueService {
	
	Logger logger = Logger.getLogger(LocalKeyValueService.class);
	
	private Map<String, String> internalStorage = new HashMap<>();
	
	@Override
	public void store(String key, String value) {
		internalStorage.put(key, value);
		logger.info(internalStorage);
	}

	@Override
	public String get(String key) {
		logger.info("Get value for key " + key +". Internal storage: " + internalStorage);
		String result = internalStorage.get(key);
		logger.info("found value " + result + " for key " + key);
		return result;
	}
	
	

}
