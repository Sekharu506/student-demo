package com.sekhar.student.manager.department.impl;

import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.model.Department;
import com.sekhar.student.dao.department.DBBasedDepartmentDao;
import com.sekhar.student.dao.department.impl.DBBasedDepartmentDaoImpl;

public class DBBasedDepartmentManagerImpl implements DepartmentManager {

	private DBBasedDepartmentDao departmentDao;

	public DBBasedDepartmentManagerImpl()

	{
		departmentDao = new DBBasedDepartmentDaoImpl();
	}

	public void addDepartment(Department department) {

		departmentDao.insertDepartment(department);
	}

	public void removeDepartment(int departmentId) {

		departmentDao.deleteDepartment(departmentId);
	}

	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);

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

}
