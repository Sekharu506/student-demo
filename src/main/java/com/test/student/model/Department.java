/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.student.model;

public class Department {

	private int departmentId;
	private String departmentName;
	private String[] courses;

	public Department() {

	}

	public Department(int departmentId, String departmentName, String[] courses) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.courses = courses;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setCourses(String courses[]) {
		this.courses = courses;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String[] getCourses() {
		return courses;
	}

	public boolean equals(Department department) {
		if (this.departmentId == department.getDepartmentId())
			return true;
		else
			return false;

	}

	public int hashCode() {
		return departmentId+departmentName.hashCode()+courses.hashCode();
	}

	public String toString() {
		return " " + departmentId + "         " + departmentName + "         " + courses[0] + "        " + courses[1]
				+ "         " + courses[2];
	}

}
