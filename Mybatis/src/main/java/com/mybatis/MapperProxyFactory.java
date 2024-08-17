package com.mybatis;

import com.donggw.User;

import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperProxyFactory {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


	public static <T> T getMapper(Class<T> mapper) {


		Object proxyInstance = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{mapper}, (proxy, method, args) -> {

			// 解析sql --------> 执行sql --------> 处理结果
			// JDBC
			// 1.创建数据库连接
			Connection connection = getConnection();


			Select annotation = method.getAnnotation(Select.class);

			// Select * from user where name = #{name}
			String sql = annotation.value();

			// 获取参数，参数名：参数值
			// "name":"李逵"
			// “age”：“18”
			Map<String, Object> param = new HashMap<>();
			Parameter[] parameters = method.getParameters();
			for (int i = 0; i < parameters.length; i++) {
				Parameter parameter = parameters[i];
				param.put(parameter.getName(), args[i]);
				param.put(parameter.getAnnotation(Param.class).value(), args[i]);
			}

			// 2.构造PreparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ? and name = ? and age = ?");
			preparedStatement.setString(1, "1");
			preparedStatement.setString(2, "李逵");
			preparedStatement.setString(3, "18");

			// 3.执行PreparedStatement
			preparedStatement.execute();

			// 4.根据当前执行方法返回的类型封装结果
			List<User> list = new ArrayList<>();

			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAge(resultSet.getInt("age"));
				list.add(user);
			}

			// 5.关闭连接
			connection.close();

			return list;
		});

		return (T) proxyInstance;

	}

	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/donggw", "donggw", "donggw");
	}


}
