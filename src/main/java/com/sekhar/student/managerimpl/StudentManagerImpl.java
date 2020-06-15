/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.managerimpl;

import com.sekhar.student.manager.StudentManager;
import com.test.student.model.Student;

import java.util.*;

public class StudentManagerImpl implements StudentManager {

	public void addStudent(Student student) {
		students.add(student);
		System.out.println("Student Added");
	}

	public void deleteStudent(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
				System.out.println("Student Removed");
				break;
			} else {
				System.out.println("Student Doesnt Found");
			}
		}
	}

	public Student getStudent(int id) {

		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				index = i;

			}
		}

		return students.get(index);
	}

	public List<Student> getStudents() {
		return students;
	}
}
