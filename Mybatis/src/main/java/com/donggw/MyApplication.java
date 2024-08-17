package com.donggw;

import com.mybatis.MapperProxyFactory;

import java.util.List;

public class MyApplication {
	public static void main(String[] args) {
		System.out.println("Hello and welcome!");

		UserMapper userMapper = MapperProxyFactory.getMapper(UserMapper.class);
		List<User> users = userMapper.getUser(null, "李逵", 18);
		System.out.println(users);


//		userMapper.getUserById(3);

	}
}