package com.sekhar.student.manager.department;

import com.sekhar.student.model.Department;

public interface DepartmentManager {

	public void updateDepartment(Department department);

	public void addDepartment(Department department);

	public void removeDepartment(int departmentId);

	public Department getDepartment(int departmentId);

	public Department[] getDepartments();

}
