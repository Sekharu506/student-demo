package com.sekhar.student.dao.department.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sekhar.student.dao.department.DBBasedDepartmentDao;

import com.sekhar.student.model.Department;

public class DBBasedDepartmentDaoImpl implements DBBasedDepartmentDao {
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

	public void insertDepartment(Department department) {
		if (connection == null) {
			registerDriver();
		}
		try {
			PreparedStatement statement = connection.prepareStatement("insert into department values(?,?,?,?,?);");
			statement.setInt(1, department.getDepartmentId());
			statement.setString(2, department.getDepartmentName());
			String courses[] = department.getCourses();
			statement.setString(3, courses[0]);
			statement.setString(4, courses[1]);
			statement.setString(5, courses[3]);
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + " Inserted");

			} else {
				System.out.println("No Rows Insered");
			}

		} catch (SQLException e) {

			System.out.println("SQL Exception , statement not created");
		}

	}

	public void deleteDepartment(int departmentId) {
		if (connection == null)
			registerDriver();
		try {
			PreparedStatement statement = connection.prepareStatement("delete from department where departmentId=?;");
			statement.setInt(1, departmentId);
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + "  deleted");
			} else {
				System.out.println("No Rows Deleted");
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception , statement not created");
		}

	}

	public void updateDepartment(Department department) {
		if (connection == null)

			registerDriver();
		try {

			PreparedStatement statement = connection.prepareStatement(
					"update department set departmentId=?,departmentName=?,course1=?,course2=?,course3=?;");
			statement.setInt(1, department.getDepartmentId());
			statement.setString(2, department.getDepartmentName());
			String courses[] = department.getCourses();
			statement.setString(3, courses[0]);
			statement.setString(4, courses[1]);
			statement.setString(5, courses[2]);
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + " Updated");
			} else {
				System.out.println("No Rows Updated");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception ,statement not created");
		}
	}

	public Department getDepartment(int departmentId) {
		if (connection == null)
			registerDriver();
		Department department = new Department();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from department where departmentId=?;");
			statement.setInt(1, departmentId);
			ResultSet resultset = statement.executeQuery();
			if (resultset != null) {
				resultset.next();
				department.setDepartmentId(resultset.getInt(1));
				department.setDepartmentName(resultset.getString(2));
				String courses[] = new String[3];

				courses[0] = resultset.getString(3);
				courses[1] = resultset.getString(4);
				courses[2] = resultset.getString(5);
				department.setCourses(courses);

				return department;

			} else {
				System.out.println("Not Data Found");
				return null;
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception ,statement not created");
			return null;
		}

	}

	public Department[] getDepartments() {
		if (connection == null)
			registerDriver();
		Department[] departments;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from department;");

			ResultSet resultset = statement.executeQuery();
			if (resultset != null) {
				resultset.last();
				int count = resultset.getRow();
				resultset.beforeFirst();

				departments = new Department[count];
				int i = 0;
				while (resultset.next()) {
					departments[i].setDepartmentId(resultset.getInt(1));

					departments[i].setDepartmentId(resultset.getInt(2));

					String courses[] = new String[3];

					courses[0] = resultset.getString(3);
					courses[1] = resultset.getString(4);
					courses[2] = resultset.getString(5);
					departments[i].setCourses(courses);
					i++;

				}
				return departments;
			} else {
				System.out.println("No Departments Found");
				return null;
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception ,statement not created");
			return null;
		}

	}

}
