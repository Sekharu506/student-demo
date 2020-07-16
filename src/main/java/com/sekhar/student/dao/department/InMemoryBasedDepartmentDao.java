package com.sekhar.student.dao.department;

import java.util.Set;

import com.sekhar.student.model.Department;

public interface InMemoryBasedDepartmentDao {
	public void addDepartment(Department department);

	public void deleteDepartment(int departmentId);

	public Department getDepartment(int departmentId);

	public Set<Department> getDepartments();

}
