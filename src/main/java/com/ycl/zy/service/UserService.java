package com.ycl.zy.service;

import java.util.List;

import com.ycl.zy.entity.User;

public interface UserService {
	
	
	List<User> list();
	
	int add(User user);
}
