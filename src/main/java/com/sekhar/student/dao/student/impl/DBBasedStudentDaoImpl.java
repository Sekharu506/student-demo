package com.sekhar.student.dao.db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sekhar.student.model.Student;
import com.sekhar.student.dao.db.*;

public class DBStudentDaoImpl implements DBStudentDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/demo";
	static final String USER = "root";
	static final String PASS = "root123";
	Connection connection = null;

	public void registerDriver() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception,Registered Failed");
		}
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println("SQL Exception,Not return getConnection ");
		}

	}

	public void insertStudent(Student student) {

		if (connection == null)
			registerDriver();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into student values(?,?,?,?,?)");

			statement.setInt(1, student.getId());
			statement.setString(2, student.getName());
			statement.setLong(3, student.getPhone());
			statement.setInt(4, student.getDepartmentId());
			statement.setInt(5, student.getDno());
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + " inserted");

			} else {
				System.out.println("No rows inserted");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception , statement not created");
		}
	}

	public void updateStudent(Student student) {
		if (connection == null)
			registerDriver();
		try {
			PreparedStatement statement = connection
					.prepareStatement("update student set id=?,name=?,phone=?,departmentId=?,doorNo=? where id=?");

			statement.setInt(1, student.getId());
			statement.setString(2, student.getName());
			statement.setLong(3, student.getPhone());
			statement.setInt(4, student.getDepartmentId());
			statement.setInt(5, student.getDno());
			statement.setInt(6, student.getId());
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + " updated");
			} else {
				System.out.println("No rows updated ");
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception, statement not created");
		}

	}

	public Student getStudent(int id)

	{
		if (connection == null)
			registerDriver();
		Student student = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from student where id=?");
			statement.setInt(1, id);

			ResultSet set = statement.executeQuery();

		} catch (SQLException e) {
			System.out.println("SQL Exception,statement not created");
		}

	}

}
