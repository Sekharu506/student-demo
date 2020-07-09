package com.sekhar.student.test;

import com.sekhar.student.service.student.StudentService;
import com.sekhar.student.service.student.impl.StudentServiceImpl;
import com.sekhar.student.model.Student;
import java.util.Scanner;

public class StudentTest {

	private Scanner scanner = new Scanner(System.in);

	private StudentService studentService;

	public static void main(String args[])

	{

		StudentTest studentTest = new StudentTest();

		studentTest.persistenceChoose();
	}

	public void persistenceChoose() {

		System.out.println("Enter Where To Store Data");
		String persistence = scanner.next();


		if (persistence.equalsIgnoreCase("IN_MEMORY")) {
			studentService = new StudentServiceImpl(persistence);
			doOperations(persistence);

		} else if (persistence.equalsIgnoreCase("DB")) {
			studentService = new StudentServiceImpl(persistence);
			doOperations(persistence);

		} else if (persistence.equalsIgnoreCase("FILE")) {

			studentService = new StudentServiceImpl(persistence);
			doOperations(persistence);

		}

		else {
			System.out.println("Entered Invaild Persistence");

		}

	}

	public void doOperations(String persistence) {

		System.out.println("Enter Your Choice");
		int choice;

		do {
			System.out.println("Enter 1 To Add Student");
			System.out.println("Enter 2 To Remove Student");
			System.out.println("Enter 3  To Update Student");
			System.out.println("Enter 4 To Display Student");
			System.out.println("Enter 5 To Display Students");
			System.out.println("Enter 6 To sort Students");
			System.out.println("Enter 0 To Exit");
			choice = scanner.nextInt();
			switch (choice)

			{

			case 0:
				System.exit(1);

			case 1:
				Student student = new Student();
				System.out.println("Enter Student id");
				int id = scanner.nextInt();
				student.setId(id);
				System.out.println("Enter Name");
				String name = scanner.next();
				student.setName(name);
				System.out.println("Enter Phone Number");
				long phone = scanner.nextLong();
				student.setPhone(phone);
				System.out.println("Enter Department Id");
				int departmentId = scanner.nextInt();
				student.setDepartmentId(departmentId);
				System.out.println("Enter Door No");
				int doorNo = scanner.nextInt();
				student.setDno(doorNo);

				studentService.addStudent(student);
				break;
			case 2:
				System.out.println("Enter Student Id");
				id = scanner.nextInt();
				studentService.removeStudent(id);
				break;
			case 3:
				if (persistence.equalsIgnoreCase("DB")) {
					student = new Student();
					System.out.println("Enter Student id");
					id = scanner.nextInt();
					student.setId(id);
					System.out.println("Enter Name");
					name = scanner.next();
					student.setName(name);
					System.out.println("Enter Phone Number");
					phone = scanner.nextLong();
					student.setPhone(phone);
					System.out.println("Enter Department Id");
					departmentId = scanner.nextInt();
					student.setDepartmentId(departmentId);
					System.out.println("Enter Door No");
					doorNo = scanner.nextInt();
					student.setDno(doorNo);
					studentService.updateStudent(student);
				} else {
					System.out.println("This Operation is not Supported");
				}
				break;

			case 4:
				System.out.println("Enter Student id");
				id = scanner.nextInt();
				studentService.getStudent(id);
				break;
			case 5:
				studentService.getStudents();
				break;
			case 6:
				if (persistence.equalsIgnoreCase("IN_MEMORY")) {
					studentService.sort();
				} else {
					System.out.println("This Operation is Not Supported");
				}
				break;
			default:
				System.out.println("Choose Correct Option");

			}

		} while (true);

	}

}
