package com.ycl.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycl.zy.entity.User;
import com.ycl.zy.mapper.UserMapper;
import com.ycl.zy.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return userMapper.add(user);
	}

}
