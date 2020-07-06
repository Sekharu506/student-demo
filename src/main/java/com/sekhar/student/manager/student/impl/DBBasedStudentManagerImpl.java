package com.sekhar.student.manager.student.impl;

import com.sekhar.student.manager.student.StudentManager;
import com.sekhar.student.model.Student;
import com.sekhar.student.dao.student.DBBasedStudentDao;
import com.sekhar.student.dao.student.impl.DBBasedStudentDaoImpl;

public class DBBasedStudentManagerImpl implements StudentManager {
	DBBasedStudentDao studentdao;

	public DBBasedStudentManagerImpl() {
		studentdao = new DBBasedStudentDaoImpl();
	}

	public void setStudent(Student student) {
		studentdao.insertStudent(student);

	}

	public void updateStudent(Student student)

	{
		studentdao.updateStudent(student);
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

	public void makeFile(String path, String filename) {
		// TODO Auto-generated method stub
		
	}

	public Student[] sortStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
