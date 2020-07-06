package com.sekhar.student.test;

import com.sekhar.student.service.student.StudentService;
import com.sekhar.student.service.student.impl.StudentServiceImpl;
import com.sekhar.student.model.Student;
import java.util.Scanner;

public class StudentTest {

	Scanner sc = new Scanner(System.in);
	StudentTest studenttest;
	StudentService service;

	public static void main(String a[])

	{

		StudentTest studenttest = new StudentTest();

		studenttest.persistenceChoose();
	}

	public void persistenceChoose() {

		System.out.println("Enter Where To Store Data");
		String persistence = sc.next();
		service = new StudentServiceImpl(persistence);

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
		do

		{
			System.out.println("Enter 1 To Create File");
			System.out.println("Enter 2 To Add Student");
			System.out.println("Enter 3 To Remove Student");

			System.out.println("Enter 4 To Display Student");
			System.out.println("Enter 5 To Display Students");
			System.out.println("Enter 0 To Exist");

			;
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

			case 2:
				Student student = new Student();
				System.out.println("Enter Student id");
				int id = sc.nextInt();
				student.setId(id);
				System.out.println("Enter Name");
				String name = sc.next();
				student.setName(name);
				System.out.println("Enter Phone Number");
				long phone = sc.nextLong();
				student.setPhone(phone);
				System.out.println("Enter Department Id");
				int departmentId = sc.nextInt();
				student.setDepartmentId(departmentId);
				System.out.println("Enter Door No");
				int doorNo = sc.nextInt();
				student.setDno(doorNo);
				service.setStudent(student);
				break;
			case 3:
				System.out.println("Enter Student Id");
				id = sc.nextInt();
				service.removeStudent(id);
				break;
			case 4:
				System.out.println("Enter Student id");
				id = sc.nextInt();
				service.getStudent(id);
				break;
			case 5:
				service.getStudents();
				break;
			default:
				System.out.println("Choose Correct Option");

			}

		} while (true);

	}

	public void Db() {

		System.out.println("Enter Your Choice");
		int choice;

		do {
			System.out.println("Enter 1 To Add Student");
			System.out.println("Enter 2 To Remove Student");
			System.out.println("Enter 3  To Update Student");
			System.out.println("Enter 4 To Display Student");
			System.out.println("Enter 5 To Display Students");
			System.out.println("Enter 0 To Exist");
			choice = sc.nextInt();
			switch (choice)

			{

			case 0:
				System.exit(1);

			case 1:
				Student student = new Student();
				System.out.println("Enter Student id");
				int id = sc.nextInt();
				student.setId(id);
				System.out.println("Enter Name");
				String name = sc.next();
				student.setName(name);
				System.out.println("Enter Phone Number");
				long phone = sc.nextLong();
				student.setPhone(phone);
				System.out.println("Enter Department Id");
				int departmentId = sc.nextInt();
				student.setDepartmentId(departmentId);
				System.out.println("Enter Door No");
				int doorNo = sc.nextInt();
				student.setDno(doorNo);
				service.setStudent(student);
				break;
			case 2:
				System.out.println("Enter Student Id");
				id = sc.nextInt();
				service.removeStudent(id);
				break;
			case 3:
				student = new Student();
				System.out.println("Enter Student id");
				id = sc.nextInt();
				student.setId(id);
				System.out.println("Enter Name");
				name = sc.next();
				student.setName(name);
				System.out.println("Enter Phone Number");
				phone = sc.nextLong();
				student.setPhone(phone);
				System.out.println("Enter Department Id");
				departmentId = sc.nextInt();
				student.setDepartmentId(departmentId);
				System.out.println("Enter Door No");
				doorNo = sc.nextInt();
				student.setDno(doorNo);
				service.updateStudent(student);
				break;

			case 4:
				System.out.println("Enter Student id");
				id = sc.nextInt();
				service.getStudent(id);
				break;
			case 5:
				service.getStudents();
				break;
			default:
				System.out.println("Choose Correct Option");

			}

		} while (true);

	}

	public void InMemory() {
		System.out.println("Enter Your Choice");
		int choice;

		do {
			System.out.println("Enter 1 To Add Student");
			System.out.println("Enter 2 To Remove Student");

			System.out.println("Enter 3 To Display Student");
			System.out.println("Enter 4 To Display Students");
			System.out.println("Enter 0 To Exist");
			choice = sc.nextInt();
			switch (choice)

			{

			case 0:
				System.exit(1);

			case 1:
				Student student = new Student();
				System.out.println("Enter Student id");
				int id = sc.nextInt();
				student.setId(id);
				System.out.println("Enter Name");
				String name = sc.next();
				student.setName(name);
				System.out.println("Enter Phone Number");
				long phone = sc.nextLong();
				student.setPhone(phone);
				System.out.println("Enter Department Id");
				int departmentId = sc.nextInt();
				student.setDepartmentId(departmentId);
				System.out.println("Enter Door No");
				int doorNo = sc.nextInt();
				student.setDno(doorNo);
				service.setStudent(student);
				break;
			case 2:
				System.out.println("Enter Student Id");
				id = sc.nextInt();
				service.removeStudent(id);
				break;

			case 3:
				System.out.println("Enter Student id");
				id = sc.nextInt();
				service.getStudent(id);
				break;
			case 4:
				service.getStudents();
				break;
			default:
				System.out.println("Choose Correct Option");

			}

		} while (true);

	}

}
