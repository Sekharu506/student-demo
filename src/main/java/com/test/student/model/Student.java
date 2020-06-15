/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.student.model;

public class Student {

	private int id;
	private String name;
	private long phone;
	private int departmentId;
	private int d_no;

	public void setid(int id) {
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

	public void setDno(int d_no) {
		this.d_no = d_no;
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
		return d_no;
	}
}
