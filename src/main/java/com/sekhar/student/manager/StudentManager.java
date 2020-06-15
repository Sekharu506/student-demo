/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.manager;

import java.util.*;

import com.test.student.model.Student;

/**
 *
 * @author kalyani
 */
public interface StudentManager {

	int TOTAL_STUDENTS = 20;
	List<Student> students = new ArrayList<Student>(TOTAL_STUDENTS);

	public void addStudent(Student student);

	public void deleteStudent(int id);

	public Student getStudent(int id);

	public List<Student> getStudents();

}
