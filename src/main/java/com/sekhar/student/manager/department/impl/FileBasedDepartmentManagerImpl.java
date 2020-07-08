package com.sekhar.student.manager.department.impl;

import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.model.Department;
import com.sekhar.student.dao.department.FileBasedDepartmentDao;
import com.sekhar.student.dao.department.impl.FileBasedDepartmentDaoImpl;

public class FileBasedDepartmentManagerImpl implements DepartmentManager {
	private FileBasedDepartmentDao departmentDao;

	public FileBasedDepartmentManagerImpl() {
		departmentDao = new FileBasedDepartmentDaoImpl();
	}

	public void addDepartment(Department department) {

		departmentDao.addDepartment(department);

	}

	public void removeDepartment(int departmentId) {

		departmentDao.deleteDepartment(departmentId);
	}

	public Department getDepartment(int departmentId) {
		Department department;

		department = departmentDao.getDepartment(departmentId);
		return department;
	}

	public Department[] getDepartments() {
		Department[] departments = new Department[100];

		departments = departmentDao.getDepartments();
		return departments;
	}

	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub

	}

}
