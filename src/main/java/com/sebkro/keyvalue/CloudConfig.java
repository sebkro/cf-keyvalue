package com.sebkro.keyvalue;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.common.RedisServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.sebkro.keyvalue.service.CloudKeyValueService;
import com.sebkro.keyvalue.service.KeyValueService;

@Configuration
@Profile("cloud")
public class CloudConfig {

	@Bean
    public RedisConnectionFactory redisConnectionFactory() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        RedisServiceInfo serviceInfo = (RedisServiceInfo) cloud.getServiceInfo("keyvalue-redisstore");
        String serviceID = serviceInfo.getId();
        return cloud.getServiceConnector(serviceID, RedisConnectionFactory.class, null);
    }

	@Bean
	public KeyValueService cloudKeyValueService() {
		return new CloudKeyValueService();
	}

}
