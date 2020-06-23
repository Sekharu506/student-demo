package com.sekhar.student.filedbaseddaomanager;

import com.sekhar.student.daomodel.*;
import java.io.File;

public interface StudentDao {
	public void createFile(String path, String filename);

	public File createFileObject(String filename);

	public void addStudent(Student student);

	public void deleteStudent(int id);

	public Student getStudent(int id);

	public Student[] getStudents();

}
