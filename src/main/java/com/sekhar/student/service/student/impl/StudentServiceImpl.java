package com.sekhar.student.service.student.impl;

import com.sekhar.student.manager.student.StudentManager;
import com.sekhar.student.manager.student.StudentManagerFactory;
import com.sekhar.student.model.Student;
import com.sekhar.student.service.student.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentManager studentManager;

	public StudentServiceImpl(String persistence) {

		studentManager = StudentManagerFactory.getStudentManagerInstance(persistence);

	}

	public StudentServiceImpl(String persistence, String csvChoice) {

		studentManager = StudentManagerFactory.getStudentManagerInstance(persistence, csvChoice);

	}

	public void updateStudent(Student student) {
		studentManager.updateStudent(student);

	}

	public void addStudent(Student student) {

		studentManager.addStudent(student);

	}

	public void removeStudent(int id) {

		studentManager.removeStudent(id);

	}

	public void getStudent(int id) {
		Student student;
		student = studentManager.getStudent(id);
		if (student != null) {
			System.out.println(" Id     Name    Phone");
			System.out.println(student.toString());

		}


	}

	public void getStudents() {

		Student[] students;
		students = studentManager.getStudents();
		if (students != null) {
			System.out.println(" Id     Name    Phone");
			for (int i = 0; i < students.length; i++) {
				System.out.println(" " + students[i].toString());
			}
		}


	}

	public void sort() {
		Student[] students = studentManager.sortStudents();
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
		}
	}
}
