/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.managerimpl;

import java.util.*;

import com.sekhar.student.manager.DepartmentManager;
import com.test.student.model.Department;
import com.test.student.model.Student;

public class DepartmentManagerImpl implements DepartmentManager {

	Set<Department> departments = new HashSet<Department>();

	public void addDepartment(Department department) {
		departments.add(department);
		System.out.println("Department Added");
	}

	public void deleteDepartment(int departmentId) {
		if (!departments.isEmpty()) {
			Department department;
			int found = 0;
			Iterator<Department> iterator = departments.iterator();
			while (iterator.hasNext()) {
				department = iterator.next();
				if (department.getDepartmentId() == departmentId) {
					found = 1;

					departments.remove(department);
					System.out.println(" " + department.getDepartmentName() + "  removed");
					break;
				}

			}
			if (found == 0) {
				System.out.println("Department Not Found");
			}
		} else {
			System.out.println("No Department List");
		}

	}

	public Department getDepartment(int departmentId) {
		if (!departments.isEmpty()) {
			Department department;
			int found = 0;
			Iterator<Department> iterator = departments.iterator();
			do {
				department = iterator.next();
				if (department.getDepartmentId() == departmentId) {
					found = 1;
					break;
				}

			} while (iterator.hasNext());
			if (found == 1) {
				return department;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Set<Department> getDepartments() {
		return departments;
	}

}
