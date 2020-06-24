package com.sekhar.student.manager.inmemory;

import java.util.List;
import java.util.Set;
import com.sekhar.student.model.*;

public interface InMemoryBasedStudentManager {

	public void setStudent(Student student);

	public void removeStudent(int id);

	public Student getStudent();

	public Set<Student> getStudents();

	public List<Student> sortStudents(Set<Student> students);

}
