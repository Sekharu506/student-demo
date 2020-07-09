package com.sekhar.student.dao.department.impl;

import com.sekhar.student.dao.department.FileBasedDepartmentDao;
import com.sekhar.student.model.Department;

import java.io.*;

public class FileBasedDepartmentDaoImpl implements FileBasedDepartmentDao {
	private File files[];
	private String path;
	private int fileObjectPointer = -1;

	public FileBasedDepartmentDaoImpl() {
		this.path = "/home/cultuzz/sekhar-demo-files/departments/";
		files = new File[100];
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
		fileObjectPointer++;
		String filename = "Department" + fileObjectPointer + ".ser";
		files[fileObjectPointer] = createFileObject(filename);
		if (files[fileObjectPointer].exists()) {
			try {
				FileOutputStream fileOutputPointer = new FileOutputStream(files[fileObjectPointer]);

				try {

					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputPointer);

					objectOutputStream.writeObject(department);
					System.out.println(" " + department.getDepartmentId() + " Added");

					objectOutputStream.close();
				} catch (IOException e) {
					System.out.println("IO Exception");
				}
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found Exception");
			}


		}
	}

	public void deleteDepartment(int departmentId) {
		File[] files2;
		int tempPointer = 0;
		int foundAtIndex = -1;
		Department department = new Department();
		do {


			try {
				FileInputStream fileInputStream = new FileInputStream(files[tempPointer]);
				try {
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


					try {

						department = (Department) objectInputStream.readObject();

						if (departmentId == department.getDepartmentId()) {
							foundAtIndex = tempPointer;
							break;
						}

					} catch (ClassNotFoundException e) {
						System.out.println("Class Not Found Exception" + e.getMessage());
					}


					System.out.println("Student Deleted");

				} catch (IOException e) {
					System.out.println("IO Exception");
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				System.out.println("File Not Found Exception");
			}
			tempPointer++;
		} while (tempPointer <= fileObjectPointer);

		if (foundAtIndex != -1) {
			int size = fileObjectPointer + 1;
			files2 = new File[size];
			int j = 0;
			for (int i = 0; i <= fileObjectPointer; i++) {
				if (i == foundAtIndex) {
					continue;
				}

				files2[j] = files[i];
				j++;
			}
			files = files2;
			fileObjectPointer--;
			System.out.println(" " + department.getDepartmentId());
		} else {

			System.out.println("Not Found");
		}

	}

	public Department getDepartment(int departmentId) {
		Department department = null;
		if (fileObjectPointer != -1) {
			int tempPointer = 0;
			do {


				try {
					FileInputStream fileInputStream = new FileInputStream(files[tempPointer]);
					try {
						ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

						try {
							department = (Department) objectInputStream.readObject();

							if (department.getDepartmentId() == departmentId) {
								return department;

							}
						} catch (ClassNotFoundException e) {
							System.out.println("Class not Found Exception  " + e.getMessage());
						}
					} catch (IOException e) {
						System.out.println("IO Exception " + e.getMessage());

					}


				} catch (FileNotFoundException e) {
					System.out.println("FILE Not Found Exception  " + e.getMessage());

				}

			} while (tempPointer <= fileObjectPointer);
		} else {
			System.out.println("Emply list");
			return null;
		}
		return department;
	}

	public Department[] getDepartments() {

		if (fileObjectPointer != -1) {
			int count = fileObjectPointer;
			count++;
			int tempPointer = 0;
			Department[] departments = new Department[count];
			int arrayIndex = 0;
			do {


				try {
					FileInputStream fileInputStream = new FileInputStream(files[tempPointer]);

					try {
						ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

						try {
							departments[arrayIndex] = (Department) objectInputStream.readObject();

							arrayIndex++;
							tempPointer++;
						} catch (ClassNotFoundException e) {
							System.out.println("Class Not Found Exception,No More Student");
						}


						return departments;

					} catch (IOException e) {
						System.out.println("IO Exception");
						e.printStackTrace();

						return null;
					}
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found Exception");
					return null;

				}


			} while (tempPointer <= fileObjectPointer);
		} else {

			System.out.println("Emply LIst");
			return null;
		}

	}

}
