package com.ycl.zy.mapper;

import java.util.List;

import com.ycl.zy.entity.User;

public interface UserMapper {
	
	List<User> list();
	
	int add(User user);
}
