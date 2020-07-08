package com.sekhar.student.dao.department.impl;

import com.sekhar.student.model.Department;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sekhar.student.dao.department.FileBasedDepartmentDao;

public class FileBasedDepartmentDaoImpl implements FileBasedDepartmentDao {
	private File file;
	private String path;
	private String filename;

	public FileBasedDepartmentDaoImpl() {
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

	public void addDepartment(Department department) {
		if (file.exists()) {
			try {
				FileOutputStream fout = new FileOutputStream(file);

				try {

					ObjectOutputStream fileobject = new ObjectOutputStream(fout);

					fileobject.writeObject(department);
					System.out.println(" " + department.getDepartmentId() + " Added");

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

	public void deleteDepartment(int departmentId) {
		File file2;
		file2 = createFileObject("temp.txt");
		if (file.exists() && file2.exists()) {
			Department department;
			try {
				FileInputStream fin = new FileInputStream(file);
				FileOutputStream fout = new FileOutputStream(file2);
				try {
					ObjectInputStream fileobjectin = new ObjectInputStream(fin);
					ObjectOutputStream fileobjectout = new ObjectOutputStream(fout);

					do {
						try {

							department = (Department) fileobjectin.readObject();

							if (department.getDepartmentId() == departmentId) {
								continue;
							} else {
								fileobjectout.writeObject(department);
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

	public Department getDepartment(int departmentId) {

		if (file.exists()) {
			Department department;

			try {
				FileInputStream fin = new FileInputStream(file);
				try {
					ObjectInputStream fileobject = new ObjectInputStream(fin);

					do {
						try {
							department = (Department) fileobject.readObject();

							if (department.getDepartmentId() == departmentId) {
								return department;

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

	public Department[] getDepartments() {

		if (file.exists()) {
			Department[] departments = new Department[100];

			try {
				FileInputStream fin = new FileInputStream(file);

				try {
					ObjectInputStream fileobject = new ObjectInputStream(fin);
					int i = 0;
					do {
						try {
							departments[i] = (Department) fileobject.readObject();

							i++;

						} catch (ClassNotFoundException e) {
							fileobject.close();
							System.out.println("Class Not Found Exception,No More Student");
							break;
						}

					} while (true);
					fileobject.close();
					return departments;

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
