package com.sekhar.student.manager.department.impl;

import com.sekhar.student.manager.department.DepartmentManager;
import com.sekhar.student.dao.department.InMemoryBasedDepartmentDao;
import com.sekhar.student.dao.department.impl.InMemoryBasedDepartmentDaoImpl;
import com.sekhar.student.model.*;
import java.util.Set;

public class InMemoryBasedDepartmentManagerImpl implements DepartmentManager {

	InMemoryBasedDepartmentDao departmentdao = null;

	public InMemoryBasedDepartmentManagerImpl() {
		departmentdao = new InMemoryBasedDepartmentDaoImpl();

	}

	public void addDepartment(Department department) {
		departmentdao.addDepartment(department);

	}

	public void removeDepartment(int departmentId) {
		departmentdao.deleteDepartment(departmentId);
	}

	public Department getDepartment(int departmentId) {
		Department department = departmentdao.getDepartment(departmentId);
		return department;
	}

	public Department[] getDepartments() {
		Set<Department> departments = departmentdao.getDepartments();
		int size = departments.size();
		Department departmentarray[] = new Department[size];
		departments.toArray(departmentarray);
		return departmentarray;

	}

	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub

	}

}
