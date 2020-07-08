package com.sekhar.student.test;

import java.util.Scanner;

import com.sekhar.student.service.department.DepartmentService;
import com.sekhar.student.service.department.impl.DepartmentServiceImpl;
import com.sekhar.student.model.Department;

public class DepartmentTest {

	private Scanner scanner = new Scanner(System.in);

	private DepartmentService departmentService;

	public static void main(String args[])

	{

		DepartmentTest departmentTest = new DepartmentTest();
		String persistence = departmentTest.choosePeristance();
		departmentTest.doOperations(persistence);
	}

	public String choosePeristance() {

		System.out.println("Enter Where To Store Data");
		String persistence = scanner.next();

		if (persistence.equalsIgnoreCase("IN_MEMORY")) {
			departmentService = new DepartmentServiceImpl(persistence);



		} else if (persistence.equalsIgnoreCase("DB")) {
			departmentService = new DepartmentServiceImpl(persistence);
			
		} else if (persistence.equalsIgnoreCase("FILE")) {

			departmentService = new DepartmentServiceImpl(persistence);

		}

		else {
			System.out.println("Entered Invaild Persistence");

		}
		return persistence;

	}

	public void doOperations(String persistence) {
		System.out.println("Enter Your Choice");

		int choice;

		do {

			System.out.println("Enter 1 To Add Department");
			System.out.println("Enter 2 To Remove Department");
			System.out.println("Enter 3 To Update Department");
			System.out.println("Enter 4 To Display Department");
			System.out.println("Enter 5 To Display Departments");
			System.out.println("Enter 0 to Exit");

			choice = scanner.nextInt();

			switch (choice) {

			case 0:
				System.exit(1);

			case 1:
				Department department = new Department();
				System.out.println("Enter Department Id");
				int departmentId = scanner.nextInt();
				department.setDepartmentId(departmentId);
				System.out.println("Enter Department Name");
				String departmentName = scanner.next();
				department.setDepartmentName(departmentName);
				System.out.println("Enter Courses");
				String courses[] = new String[3];
				courses[0] = scanner.next();
				courses[1] = scanner.next();
				courses[2] = scanner.next();
				department.setCourses(courses);
				departmentService.addDepartment(department);
				break;
			case 2:
				System.out.println("Enter Department Id");
				departmentId = scanner.nextInt();
				departmentService.removeDepartment(departmentId);
				break;

			case 3:
				if (persistence.equalsIgnoreCase("DB")) {
					department = new Department();
					System.out.println("Enter Department Id");
					departmentId = scanner.nextInt();
					department.setDepartmentId(departmentId);
					System.out.println("Enter Department Name");
					departmentName = scanner.next();
					department.setDepartmentName(departmentName);
					System.out.println("Enter Courses");
					courses = new String[3];
					courses[0] = scanner.next();
					courses[1] = scanner.next();
					courses[3] = scanner.next();
					department.setCourses(courses);

					departmentService.updateDepartment(department);
				} else {
					System.out.println("This Opertation Is Not Supported");
				}
				break;

			case 4:
				System.out.println("Enter Department ID");
				departmentId = scanner.nextInt();
				departmentService.getDepartment(departmentId);
				break;
			case 5:
				departmentService.getDepartments();
				break;
			default:
				System.out.println("Enterd Invalid Option");
			}

		} while (true);

	}

}
