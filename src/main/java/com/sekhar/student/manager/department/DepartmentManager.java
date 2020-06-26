package com.sekhar.student.manager.department;
import com.sekhar.student.model.Department;
public interface DepartmentManager {
	
	
	public void setDepartment(Department department);
	public void removeDepartment(int departmentId);
	
	public Department getDepartment(int departmentId);
	public Department[] getDepartments();

}
