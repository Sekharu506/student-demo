package com.sekhar.student.manager.department;

import com.sekhar.student.manager.department.impl.DBBasedDepartmentManagerImpl;
import com.sekhar.student.manager.department.impl.FileBasedDepartmentManagerImpl;
import com.sekhar.student.manager.department.impl.InMemoryBasedDepartmentManagerImpl;

public class DepartmentManagerFactory {
	private static DepartmentManager departmentManager;

	public static DepartmentManager getDepartmentManagerInstance(String persistence) {

		if (persistence.equalsIgnoreCase("IN_MEMORY")) {

			departmentManager = new InMemoryBasedDepartmentManagerImpl();

		} else if (persistence.equalsIgnoreCase("DB")) {

			departmentManager = new DBBasedDepartmentManagerImpl();

		}
		return departmentManager;

	}

	public static DepartmentManager getDepartmentManagerInstance(String persistence, String csvChoice) {
		departmentManager = new FileBasedDepartmentManagerImpl(csvChoice);
		return departmentManager;

	}

}
