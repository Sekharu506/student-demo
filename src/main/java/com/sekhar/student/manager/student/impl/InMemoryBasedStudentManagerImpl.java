package com.sekhar.student.manager.student.impl;

import com.sekhar.student.manager.student.StudentManager;
import java.util.List;
import com.sekhar.student.dao.student.InMemoryBasedStudentDao;
import com.sekhar.student.dao.student.impl.InMemoryBasedStudentDaoImpl;
import com.sekhar.student.model.Student;
import java.util.Set;

public class InMemoryBasedStudentManagerImpl implements StudentManager {

	InMemoryBasedStudentDao studentdao = null;

	public InMemoryBasedStudentManagerImpl() {

		studentdao = new InMemoryBasedStudentDaoImpl();

	}

	public void setStudent(Student student) {
		studentdao.addStudent(student);

	}

	public void removeStudent(int id) {
		studentdao.deleteStudent(id);

	}

	public Student getStudent(int id) {
		Student student = studentdao.getStudent(id);
		return student;
	}

	public Student[] getStudents() {
		Set<Student> students = studentdao.getStudents();
		int size = students.size();
		Student[] studentarray = new Student[size];
		students.toArray(studentarray);
		return studentarray;

	}

	public Student[] sortStudents() {

		List<Student> studentlist = studentdao.sortStudentsById();
		int size = studentlist.size();
		Student[] students = new Student[size];

		studentlist.toArray(students);
		return students;

	}

}
