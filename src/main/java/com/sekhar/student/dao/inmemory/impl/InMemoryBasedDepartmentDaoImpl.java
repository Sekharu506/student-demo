package com.sekhar.student.dao.inmemory.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sekhar.student.model.Department;
import com.sekhar.student.dao.inmemory.*;

public class InMemoryBasedDepartmentDaoImpl implements InMemoryBasedDepartmentDao {
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
