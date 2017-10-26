package com.sebkro.keyvalue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sebkro.keyvalue.service.KeyValueService;
import com.sebkro.keyvalue.service.LocalKeyValueService;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Bean
	public KeyValueService keyValueService() {
		return new LocalKeyValueService();
	}

}
