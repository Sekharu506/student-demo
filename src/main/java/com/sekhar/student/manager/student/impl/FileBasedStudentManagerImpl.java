package com.sekhar.student.manager.student.impl;

import com.sekhar.student.dao.student.FileBasedStudentDao;
import com.sekhar.student.dao.student.FileBasedStudentDaoFactory;
import com.sekhar.student.dao.student.impl.FileCsvBasedStudentDaoImpl;
import com.sekhar.student.manager.student.StudentManager;
import com.sekhar.student.model.Student;

public class FileBasedStudentManagerImpl implements StudentManager {
	private FileBasedStudentDao studentDao;

	public FileBasedStudentManagerImpl(String csvChoice) {
		studentDao = FileBasedStudentDaoFactory.getInstanceOfAddressDao(csvChoice);
	}

	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	public void removeStudent(int id) {
		studentDao.deleteStudent(id);

	}

	public Student getStudent(int id) {

		Student student;
		student = studentDao.getStudent(id);
		return student;
	}

	public Student[] getStudents() {
		Student[] students = new Student[100];
		students = studentDao.getStudents();
		return students;
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

	public Student[] sortStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
