package com.sekhar.student.manager.student;

import com.sekhar.student.manager.student.impl.*;

public class StudentManagerFactory {

	private static StudentManager studentmanager;

	public static StudentManager getStudentManagerInstance(String persistence) {

		if (persistence == "IN_MEMORY") {
			studentmanager = new InMemoryBasedStudentManagerImpl();

		} else if (persistence == "DB") {
			studentmanager = new DBBasedStudentManagerImpl();

		}
		return studentmanager;

	}

	public static StudentManager getStudentManagerInstance(String persistence, String path, String filename) {

		studentmanager = new FileBasedStudentManagerImpl(path, filename);
		return studentmanager;

	}

}
