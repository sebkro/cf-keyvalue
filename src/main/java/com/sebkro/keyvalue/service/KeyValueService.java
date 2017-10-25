package com.sebkro.keyvalue.service;

public interface KeyValueService {
	
	public String get(String key);
	public void store(String key, String value);

}
