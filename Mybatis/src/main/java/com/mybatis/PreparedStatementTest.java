package com.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


	public static void main(String[] args) throws SQLException {

		// 1.创建数据库连接
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/donggw", "donggw", "donggw");

		// 2.构造PreparedStatement
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user where name = ?");
		preparedStatement.setString(1, "李逵");

		// 3.执行PreparedStatement
		preparedStatement.execute();
		System.out.println(preparedStatement.getResultSet());

		preparedStatement.close();


	}
}
