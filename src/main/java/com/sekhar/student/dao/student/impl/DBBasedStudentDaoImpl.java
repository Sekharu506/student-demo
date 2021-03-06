package com.sekhar.student.dao.student.impl;

import com.sekhar.student.dao.student.DBBasedStudentDao;
import com.sekhar.student.model.Student;

import java.sql.*;

public class DBBasedStudentDaoImpl implements DBBasedStudentDao {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/demo";
    private static final String USER = "root";
    private static final String PASS = "root123";
    private Connection connection = null;
    private static DBBasedStudentDaoImpl studentDao = null;

    private DBBasedStudentDaoImpl() {
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

    public static DBBasedStudentDaoImpl getStudentDaoInstance() {
        if (studentDao == null)
            studentDao = new DBBasedStudentDaoImpl();
        return studentDao;
    }

    public void insertStudent(Student student) {

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

    public Student getStudent(int id) {

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
                
                return null;
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception,statement not created");
            return null;
        }

    }

    public Student[] getStudents() {

        Student[] students;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from student;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

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
                    students[i] = new Student();
                    students[i].setId(resultset.getInt("id"));
                    students[i].setName(resultset.getString("name"));
                    students[i].setPhone(resultset.getLong("phone"));
                    students[i].setDepartmentId(resultset.getInt("departmentId"));
                    students[i].setDno(resultset.getInt("doorNo"));
                    i++;
                }
                return students;

            }

        } catch (SQLException e) {
            System.out.println("SQL Exception, statement not created ");
            return null;
        }

    }

    public void deleteStudent(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from student where id=?;");
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows != 0) {
                System.out.println("Student Removed");
            } else {
                System.out.println("Student Not Exists");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception , statement not created " + e.getMessage());
        }

    }
}
