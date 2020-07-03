package com.sekhar.student.manager.department.impl;

import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.model.Department;
import com.sekhar.student.dao.department.DBBasedDepartmentDao;
import com.sekhar.student.dao.department.impl.DBBasedDepartmentDaoImpl;

public class DBBasedDepartmentManagerImpl implements DepartmentManager {

	DBBasedDepartmentDao departmentdao;

	public DBBasedDepartmentManagerImpl()

	{
		departmentdao = new DBBasedDepartmentDaoImpl();
	}

	public void setDepartment(Department department) {

		departmentdao.insertDepartment(department);
	}

	public void removeDepartment(int departmentId) {

		departmentdao.deleteDepartment(departmentId);
	}

	public void updateDepartment(Department department) {
		departmentdao.updateDepartment(department);

	}

	public Department getDepartment(int departmentId) {

		Department department;
		department = departmentdao.getDepartment(departmentId);
		return department;
	}

	public Department[] getDepartments() {
		Department[] departments = new Department[100];
		departments = getDepartments();
		return departments;
	}

	public void makeFile(String path, String filename) {
		// TODO Auto-generated method stub

	}

}
