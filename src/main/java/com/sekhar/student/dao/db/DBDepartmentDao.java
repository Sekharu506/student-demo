package com.sekhar.student.dao.db;

import com.sekhar.student.model.*;

public interface DBDepartmentDao {
	public void insertDepartment(Department department);

	public void deleteDepartment(int departmentId);

	public void updateDepartment(int departmentId);

	public void getDepartment(int departmentId);

	public void getDepartments();

}
