package com.atul.main;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.data.redis.connection.RedisCommands;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.collections.DefaultRedisMap;
import org.springframework.stereotype.Service;

@Service
public class RedisService 
{
	String key1="Key1";
		
@Autowired
public RedisTemplate<String, Object> redisServer;

public int random()
{
	Random rand=new Random();
	int randnumber=rand.nextInt(100);
	
	return randnumber;
	
}
String value1 = "hash_key1";
String value2 ="hash_key2";
String value3 ="hash_key3";

public void set(String value)throws Exception
{
	
	HashOperations<String, Object, Object> hashoperation = redisServer.opsForHash();
	
	hashoperation.put(key1, value1, random());
	hashoperation.put(key1, value2, random());
	hashoperation.put(key1, value3, random());
		
}

public Map<String, Object> hgetAll(String key) 
{
       return redisServer.<String, Object>opsForHash().entries(key1);
	
}

}