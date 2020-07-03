package com.sekhar.student.service.department.impl;

import com.sekhar.student.service.department.DepartmentService;
import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.manager.department.DepartmentManagerFactory;
import com.sekhar.student.model.Department;

public class DepartmentServiceImpl implements DepartmentService {
	DepartmentManager departmentmanager;

	public DepartmentServiceImpl(String persistence) {
		departmentmanager = DepartmentManagerFactory.getDepartmentManagerInstance(persistence);

	}

	public void makeFile(String path, String filename) {

		departmentmanager.makeFile(path, filename);

	}

	public void setDepartment(Department department) {

		departmentmanager.setDepartment(department);

	}

	public void removeDepartment(int departmentId) {
		departmentmanager.removeDepartment(departmentId);

	}

	public void updateDepartment(Department department) {
		departmentmanager.updateDepartment(department);

	}

	public void getDepartment(int departmentId) {
		Department department;
		department = departmentmanager.getDepartment(departmentId);

		if (department != null) {
			System.out.println("  DepartmentId  DepartmentName Course1 Course2 Course3");
			System.out.println("  " + department.toString());
		} else

		{
			System.out.println("Department Not Exists");
		}

	}

	public void getDepartments() {
		Department[] departments;
		departments = departmentmanager.getDepartments();
		if (departments != null) {
			System.out.println("  DepartmentId  DepartmentName Course1 Course2 Course3");
			for (int i = 0; i < departments.length; i++) {
				System.out.println(" " + departments[i].toString());
			}

		} else {
			System.out.println("No Department Found");
		}
	}

}
