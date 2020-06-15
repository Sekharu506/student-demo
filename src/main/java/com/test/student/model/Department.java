/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.student.model;

/**
 *
 * @author kalyani
 */
public class Department {

	public int department_id;
	private String department_name;
	private String[] courses;

	public Department(int department_id, String department_name, String[] courses) {
		this.department_id = department_id;
		this.department_name = department_name;
		this.courses = courses;

	}

	public void getDepartment() {
		System.out.println("Department_ID     Department_Name");
		System.out.println(" " + department_id + "                      " + department_name);
		System.out.println("Courses");
		for (int i = 0; i < courses.length; i++) {
			System.out.println();
			System.out.println(courses[i]);
		}
	}

}
