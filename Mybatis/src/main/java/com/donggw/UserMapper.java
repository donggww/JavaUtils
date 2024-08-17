package com.donggw;

import com.mybatis.Param;
import com.mybatis.Select;

import java.util.List;

public interface UserMapper {

	@Select("Select * from user where name = #{name}")
	public List<User> getUser(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);

	public User getUserById(Integer id);
}
