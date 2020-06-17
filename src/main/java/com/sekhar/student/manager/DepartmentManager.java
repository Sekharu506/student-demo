/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.manager;

import java.util.*;

import com.test.student.model.Department;

public interface DepartmentManager {

	public void addDepartment(Department department);

	public void deleteDepartment(int departmentId);

	public Department getDepartment(int departmentId);

	public Set<Department> getDepartments();
}
