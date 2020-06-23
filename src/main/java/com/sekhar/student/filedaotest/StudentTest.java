package com.sekhar.student.filedaotest;

import com.sekhar.student.daomodel.*;
import com.sekhar.student.filebasedmanagerimpl.*;
import java.util.*;

public class StudentTest {
	Scanner sc = new Scanner(System.in);
	FileBasedStudentManagerimpl studentmanager = new FileBasedStudentManagerimpl();

	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		StudentTest studenttest = new StudentTest();

		System.out.println("Enter your Choice");
		int choice;

		do {
			System.out.println("Enter 1 To Create File");
			System.out.println("Enter 2 To Add Student");
			System.out.println("Enter 3 To Remove Student");
			System.out.println("Enter 4 To Show Student Details");
			System.out.println("Enter 5 To Show Students Details");
			System.out.println("Enter 0 To Teriminate");
			choice = sc.nextInt();
			switch (choice) {

			case 0:
				System.exit(1);

			case 1:
				studenttest.createStudentFile();
				break;

			case 2:
				studenttest.createStudent();
				break;

			case 3:
				studenttest.removeStudent();
				break;

			case 4:
				studenttest.showStudentDetails();
				break;

			case 5:
				studenttest.showStudentsDetails();
				break;

			default:
				System.out.println("Invalid option Choosen");

			}

		} while (true);

	}

	public void createStudentFile() {
		System.out.println("Enter File path");
		String path = sc.next();
		System.out.println("Enter File name");
		String filename = sc.next();

		studentmanager.createFile(path, filename);

	}

	public void createStudent() {
		Student student = new Student();

		System.out.println("Enter Student ID");
		int id = sc.nextInt();
		student.setId(id);
		System.out.println("Enter Student Name");
		String name = sc.next();
		student.setName(name);
		System.out.println("Enter Student Mobile Number");
		long phone = sc.nextLong();
		student.setPhone(phone);
		System.out.println("Enter Department ID");
		int departmentId = sc.nextInt();
		student.setDepartmentId(departmentId);
		System.out.println("Enter door No");
		int doorNo = sc.nextInt();
		student.setDno(doorNo);
		studentmanager.addStudent(student);

	}

	public void removeStudent() {
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		studentmanager.deleteStudent(id);
	}

	public void showStudentDetails() {
		Student student;

		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		student = studentmanager.getStudent(id);
		if (student == null) {
			System.out.println("Student Not Found");
		} else {
			System.out.println("Student ID   Student Name   MObile ");
			System.out.println(student.toString());
		}

	}

	public void showStudentsDetails() {
		Student[] students;


students = studentmanager.getStudents();
		if (students == null) {
			System.out.println("No Students In File Or Exception Occurs");
		} else {
			System.out.println("Student ID   Student Name   MObile ");
			for (int i = 0; i < students.length; i++) {
				students[i].toString();
			}
		}
	}

}
