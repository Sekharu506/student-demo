package com.sekhar.student.manager.student;

import com.sekhar.student.model.Student;

public interface StudentManager {

	public void updateStudent(Student student);

	public void addStudent(Student student);

	public void removeStudent(int id);

	public Student getStudent(int id);

	public Student[] getStudents();

	public Student[] sortStudents();

}
