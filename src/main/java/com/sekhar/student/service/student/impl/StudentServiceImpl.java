package com.sekhar.student.service.student.impl;

import com.sekhar.student.model.Student;
import com.sekhar.student.service.student.StudentService;
import com.sekhar.student.manager.student.StudentManager;
import com.sekhar.student.manager.student.StudentManagerFactory;

public class StudentServiceImpl implements StudentService {
	StudentManager studentmanager;

	public StudentServiceImpl(String persistence) {

		studentmanager = StudentManagerFactory.getStudentManagerInstance(persistence);

	}

	public StudentServiceImpl(String persistence, String path, String filename) {

		studentmanager = StudentManagerFactory.getStudentManagerInstance(persistence, path, filename);

	}

	public void updateStudent(Student student) {
		studentmanager.updateStudent(student);

	}

	public void addStudent(Student student) {

		studentmanager.addStudent(student);

	}

	public void removeStudent(int id) {

		studentmanager.removeStudent(id);

	}

	public void getStudent(int id) {
		Student student;
		student = studentmanager.getStudent(id);
		if (student != null) {
			System.out.println(" Id     Name    Phone");
			student.toString();
		} else {

			System.out.println("Student Not Found");
		}

	}

	public void getStudents() {

		Student[] students;
		students = studentmanager.getStudents();
		if (students != null) {
			System.out.println(" Id     Name    Phone");
			for (int i = 0; i < students.length; i++) {
				System.out.println(" " + students[i].toString());
			}
		} else {
			System.out.println("Not Student in Records");
		}

	}

	public void sort() {
		Student[] students = studentmanager.sortStudents();
		for (int i = 0; i < students.length; i++) {
			students[i].toString();
		}
	}
}