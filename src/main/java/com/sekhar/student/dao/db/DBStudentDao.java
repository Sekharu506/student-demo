package com.sekhar.student.dao.db;

import com.sekhar.student.model.*;

public interface DBStudentDao {

	public void insertStudent(Student student);

	public void updateStudent(int id);

	public Student getStudent(int id);

	public Student[] getStudents();

	public void deleteStudent(int id);

}
