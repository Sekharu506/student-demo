package com.sekhar.student.test;

import java.util.Scanner;

import com.sekhar.student.service.department.DepartmentService;
import com.sekhar.student.service.department.impl.DepartmentServiceImpl;
import com.sekhar.student.model.Department;

public class DepartmentTest {

	Scanner sc = new Scanner(System.in);
	StudentTest studenttest;
	DepartmentService service;

	public static void main(String a[])

	{

		StudentTest studenttest = new StudentTest();

		studenttest.persistenceChoose();
	}

	public void persistenceChoose() {

		System.out.println("Enter Where To Store Data");
		String persistence = sc.next();
		service = new DepartmentServiceImpl(persistence);

		if (persistence == "IN_MEMORY") {
			studenttest.InMemory();

		} else if (persistence == "DB") {

			studenttest.Db();
		} else if (persistence == "FILE") {
			studenttest.File();
		}

		else {
			System.out.println("Entered Invaild Persistence");

		}

	}

	public void File() {
		System.out.println("Enter Your Choice");

		int choice;

		do {
			System.out.println("Enter 1 To Create File");
			System.out.println("Enter 2 To Add Department");
			System.out.println("Enter 3 To Remove Department");

			System.out.println("Enter 4 To Dispaly Department");
			System.out.println("Enter 5 To Display Departments");
			System.out.println("Enter 0 to Exist");

			choice = sc.nextInt();

			switch (choice) {

			case 0:
				System.exit(1);
			case 1:
				System.out.println("Enter File Path");
				String path = sc.next();
				System.out.println("Enter File Name");
				String filename = sc.next();
				service.makeFile(path, filename);
				break;

			case 2:
				Department department = new Department();
				System.out.println("Enter Department Id");
				int departmentId = sc.nextInt();
				department.setDepartmentId(departmentId);
				System.out.println("Enter Department Name");
				String departmentName = sc.next();
				department.setDepartmentName(departmentName);
				System.out.println("Enter Courses");
				String courses[] = new String[3];
				courses[0] = sc.next();
				courses[1] = sc.next();
				courses[3] = sc.next();
				department.setCourses(courses);
				service.setDepartment(department);
				break;
			case 3:
				System.out.println("Enter Department Id");
				departmentId = sc.nextInt();
				service.removeDepartment(departmentId);
				break;
			case 4:
				System.out.println("Enter Department ID");
				departmentId = sc.nextInt();
				service.getDepartment(departmentId);
				break;
			case 5:
				service.getDepartments();
				break;
			default:
				System.out.println("Enterd Invalid Option");
			}

		} while (true);

	}

	public void Db() {
		System.out.println("Enter Your Choice");

		int choice;

		do {

			System.out.println("Enter 1 To Add Department");
			System.out.println("Enter 2 To Remove Department");
			System.out.println("Enter 3 To Update Department");
			System.out.println("Enter 4 To Display Department");
			System.out.println("Enter 5 To Display Departments");
			System.out.println("Enter 0 to Exist");

			choice = sc.nextInt();

			switch (choice) {

			case 0:
				System.exit(1);

			case 1:
				Department department = new Department();
				System.out.println("Enter Department Id");
				int departmentId = sc.nextInt();
				department.setDepartmentId(departmentId);
				System.out.println("Enter Department Name");
				String departmentName = sc.next();
				department.setDepartmentName(departmentName);
				System.out.println("Enter Courses");
				String courses[] = new String[3];
				courses[0] = sc.next();
				courses[1] = sc.next();
				courses[3] = sc.next();
				department.setCourses(courses);
				service.setDepartment(department);
				break;
			case 2:
				System.out.println("Enter Department Id");
				departmentId = sc.nextInt();
				service.removeDepartment(departmentId);
				break;

			case 3:
				department = new Department();
				System.out.println("Enter Department Id");
				departmentId = sc.nextInt();
				department.setDepartmentId(departmentId);
				System.out.println("Enter Department Name");
				departmentName = sc.next();
				department.setDepartmentName(departmentName);
				System.out.println("Enter Courses");
				courses = new String[3];
				courses[0] = sc.next();
				courses[1] = sc.next();
				courses[3] = sc.next();
				department.setCourses(courses);

				service.updateDepartment(department);

			case 4:
				System.out.println("Enter Department ID");
				departmentId = sc.nextInt();
				service.getDepartment(departmentId);
				break;
			case 5:
				service.getDepartments();
				break;
			default:
				System.out.println("Enterd Invalid Option");
			}

		} while (true);

	}

	public void InMemory() {
		System.out.println("Enter Your Choice");

		int choice;

		do {

			System.out.println("Enter 1 To Add Department");
			System.out.println("Enter 2 To Remove Department");

			System.out.println("Enter 3 To Dispaly Department");
			System.out.println("Enter 4 To Display Departments");
			System.out.println("Enter 0 to Exist");

			choice = sc.nextInt();

			switch (choice) {

			case 0:
				System.exit(1);

			case 1:
				Department department = new Department();
				System.out.println("Enter Department Id");
				int departmentId = sc.nextInt();
				department.setDepartmentId(departmentId);
				System.out.println("Enter Department Name");
				String departmentName = sc.next();
				department.setDepartmentName(departmentName);
				System.out.println("Enter Courses");
				String courses[] = new String[3];
				courses[0] = sc.next();
				courses[1] = sc.next();
				courses[3] = sc.next();
				department.setCourses(courses);
				service.setDepartment(department);
				break;
			case 2:
				System.out.println("Enter Department Id");
				departmentId = sc.nextInt();
				service.removeDepartment(departmentId);
				break;
			case 3:
				System.out.println("Enter Department ID");
				departmentId = sc.nextInt();
				service.getDepartment(departmentId);
				break;
			case 4:
				service.getDepartments();
				break;
			default:
				System.out.println("Enterd Invalid Option");
			}

		} while (true);

	}
}
