/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.manager;

import java.util.*;

import com.test.student.model.Department;

public interface DepartmentManager {

	int TOTAL_DEPARTMENTS = 10;
	List<Department> departments = new ArrayList<Department>(TOTAL_DEPARTMENTS);

	public void addDepartment(Department department);

	public void deleteDepartment(int department_id);

	public Department getDepartment(int department_id);

	public List<Department> getDepartments();
}
