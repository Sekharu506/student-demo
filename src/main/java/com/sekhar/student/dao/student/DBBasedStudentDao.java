package com.sekhar.student.dao.student;

import com.sekhar.student.model.*;

public interface DBBasedStudentDao {

	public void insertStudent(Student student);

	public void updateStudent(Student student);

	public Student getStudent(int id);

	public Student[] getStudents();

	public void deleteStudent(int id);

}
