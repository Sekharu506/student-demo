package com.sekhar.student.manager.student.impl;

import com.sekhar.student.manager.student.StudentManager;
import com.sekhar.student.model.Student;
import com.sekhar.student.dao.student.DBBasedStudentDao;
import com.sekhar.student.dao.student.impl.DBBasedStudentDaoImpl;

public class DBBasedStudentManagerImpl implements StudentManager {
	private DBBasedStudentDao studentDao;

	public DBBasedStudentManagerImpl() {
		studentDao = DBBasedStudentDaoImpl.getStudentDaoInstance();
	}

	public void addStudent(Student student) {
		studentDao.insertStudent(student);

	}

	public void updateStudent(Student student)

	{
		studentDao.updateStudent(student);
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

	public Student[] sortStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
