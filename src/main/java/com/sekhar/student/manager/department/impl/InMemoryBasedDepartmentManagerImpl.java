package com.sekhar.student.manager.department.impl;

import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.dao.department.InMemoryBasedDepartmentDao;
import com.sekhar.student.dao.department.impl.InMemoryBasedDepartmentDaoImpl;
import com.sekhar.student.model.*;
import java.util.Set;

public class InMemoryBasedDepartmentManagerImpl implements DepartmentManager {

	private InMemoryBasedDepartmentDao departmentDao = null;

	public InMemoryBasedDepartmentManagerImpl() {
		departmentDao = new InMemoryBasedDepartmentDaoImpl();

	}

	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);

	}

	public void removeDepartment(int departmentId) {
		departmentDao.deleteDepartment(departmentId);
	}

	public Department getDepartment(int departmentId) {
		Department department = departmentDao.getDepartment(departmentId);
		return department;
	}

	public Department[] getDepartments() {
		Set<Department> departments = departmentDao.getDepartments();
		int size = departments.size();
		Department departmentarray[] = new Department[size];
		departments.toArray(departmentarray);
		return departmentarray;

	}

	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub

	}

}
