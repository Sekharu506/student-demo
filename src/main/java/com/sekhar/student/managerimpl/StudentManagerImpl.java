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

	Set<Student> students = new HashSet<Student>();

	public void addStudent(Student student) {
		students.add(student);
		System.out.println("Student Added");
	}

	public void deleteStudent(int id) {
		if (!students.isEmpty()) {
			Student student;
			int found = 0;
			Iterator<Student> iterator = students.iterator();
			while (iterator.hasNext()) {
				student = iterator.next();
				if (student.getId() == id) {
					found = 1;

					students.remove(student);
					System.out.println(" " + student.getName() + "  removed");
					break;
				}

			}
			if (found == 0) {
				System.out.println("Student Not Found");
			}
		} else {
			System.out.println("No Students In list");
		}

	}

	public Student getStudent(int id) {
		if (!students.isEmpty()) {

			Iterator<Student> iterator = students.iterator();
			Student student;
			int found = 0;
			do {
				student = iterator.next();
				if (student.getId() == id) {
					found = 1;
					break;

				}

			} while (iterator.hasNext());
			if (found == 0) {
				return null;
			} else {
				return student;
			}
		} else {
			return null;
		}
	}

	public Set<Student> getStudents() {
		return students;
	}

	public List<Student> sortStudentsById(Set<Student> students) {
		
		if(!students.isEmpty())
		{
			
		
		List<Student> studentslist = new ArrayList<Student>(students);

		for (int i = 0; i < studentslist.size(); i++) {

			for (int j = 0; j < studentslist.size() - i - 1; j++) {
				if (studentslist.get(j).getId() > studentslist.get(j + 1).getId()) {
					Collections.swap(studentslist, j, j + 1);
				}

			}

		}

		return studentslist;
	}
		else
		{
			return null;
		}
	}
}
