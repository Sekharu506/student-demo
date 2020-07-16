package com.sekhar.student.dao.student;

import java.util.List;
import java.util.Set;
import com.sekhar.student.model.Student;

public interface InMemoryBasedStudentDao {
	public void addStudent(Student student);

	public void deleteStudent(int id);

	public Student getStudent(int id);

	public Set<Student> getStudents();

	public List<Student> sortStudentsById();

}
