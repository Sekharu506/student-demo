package com.sekhar.student.manager.department;

import com.sekhar.student.manager.department.impl.DBBasedDepartmentManagerImpl;
import com.sekhar.student.manager.department.impl.FileBasedDepartmentManagerImpl;
import com.sekhar.student.manager.department.impl.InMemoryBasedDepartmentManagerImpl;

public class DepartmentManagerFactory {
	private static DepartmentManager departmentmanager;

	public static DepartmentManager getDepartmentManagerInstance(String persistence) {

		if (persistence == "IN_MEMORY") {

			departmentmanager = new InMemoryBasedDepartmentManagerImpl();

		} else if (persistence == "DB") {

			departmentmanager = new DBBasedDepartmentManagerImpl();

		}

		return departmentmanager;

	}

	public static DepartmentManager getDepartmentManagerInstance(String persistence, String path, String filename) {

		departmentmanager = new FileBasedDepartmentManagerImpl(path, filename);
		return departmentmanager;

	}
}
