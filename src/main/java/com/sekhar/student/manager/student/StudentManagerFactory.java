package com.sekhar.student.manager.student;

import com.sekhar.student.manager.student.impl.*;

public class StudentManagerFactory {

	private static String persistence = null;

	public static StudentManager getStudentManagerInstance(String persistence) {

		StudentManagerFactory.persistence = persistence;

		StudentManager studentmanager = null;

		if (persistence == "IN_MEMORY") {
			studentmanager = new InMemoryBasedStudentManagerImpl();

		} else if (persistence == "DB") {
			studentmanager = new DBBasedStudentManagerImpl();

		} else if (persistence == "FILE") {
			studentmanager = new FileBasedStudentManagerImpl();

		}
		return studentmanager;

	}

}
