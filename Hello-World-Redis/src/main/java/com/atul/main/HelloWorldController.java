package com.atul.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController 
{
	@Autowired
	RedisTemplate<String, Object> RedisServer;
	
	String key1="Key1";

	@Autowired
	RedisService redis;@Override
	public String toString() 
	{
		
		return super.toString();
	}
		
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(value=("/hello"))//,method = { RequestMethod.PUT })
	public ResponseEntity<String> Storeinredis(String value) throws Exception 
	{
		redis.set(value);		
		return ResponseEntity.status(HttpStatus.OK).body("this values should be displayed "+redis.hgetAll(key1));
	}
}
