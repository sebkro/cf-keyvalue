package com.sebkro.keyvalue.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class CloudKeyValueService implements KeyValueService {
	
	@Autowired
	private RedisTemplate<String, String> template;
	
	@Override
	public void store(String key, String value) {
		template.boundValueOps(key).set(value, 60L, TimeUnit.SECONDS);
	}

	@Override
	public String get(String key) {
		return template.boundValueOps(key).get();
	}
	
	

}
