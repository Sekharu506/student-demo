/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.managerimpl;

import java.util.*;

import com.sekhar.student.manager.DepartmentManager;
import com.test.student.model.Department;

/**
 *
 * @author kalyani
 */
public class DepartmentManagerImpl implements DepartmentManager {

	public void addDepartment(Department department) {
		departments.add(department);
		System.out.println("Department Added");
	}

	public void deleteDepartment(int department_id) {
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).department_id == department_id) {
				departments.remove(i);
				System.out.println("Department Removed");
				break;
			} else {
				System.out.println("Department Not Found");
			}
		}

	}

	public Department getDepartment(int department_id) {
		int index = -1;
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).department_id == department_id) {
				index = i;
				break;
			}

		}

		return departments.get(index);

	}

	public List<Department> getDepartments() {
		return departments;
	}

}
