package com.sekhar.student.dao.department;

import com.sekhar.student.model.*;

public interface DBBasedDepartmentDao {
	public void insertDepartment(Department department);

	public void deleteDepartment(int departmentId);

	public void updateDepartment(Department department);

	public Department getDepartment(int departmentId);

	public Department[] getDepartments();

}
