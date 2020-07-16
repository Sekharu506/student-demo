/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.model;

public class Student implements java.io.Serializable {
	static final long serialVersionUID = 30L;
	private int id;
	private String name;
	private long phone;
	private int departmentId;
	private int doorNo;

	public Student() {

	}

	public Student(int id, String name, long phone, int departmentId, int doorNo) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.departmentId = departmentId;
		this.doorNo = doorNo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name)

	{
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;

	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;

	}

	public void setDno(int doorNo) {
		this.doorNo = doorNo;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public int getDno() {
		return doorNo;
	}

	public boolean equals(Student student) {
		if (this.id == student.getId())
			return true;
		else
			return false;
	}

	public int hashCode() {
		return id + name.hashCode();
	}

	public String toString() {
		return " " + id + "           " + name + "           " + phone;
	}
}
