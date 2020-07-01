package com.sekhar.student.manager.student;

import com.sekhar.student.model.Student;

public interface StudentManager {

	public void setStudent(Student student);

	public void removeStudent(int id);

	public Student getStudent(int id);

	public Student[] getStudents();

	

}
