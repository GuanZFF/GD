package pers.guanzf.test;

import redis.clients.jedis.Jedis;

public class Redis_Test {
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.0.138", 6379);
		jedis.auth("123");
		System.out.println(jedis.get("name"));
		jedis.close();
	}

}
