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

public class StudentTest {

	Scanner sc = new Scanner(System.in);
	private StudentManagerImpl studentmanager = new StudentManagerImpl();
	private AddressManagerImpl addressmanager = new AddressManagerImpl();
	private DepartmentManagerImpl departmentmanager = new DepartmentManagerImpl();
	StudentTest studenttest = new StudentTest();

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
		Student student = new Student();
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		student.setid(id);
		System.out.println("Enter Name");
		String name = sc.next();
		student.setName(name);
		System.out.println("Enter phone");
		long phone = sc.nextLong();
		student.setPhone(phone);
		System.out.println("Enter Department Id");
		int departmentId = sc.nextInt();
		student.setDepartmentId(departmentId);

		System.out.println("Enter DoorNo");
		int d_no = sc.nextInt();
		student.setDno(d_no);

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
			System.out.println(" Student ID      Name         Phone");
			studenttest.displayStudent(student);
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
			System.out.println(" Student ID      Name         Phone");

			studenttest.displayStudent(student);
			Department department;
			try {

				department = departmentmanager.getDepartment(student.getDepartmentId());
				System.out.println("DepartmentId     DepartmentName   COURSES");
				studenttest.displayDepartment(department);
			} catch (Exception e) {
				System.out.println("Department not Found");
			}
			Address address;
			try {
				address = addressmanager.getAddress(student.getId());
				System.out.println(" DoorNo  Street    City    Pincode");
				studenttest.displayAddress(address);
			} catch (Exception e) {
				System.out.println("Address Not Found");
			}
		} catch (Exception e) {
			System.out.println("Student Not Found");
		}

	}

	void createDepartment() {
		Department department = new Department();

		System.out.println("Enter Department Id");
		int departmentId = sc.nextInt();
		department.setDepartmentId(departmentId);
		System.out.println("Enter Department Name");
		String departmentName = sc.next();
		department.setDepartmentName(departmentName);
		System.out.println("Enter how many courses");
		int course_count = sc.nextInt();
		System.out.println("Enter " + course_count + " course names");
		String[] courses = new String[course_count];
		for (int i = 0; i < course_count; i++) {
			courses[i] = sc.next();
		}
		department.setCourses(courses);

		departmentmanager.addDepartment(department);
	}

	void showDepartment() {
		Department department;
		System.out.println("Enter Department Id");
		int department_id = sc.nextInt();
		try {
			department = departmentmanager.getDepartment(department_id);
			System.out.println("DepartmentId     DepartmentName   COURSES");
			studenttest.displayDepartment(department);
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
			System.out.println("DepartmentId     DepartmentName   COURSES");
			for (int i = 0; i < departments.size(); i++) {
				studenttest.displayDepartment(departments.get(i));
				System.out.println();
				System.out.println();
				System.out.println();

			}
		}

	}

	void createAddress(int d_no) {
		Address address = new Address();
		address.setDno(d_no);
		System.out.println("Enter Street");

		String street = sc.next();
		address.setStreet(street);
		System.out.println("Enter City");
		String city = sc.next();
		address.setCity(city);
		System.out.println("Enter pin");
		int pin = sc.nextInt();
		address.setPin(pin);

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
			System.out.println(" Student ID      Name         Phone");

			for (int i = 0; i < students.size(); i++) {
				System.out.println();
				System.out.println();
				studenttest.displayStudent(students.get(i));
				Department department;
				try {
					department = departmentmanager.getDepartment(students.get(i).getDepartmentId());
					System.out.println("DepartmentId     DepartmentName   COURSES");
					studenttest.displayDepartment(department);
				} catch (Exception e) {
					System.out.println("Department details Not Found");
				}

				Address address;
				try {
					address = addressmanager.getAddress(students.get(i).getDno());
					System.out.println(" DoorNo  Street    City    Pincode");
					studenttest.displayAddress(address);

				} catch (Exception e) {
					System.out.println("No Address Availble");
				}

			}
		}

	}

	public void displayStudent(Student student) {
		System.out.println(" " + student.getId() + "       " + student.getName() + "         " + student.getPhone());
	}

	public void displayDepartment(Department department) {
		System.out.print(" " + department.getDepartmentId() + "           " + department.getDepartmentName());
		String[] courses = department.getCourses();
		for (int i = 0; i < courses.length; i++) {
			String course = courses[i];
			System.out.print(course + "        ");
		}
	}

	public void displayAddress(Address address) {
		System.out.println(" " + address.getDno() + "         " + address.getStreet() + "           "
				+ address.getCity() + "          " + address.getPin());
	}
}
