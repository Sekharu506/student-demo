/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.test;

import com.sekhar.student.managerimpl.StudentManagerImpl;
import com.test.student.model.Address;
import com.test.student.model.Department;
import com.test.student.model.Student;
import com.sekhar.student.managerimpl.DepartmentManagerImpl;
import com.sekhar.student.managerimpl.AddressManagerImpl;

import java.util.*;

/**
 *
 * @author kalyani
 */
public class StudentTest {

	Scanner sc = new Scanner(System.in);
	private StudentManagerImpl studentmanager = new StudentManagerImpl();
	private AddressManagerImpl addressmanager = new AddressManagerImpl();
	private DepartmentManagerImpl departmentmanager = new DepartmentManagerImpl();

	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Choice");
		StudentTest studenttest = new StudentTest();
		do {
			System.out.println("Enter 1 To Add Student");
			System.out.println("Enter 2 To Remove Student");
			System.out.println("Enter 3 To Show Student Details");
			System.out.println("Enter 4 To Show Student Full Details");
			System.out.println("Enter 5 To show All Student Full Details");
			System.out.println("Enter 6 To Create Department");
			System.out.println("Enter 7 To Show Department");
			System.out.println("Enter 8 To Remove Department");
			System.out.println("Enter 9 To Show Departments");
			System.out.println("Enter 10  To Remove Address");

			System.out.println("Enter 0 To Terimante");

			int choice = sc.nextInt();

			switch (choice) {

			case 0:
				System.exit(1);
				break;

			case 1:
				studenttest.createStudent();
				break;

			case 2:
				studenttest.removeStudent();

				break;

			case 3:
				studenttest.showStudentDetails();
				break;

			case 4:
				studenttest.showStudentFullDetails();
				break;

			case 5:
				studenttest.showAllStudentFullDetails();
				break;

			case 6:
				studenttest.createDepartment();
				break;

			case 7:
				studenttest.showDepartment();
				break;
			case 8:
				studenttest.removeDepartment();
				break;

			case 9:
				studenttest.showDepartments();
				break;

			case 10:
				studenttest.removeAddress();
				break;

			default:
				System.out.println("Entered Invalid Option");

			}

		} while (true);

	}

	void createStudent() {
		Student student;
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter phone");
		long phone = sc.nextLong();
		System.out.println("Enter Department Id");
		int department_id = sc.nextInt();
		System.out.println("Enter DoorNo");
		int d_no = sc.nextInt();

		student = new Student(id, name, phone, department_id, d_no);

		studentmanager.addStudent(student);

		Address address;
		try {
			address = addressmanager.getAddress(d_no);
		} catch (Exception e) {

			createAddress(d_no);
		}
	}

	void removeStudent() {
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		studentmanager.deleteStudent(id);
	}

	void showStudentDetails() {
		Student student;
		System.out.println("Enter Student ID");
		int id = sc.nextInt();
		try {
			student = studentmanager.getStudent(id);
			student.getStudent();
		} catch (Exception e) {
			System.out.println("Student Not Found");
		}
	}

	void showStudentFullDetails() {
		Student student;
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		try {
			student = studentmanager.getStudent(id);
			student.getStudent();
			Department department;
			try {

				department = departmentmanager.getDepartment(student.department_id);
				department.getDepartment();
			} catch (Exception e) {
				System.out.println("Department not Found");
			}
			Address address;
			try {
				address = addressmanager.getAddress(student.d_no);
				address.getAddress();
			} catch (Exception e) {
				System.out.println("Address Not Found");
			}
		} catch (Exception e) {
			System.out.println("Student Not Found");
		}

	}

	void createDepartment() {
		Department department;

		System.out.println("Enter Department Id");
		int department_id = sc.nextInt();
		System.out.println("Enter Department Name");
		String department_name = sc.next();
		System.out.println("Enter how many courses");
		int course_count = sc.nextInt();
		System.out.println("Enter " + course_count + " course names");
		String[] courses = new String[course_count];
		for (int i = 0; i < course_count; i++) {
			courses[i] = sc.next();
		}

		department = new Department(department_id, department_name, courses);
		departmentmanager.addDepartment(department);
	}

	void showDepartment() {
		Department department;
		System.out.println("Enter Department Id");
		int department_id = sc.nextInt();
		try {
			department = departmentmanager.getDepartment(department_id);
			department.getDepartment();
		} catch (Exception e) {
			System.out.println("Department Details Not Found");
		}
	}

	void removeDepartment() {
		System.out.println("Enter Department Id");
		int department_id = sc.nextInt();
		departmentmanager.deleteDepartment(department_id);
	}

	void showDepartments() {
		List<Department> departments;

		departments = departmentmanager.getDepartments();
		if (departments.isEmpty()) {
			System.out.println("NO Departments");
		} else {
			for (int i = 0; i < departments.size(); i++) {
				departments.get(i).getDepartment();
				System.out.println();
				System.out.println();
				System.out.println();

			}
		}

	}

	void createAddress(int d_no) {
		Address address;

		System.out.println("Enter Street");
		String street = sc.next();
		System.out.println("Enter City");
		String city = sc.next();
		System.out.println("Enter pin");
		int pin = sc.nextInt();
		address = new Address(d_no, street, city, pin);
		addressmanager.addAddress(address);

	}

	void removeAddress() {
		System.out.println("Enter DoorNo");
		int d_no = sc.nextInt();
		addressmanager.deleteAddress(d_no);

	}

	void showAllStudentFullDetails() {
		List<Student> students;

		students = studentmanager.getStudents();
		if (students.isEmpty()) {
			System.out.println("NO Students Availble");
		} else {
			for (int i = 0; i < students.size(); i++) {
				System.out.println();
				System.out.println();
				students.get(i).getStudent();
				Department department;
				try {
					department = departmentmanager.getDepartment(students.get(i).department_id);
					department.getDepartment();
				} catch (Exception e) {
					System.out.println("Department details Not Found");
				}

				Address address;
				try {
					address = addressmanager.getAddress(students.get(i).d_no);
					address.getAddress();
				} catch (Exception e) {
					System.out.println("No Address Availble");
				}

			}
		}

	}

}
