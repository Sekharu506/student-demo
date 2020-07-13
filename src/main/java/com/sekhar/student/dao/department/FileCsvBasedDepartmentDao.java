package com.sekhar.student.dao.department;

import com.sekhar.student.model.Department;

public interface FileCsvBasedDepartmentDao {


    public void addDepartment(Department department);

    public void deleteDepartment(int departmentId);

    public Department getDepartment(int departmentId);

    public Department[] getDepartments();


}


