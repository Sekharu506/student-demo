package com.sekhar.student.manager.department;

import com.sekhar.student.manager.department.impl.DBBasedDepartmentManagerImpl;
import com.sekhar.student.manager.department.impl.FileBasedDepartmentManagerImpl;
import com.sekhar.student.manager.department.impl.InMemoryBasedDepartmentManagerImpl;

public class DepartmentManagerFactory {

	private static String persistence;

	public static DepartmentManager getDepartmentManagerInstance(String persistence) {
		DepartmentManagerFactory.persistence = persistence;
		DepartmentManager departmentmanager = null;

		if (persistence == "IN_MEMORY") {

			departmentmanager = new InMemoryBasedDepartmentManagerImpl();

		} else if (persistence == "DB") {

			departmentmanager = new DBBasedDepartmentManagerImpl();

		} else if (persistence == "FILE") {

			departmentmanager = new FileBasedDepartmentManagerImpl();

		}

		return departmentmanager;

	}

}
