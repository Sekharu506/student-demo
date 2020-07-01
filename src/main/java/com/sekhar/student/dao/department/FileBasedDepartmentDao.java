package com.sekhar.student.dao.department;
import java.io.File;


import com.sekhar.student.model.Department;
public interface FileBasedDepartmentDao {

	public void createFile(String path, String filename);

	public File createFileObject(String filename);

	public void addDepartment(Department department);

	public void deleteDepartment(int departmentId);

	public Department getDepartment(int departmentId);

	public Department[] getDepartments();

}
