package com.sekhar.student.manager.student.impl;

import com.sekhar.student.manager.student.StudentManager;
import java.util.List;
import com.sekhar.student.dao.student.InMemoryBasedStudentDao;
import com.sekhar.student.dao.student.impl.InMemoryBasedStudentDaoImpl;
import com.sekhar.student.model.Student;
import java.util.Set;

public class InMemoryBasedStudentManagerImpl implements StudentManager {

	private InMemoryBasedStudentDao studentDao = null;

	public InMemoryBasedStudentManagerImpl() {

		studentDao = InMemoryBasedStudentDaoImpl.getStudentDaoInstance();

	}

	public void addStudent(Student student) {
		studentDao.addStudent(student);

	}

	public void removeStudent(int id) {
		studentDao.deleteStudent(id);

	}

	public Student getStudent(int id) {
		Student student = studentDao.getStudent(id);
		return student;
	}

	public Student[] getStudents() {
		Set<Student> students = studentDao.getStudents();
		int size = students.size();
		Student[] studentarray = new Student[size];
		students.toArray(studentarray);
		return studentarray;

	}

	public Student[] sortStudents() {

		List<Student> studentlist = studentDao.sortStudentsById();
		int size = studentlist.size();
		Student[] students = new Student[size];

		studentlist.toArray(students);
		return students;

	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

}
