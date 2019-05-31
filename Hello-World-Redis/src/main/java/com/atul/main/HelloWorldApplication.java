package com.atul.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@SpringBootApplication
public class HelloWorldApplication 
{

	//this is redis connection 
	private static final String REDIS_URL = "redis-11109.c99.us-east-1-4.ec2.cloud.redislabs.com";
	private static final int REDIS_PORT = 11109;
	private static final String REDIS_PASSWORD="rrvkdlbsCqMrHj70bTT14Wc5ApOrVnpW";
	
	@Bean
	JedisConnectionFactory jedisconnectionfactory()
	{
		return new JedisConnectionFactory();
	}
	
	
	@Bean
	@Primary
	public JedisConnectionFactory redisConnectionFactory()
	{
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(REDIS_URL, REDIS_PORT);
		config.setPassword(RedisPassword.of(REDIS_PASSWORD));

		return new JedisConnectionFactory(config);
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() 
	{
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(redisConnectionFactory());
	    template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
	    return template;
	}
	
	
	public static void main(String[] args) 
	{
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	
	
	
}
