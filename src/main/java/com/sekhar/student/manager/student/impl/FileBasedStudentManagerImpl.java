package com.sekhar.student.manager.student.impl;

import com.sekhar.student.manager.student.StudentManager;
import com.sekhar.student.model.Student;
import com.sekhar.student.dao.student.FileBasedStudentDao;
import com.sekhar.student.dao.student.impl.FileBasedStudentDaoImpl;

public class FileBasedStudentManagerImpl implements StudentManager {
	FileBasedStudentDao studentdao;

	public FileBasedStudentManagerImpl()

	{
		studentdao = new FileBasedStudentDaoImpl();
	}

	public void makeFile(String path, String filename) {
		studentdao.createFile(path, filename);

	}

	public void setStudent(Student student) {
		studentdao.addStudent(student);
	}

	public void removeStudent(int id) {
		studentdao.deleteStudent(id);

	}

	public Student getStudent(int id) {

		Student student;
		student = studentdao.getStudent(id);
		return student;
	}

	public Student[] getStudents() {
		Student[] students = new Student[100];
		students = studentdao.getStudents();
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
