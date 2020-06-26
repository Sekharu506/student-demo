package com.sekhar.student.dao.student.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sekhar.student.model.Student;

import com.sekhar.student.dao.student.DBBasedStudentDao;

public class DBBasedStudentDaoImpl implements DBBasedStudentDao {

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
			PreparedStatement statement = connection.prepareStatement("insert into student values(?,?,?,?,?);");

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
					.prepareStatement("update student set id=?,name=?,phone=?,departmentId=?,doorNo=? where id=?;");

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
		Student student = new Student();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from student where id=?;");
			statement.setInt(1, id);
			int found = 0;
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				if (id == set.getInt("id")) {
					found = 1;
					break;
				}

			}

			if (found == 1) {
				student.setId(set.getInt("id"));
				student.setName(set.getString("name"));
				student.setPhone(set.getLong("phone"));
				student.setDepartmentId(set.getInt("departmentId"));
				student.setDno(set.getInt("doorNo"));
				return student;

			} else {
				System.out.println(" Student Not Found");
				return null;
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception,statement not created");
			return null;
		}

	}

	public Student[] getStudents() {
		if (connection == null)
			registerDriver();
		Student[] students;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from student;");

			ResultSet resultset = statement.executeQuery();

			if (resultset == null) {
				System.out.println("No Student Exists ");
				return null;
			} else {
				resultset.last();
				int count = resultset.getRow();
				resultset.beforeFirst();
				students = new Student[count];
				int i = 0;
				while (resultset.next()) {
					students[i].setId(resultset.getInt("id"));
					students[i].setName(resultset.getString("name"));
					students[i].setPhone(resultset.getLong("phone"));
					students[i].setDepartmentId(resultset.getInt("departmentId"));
					students[i].setDno(resultset.getInt("doorNo"));

				}
				return students;

			}

		} catch (SQLException e) {
			System.out.println("SQL Exception, statement not created ");
			return null;
		}

	}

	public void deleteStudent(int id)

	{
		if (connection == null)
			registerDriver();
		try {
			PreparedStatement statement = connection.prepareStatement("delete * from student where id=?;");
			statement.setInt(1, id);
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println("Student Removed");
			} else {
				System.out.println("Student Not Exists");
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception , statement not created");
		}

	}
}
