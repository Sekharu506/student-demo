package com.sekhar.student.dao.file;

import java.io.File;

import com.sekhar.student.model.*;

public interface FileBasedStudentDao {

	public void createFile(String path, String filename);

	public File createFileObject(String filename);

	public void addStudent(Student student);

	public void deleteStudent(int id);

	public Student getStudent(int id);

	public Student[] getStudents();

}
