package com.sekhar.student.manager.student;

import com.sekhar.student.manager.student.impl.*;

public class StudentManagerFactory {

	private static StudentManager studentManager;

	public static StudentManager getStudentManagerInstance(String persistence) {

		if (persistence.equalsIgnoreCase("IN_MEMORY")) {
			studentManager = new InMemoryBasedStudentManagerImpl();

		} else if (persistence.equalsIgnoreCase("DB")) {
			studentManager = new DBBasedStudentManagerImpl();

		}


		return studentManager;

	}

	public static StudentManager getStudentManagerInstance(String persistence, String csvChoice) {
		studentManager = new FileBasedStudentManagerImpl(csvChoice);
		return studentManager;
	}

}
