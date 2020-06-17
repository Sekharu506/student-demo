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

	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);
		StudentTest studenttest = new StudentTest();
		System.out.println("Enter your Choice");

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
			System.out.println("Enter 11 To Sort Student List");

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

			case 11:
				studenttest.sortStudents();
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
		student.setId(id);
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
		int doorNo = sc.nextInt();
		student.setDno(doorNo);

		studentmanager.addStudent(student);

		Address address;

		address = addressmanager.getAddress(doorNo);
		if (address == null)
			createAddress(doorNo);

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

		student = studentmanager.getStudent(id);
		if (student != null) {
			System.out.println(" Student ID      Name         Phone");
			System.out.println(student.toString());
		} else {
			System.out.println("Student Not Found");
		}
	}

	void showStudentFullDetails() {
		Student student;
		System.out.println("Enter Student Id");
		int id = sc.nextInt();

		student = studentmanager.getStudent(id);
		if (student != null) {
			System.out.println(" Student ID      Name         Phone");

			System.out.println(student.toString());
			Department department;

			department = departmentmanager.getDepartment(student.getDepartmentId());
			if (department != null) {
				System.out.println();
				System.out.println("DepartmentId     DepartmentName   COURSES");
				System.out.println(department.toString());
			} else {
				System.out.println("Department Not Found");
			}
			Address address;

			address = addressmanager.getAddress(student.getId());
			if (address != null) {
				System.out.println();
				System.out.println(" DoorNo  Street    City    Pincode");
				System.out.println(address.toString());
			}

			else {
				System.out.println("Address Not Found");
			}
		} else {

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
		System.out.println("Enter Courses");
		String[] courses = new String[3];
		for (int i = 0; i < 3; i++) {
			courses[i] = sc.next();
		}
		department.setCourses(courses);

		departmentmanager.addDepartment(department);
	}

	void showDepartment() {
		Department department;
		System.out.println("Enter Department Id");
		int departmentId = sc.nextInt();

		department = departmentmanager.getDepartment(departmentId);
		if (department != null) {
			System.out.println("DepartmentId     DepartmentName   COURSES");
			System.out.println(department.toString());

		} else {
			System.out.println("Department Not Found");

		}

	}

	void removeDepartment() {
		System.out.println("Enter Department Id");
		int departmentId = sc.nextInt();
		departmentmanager.deleteDepartment(departmentId);
	}

	void showDepartments() {
		Set<Department> departments;

		departments = departmentmanager.getDepartments();
		if (departments.isEmpty()) {
			System.out.println("NO Departments");
		} else {
			System.out.println("DepartmentId     DepartmentName   COURSES");
			Iterator<Department> iterator = departments.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().toString());
			}
		}

	}

	void createAddress(int doorNo) {
		Address address = new Address();
		address.setDno(doorNo);
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
		int doorNo = sc.nextInt();
		addressmanager.deleteAddress(doorNo);

	}

	public void sortStudents() {

		List<Student> studentslist = new ArrayList<Student>();
		Student student;
		studentslist = studentmanager.sortStudentsById(studentmanager.getStudents());
		if (studentslist != null) {
			System.out.println("StudentID   Name    Phone    DepartmentID  DoorNo");
			for (int i = 0; i < studentslist.size(); i++) {
				student = studentslist.get(i);
				System.out.println(" " + student.getId() + "  " + student.getName() + "      " + student.getPhone()
						+ "      " + student.getDepartmentId() + "    " + student.getDno());

			}
		}

		else {
			System.out.println("No Students List");
		}

	}

	void showAllStudentFullDetails() {
		Set<Student> students;
		students = studentmanager.getStudents();

		if (students.isEmpty()) {
			System.out.println("NO Students Availble");
		} else {

			Iterator<Student> iterator1 = students.iterator();

			Student student;
			Department department;
			Address address;
			while (iterator1.hasNext()) {

				System.out.println(" Student ID      Name         Phone");
				student = iterator1.next();
				System.out.println(student.toString());

				department = departmentmanager.getDepartment(student.getDepartmentId());
				if (department == null) {
					System.out.println("Department Not Exist");
				} else {
					System.out.println();
					System.out.println("DepartmentId     DepartmentName   COURSES");
					System.out.println(department.toString());
				}
				address = addressmanager.getAddress(student.getDno());
				if (address == null) {
					System.out.println("Address Not Created");

				} else {
					System.out.println();
					System.out.println(" DoorNo       Street       City        PinCode");
					System.out.println(address.toString());
				}

			}

		}

	}

}
