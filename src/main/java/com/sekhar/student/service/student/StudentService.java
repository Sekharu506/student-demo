package com.sekhar.student.service.student;

import com.sekhar.student.model.Student;

public interface StudentService {

	public void updateStudent(Student student);

	public void addStudent(Student student);

	public void removeStudent(int id);

	public void getStudent(int id);

	public void getStudents();

	public void sort();

}
