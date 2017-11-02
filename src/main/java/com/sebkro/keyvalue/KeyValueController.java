package com.sebkro.keyvalue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sebkro.keyvalue.service.KeyValueService;
import com.sebkro.keyvalue.service.LocalKeyValueService;

@RestController
@RefreshScope
public class KeyValueController {
	
	@Value("${info.value:no value}")
	private String special;
	
	Logger logger = Logger.getLogger(LocalKeyValueService.class);
	
	@Autowired
	private KeyValueService keyValueService;
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json", path="keyvalue/{key}", consumes="application/json")
	public void storeValue(@PathVariable(name="key")String key, @RequestBody(required=true) String value) {
		logger.info("store value" + value + " for key " + key);
		keyValueService.store(key, value);
	}	

	@RequestMapping(method=RequestMethod.GET, produces="application/json", path="keyvalue/{key}")
	public String getValue(@PathVariable(name="key")String key) {
		logger.info("get value for key " + key);
		return keyValueService.get(key);
	}	

	@RequestMapping(method=RequestMethod.GET, produces="application/json", path="configvalue")
	public String getConfgiValue() {
		return special;
	}	
	
	
	

}
