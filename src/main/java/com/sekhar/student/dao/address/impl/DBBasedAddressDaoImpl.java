package com.sekhar.student.dao.address.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.sekhar.student.model.*;
import com.sekhar.student.dao.address.DBBasedAddressDao;

public class DBBasedAddressDaoImpl implements DBBasedAddressDao {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/demo";
	private static final String USER = "root";
	private static final String PASS = "root123";
	private Connection connection = null;

	public DBBasedAddressDaoImpl() {

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

	public void insertAddress(Address address) {

		try {
			PreparedStatement statement = connection.prepareStatement("insert into address values(?,?,?,?);");
			statement.setInt(1, address.getDno());
			statement.setString(2, address.getStreet());
			statement.setString(3, address.getCity());
			statement.setInt(4, address.getPin());
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + " inserted");

			} else {

				System.out.println("No Rows Effected");
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception ,statement not created");
		}

	}

	public void deleteAddress(int doorNo) {

		try {
			PreparedStatement statement = connection.prepareStatement("delete from address where doorNo=?;");
			statement.setInt(1, doorNo);
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + " deleted");

			} else {
				System.out.println(" Address Didn't Deleted");
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception ,statement not created");
		}
	}

	public void updateAddress(Address address) {

		try {
			PreparedStatement statement = connection
					.prepareStatement("update address set doorNo=?,street=?,city=?,pin=? where doorNo=?;");
			statement.setInt(1, address.getDno());
			statement.setString(2, address.getStreet());
			statement.setString(3, address.getCity());
			statement.setInt(4, address.getPin());
			int rows = statement.executeUpdate();
			if (rows != 0) {
				System.out.println(" " + rows + " Updated");

			} else {

				System.out.println("Not Rows Effected");
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception ,statement not created");
		}
	}

	public Address getAddress(int doorNo) {

		Address address = new Address();
		try {

			PreparedStatement statement = connection.prepareStatement("select * from address where doorNO=?;");
			statement.setInt(1, doorNo);

			ResultSet resultset = statement.executeQuery();
			if (!resultset.next()) {
				System.out.println("No Data Found");
				return null;

			} else {
				address.setDno(resultset.getInt(1));
				address.setStreet(resultset.getString("street"));
				address.setCity(resultset.getString("city"));
				address.setPin(resultset.getInt("pin"));
				return address;

			}

		} catch (SQLException e) {
			System.out.println("SQL Exception, statement not created");
			return null;
		}
	}

	public Address[] getAddresses() {

		Address[] addresses;

		try {
			PreparedStatement statement = connection.prepareStatement("select * from address;");
			ResultSet resultset = statement.executeQuery();
			int count;
			if (resultset != null) {
				resultset.last();
				count = resultset.getRow();
				resultset.beforeFirst();
				addresses = new Address[count];

				int i = 0;
				while (resultset.next()) {

					addresses[i].setDno(resultset.getInt(1));
					addresses[i].setStreet(resultset.getString("street"));
					addresses[i].setCity(resultset.getString("city"));
					addresses[i].setPin(resultset.getInt("pin"));
					i++;

				}
				return addresses;

			} else {
				System.out.println("Empty Address List");
				return null;
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception ,statement not created");
			return null;
		}

	}
}
