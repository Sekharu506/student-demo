package com.sekhar.student.service.department;

import com.sekhar.student.model.Department;

public interface DepartmentService {

	public void addDepartment(Department department);

	public void removeDepartment(int departmentId);

	public void updateDepartment(Department department);

	public void getDepartment(int departmentId);

	public void getDepartments();

}
