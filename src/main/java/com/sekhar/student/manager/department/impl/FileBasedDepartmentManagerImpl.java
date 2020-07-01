package com.sekhar.student.manager.department.impl;

import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.model.Department;
import com.sekhar.student.dao.department.FileBasedDepartmentDao;
import com.sekhar.student.dao.department.impl.FileBasedDepartmentDaoImpl;

public class FileBasedDepartmentManagerImpl implements DepartmentManager {
	FileBasedDepartmentDao departmentdao;

	public FileBasedDepartmentManagerImpl() {
		departmentdao = new FileBasedDepartmentDaoImpl();
	}

	public void makeFile(String path, String filename) {
		departmentdao.createFile(path, filename);

	}

	public void setDepartment(Department department) {

		departmentdao.addDepartment(department);

	}

	public void removeDepartment(int departmentId) {

		departmentdao.deleteDepartment(departmentId);
	}

	public Department getDepartment(int departmentId) {
		Department department;

		department = departmentdao.getDepartment(departmentId);
		return department;
	}

	public Department[] getDepartments() {
		Department[] departments = new Department[100];

		departments = departmentdao.getDepartments();
		return departments;
	}

}
