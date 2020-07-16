package com.sekhar.student.manager.department.impl;

import com.sekhar.student.dao.department.FileBasedDepartmentDao;
import com.sekhar.student.dao.department.FileBasedDepartmentDaoFactory;
import com.sekhar.student.dao.department.impl.FileCsvBasedDepartmentDaoImpl;
import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.model.Department;

public class FileBasedDepartmentManagerImpl implements DepartmentManager {
	private FileBasedDepartmentDao departmentDao;

	public FileBasedDepartmentManagerImpl(String csvChoice) {
		departmentDao = FileBasedDepartmentDaoFactory.getInstanceOfDepartmentDao(csvChoice);
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
