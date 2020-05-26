package com.ycl.zy.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ycl.util.RandomUtil;
import com.ycl.util.StringUtil;
import com.ycl.zy.entity.User;
import com.ycl.zy.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceImplTest {
	
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	
	@Autowired
	private UserService userService;

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStringJdk() {
		//记录开始时间
				long starTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName(StringUtil.generateChineseName());
			int random = RandomUtil.random(1, 2);
			if(random==1) {
				user.setSex("男");
			}else {
				user.setSex("女");
			}
			user.setPhone("13"+RandomUtil.randomNumber(9));
			String [] str = {"@qq.com","@163.com","@gmail.com","@sohu.co","@hotmail.com"};
			String string = RandomUtil.randomString(RandomUtil.random(3, 20));
			user.setEmail(string+""+str[RandomUtil.random(0, str.length-1)]);
			user.setBirth(RandomUtil.random(18, 70));
			userService.add(user);
			redisTemplate.opsForValue().set("shuju", user);
			//记录结束时间
			long endTime = System.currentTimeMillis();
			//相减计算耗时
			System.out.println("采用了JDK序列化的方式存储了10条数据一共耗时:"+(endTime-starTime));
			
		}
	}
	
	
	
	@Test
	public void testAddStringjson() {
		//记录开始时间
		long starTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName(StringUtil.generateChineseName());
			int random = RandomUtil.random(1, 2);
			if(random==1) {
				user.setSex("男");
			}else {
				user.setSex("女");
			}
			user.setPhone("13"+RandomUtil.randomNumber(9));
			String [] str = {"@qq.com","@163.com","@gmail.com","@sohu.co","@hotmail.com"};
			String string = RandomUtil.randomString(RandomUtil.random(3, 20));
			user.setEmail(string+""+str[RandomUtil.random(0, str.length-1)]);
			user.setBirth(RandomUtil.random(18, 70));
			userService.add(user);
			redisTemplate.opsForValue().set("shuju", user);
			
			//记录结束时间
			long endTime = System.currentTimeMillis();
			//相减计算耗时
			System.out.println("采用json序列化的方式存储了10条数据一共耗时:"+(endTime-starTime));
			
		}
	}
	
	
	
	@Test
	public void testAddHashJDK() {
		//记录开始时间
		long starTime = System.currentTimeMillis();
		
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName(StringUtil.generateChineseName());
			int random = RandomUtil.random(1, 2);
			if(random==1) {
				user.setSex("男");
			}else {
				user.setSex("女");
			}
			user.setPhone("13"+RandomUtil.randomNumber(9));
			String [] str = {"@qq.com","@163.com","@gmail.com","@sohu.co","@hotmail.com"};
			String string = RandomUtil.randomString(RandomUtil.random(3, 20));
			user.setEmail(string+""+str[RandomUtil.random(0, str.length-1)]);
			user.setBirth(RandomUtil.random(18, 70));
			userService.add(user);
			redisTemplate.opsForHash().put("shuju", "name", user);
			
		}
		//记录结束时间
		long endTime = System.currentTimeMillis();
		//相减计算耗时
		System.out.println("采用了Hash:JDK序列化的方式存储了10条数据一共耗时:"+(endTime-starTime));
	}
	
	
	@Test
	public void testAddHashJSON() {
		//记录开始时间
			long starTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName(StringUtil.generateChineseName());
			int random = RandomUtil.random(1, 2);
			if(random==1) {
				user.setSex("男");
			}else {
				user.setSex("女");
			}
			user.setPhone("13"+RandomUtil.randomNumber(9));
			String [] str = {"@qq.com","@163.com","@gmail.com","@sohu.co","@hotmail.com"};
			String string = RandomUtil.randomString(RandomUtil.random(3, 20));
			user.setEmail(string+""+str[RandomUtil.random(0, str.length-1)]);
			user.setBirth(RandomUtil.random(18, 70));
			userService.add(user);
			redisTemplate.opsForHash().put("shuju", "name", user);
			
			//记录结束时间
			long endTime = System.currentTimeMillis();
			//相减计算耗时
			System.out.println("采用了Hash:json序列化的方式存储了10条数据一共耗时:"+(endTime-starTime));
		}
	}

}
