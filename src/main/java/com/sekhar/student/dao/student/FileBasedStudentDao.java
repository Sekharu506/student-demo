package com.sekhar.student.dao.student;

import com.sekhar.student.model.*;

public interface FileBasedStudentDao {

	public void addStudent(Student student);

	public void deleteStudent(int id);

	public Student getStudent(int id);

	public Student[] getStudents();

}
