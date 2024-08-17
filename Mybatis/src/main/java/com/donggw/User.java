package com.donggw;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

	private Integer id;

	private String name;

	private Integer age;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
