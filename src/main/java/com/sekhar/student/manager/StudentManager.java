/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.manager;

import java.util.*;

import com.test.student.model.Student;

public interface StudentManager {

	public void addStudent(Student student);

	public void deleteStudent(int id);

	public Student getStudent(int id);

	public Set<Student> getStudents();
    public List<Student>  sortStudentsById(Set<Student> students);
}
