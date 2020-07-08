package com.sekhar.student.dao.student.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sekhar.student.model.*;

import com.sekhar.student.dao.student.FileBasedStudentDao;

public class FileBasedStudentDaoImpl implements FileBasedStudentDao {

	private File file;
	private String path;
	private String filename;

	public FileBasedStudentDaoImpl() {
		this.path = "home/cultuzz/";
		this.filename = "test.txt";
		file = createFileObject(filename);

	}

	public File createFileObject(String filename) {

		File tempfile = new File(path + filename);
		boolean isCreated = false;
		tempfile = new File(path + filename);
		try {
			isCreated = tempfile.createNewFile();

			if (isCreated) {
				System.out.println(tempfile.getName() + " File Created");

			}

			else {
				System.out.println("File Already Created");

			}
		} catch (IOException e) {
			System.out.println("Exception Thrown While Creating FIle");

		}
		return tempfile;
	}

	public void addStudent(Student student) {
		if (file.exists()) {
			try {
				FileOutputStream fout = new FileOutputStream(file);

				try {

					ObjectOutputStream fileobject = new ObjectOutputStream(fout);

					fileobject.writeObject(student);
					System.out.println(" " + student.getName() + " Added");

					fileobject.close();
				} catch (IOException e) {
					System.out.println("IO Exception");
				}
			} catch (FileNotFoundException e)

			{
				System.out.println("File Not Found Exception");
			}
		} else {
			System.out.println("File Not Exists");
		}

	}

	public void deleteStudent(int id) {
		File file2;
		file2 = createFileObject("temp.txt");
		if (file.exists() && file2.exists()) {
			Student student;
			try {
				FileInputStream fin = new FileInputStream(file);
				FileOutputStream fout = new FileOutputStream(file2);
				try {
					ObjectInputStream fileobjectin = new ObjectInputStream(fin);
					ObjectOutputStream fileobjectout = new ObjectOutputStream(fout);

					do {
						try {

							student = (Student) fileobjectin.readObject();

							if (student.getId() == id) {
								continue;
							} else {
								fileobjectout.writeObject(student);
							}
						}

						catch (ClassNotFoundException e) {
							break;
						}

					} while (true);
					fileobjectin.close();
					fileobjectout.close();
					file.delete();
					file = new File(path + filename);
					file2.renameTo(file);

					System.out.println("Student Deleted");

				} catch (IOException e) {
					System.out.println("IO Exception");
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				System.out.println("File Not Found Exception");
			}

		} else {
			System.out.println("Files not Exist");
		}

	}

	public Student getStudent(int id) {

		if (file.exists()) {
			Student student;

			try {
				FileInputStream fin = new FileInputStream(file);
				try {
					ObjectInputStream fileobject = new ObjectInputStream(fin);

					do {
						try {
							student = (Student) fileobject.readObject();

							if (student.getId() == id) {
								return student;

							}

						}

						catch (ClassNotFoundException e) {
							fileobject.close();
							System.out.println("Class Not Found Exception");
							return null;
						}

					} while (true);

				}

				catch (IOException e) {
					System.out.println("IO Exception");
					return null;
				}
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found Exception");
				return null;
			}

		} else {
			return null;
		}

	}

	public Student[] getStudents() {

		if (file.exists()) {
			Student[] students = new Student[100];

			try {
				FileInputStream fin = new FileInputStream(file);

				try {
					ObjectInputStream fileobject = new ObjectInputStream(fin);
					int i = 0;
					do {
						try {
							students[i] = (Student) fileobject.readObject();

							i++;

						} catch (ClassNotFoundException e) {
							fileobject.close();
							System.out.println("Class Not Found Exception,No More Student");
							break;
						}

					} while (true);
					fileobject.close();
					return students;

				}

				catch (IOException e) {
					System.out.println("IO Exception");
					e.printStackTrace();

					return null;
				}
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found Exception");
				return null;
			}

		} else {
			return null;
		}

	}

}
