package com.sekhar.student.manager.department;

import com.sekhar.student.model.Department;

public interface DepartmentManager {
	public void makeFile(String path, String filename);

	public void updateDepartment(Department department);

	public void setDepartment(Department department);

	public void removeDepartment(int departmentId);

	public Department getDepartment(int departmentId);

	public Department[] getDepartments();

}
