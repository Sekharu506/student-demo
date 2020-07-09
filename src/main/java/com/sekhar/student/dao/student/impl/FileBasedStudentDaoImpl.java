package com.sekhar.student.dao.student.impl;

import com.sekhar.student.dao.student.FileBasedStudentDao;
import com.sekhar.student.model.Student;

import java.io.*;

public class FileBasedStudentDaoImpl implements FileBasedStudentDao {

	private File files[] = new File[100];
	private String path;
	private String filename;
	private int fileObjectPointer = -1;

	public FileBasedStudentDaoImpl() {
		this.path = "/home/cultuzz/student-demo-files/students/";


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
		fileObjectPointer++;
		try {
			int index = fileObjectPointer;
			index++;

			String filename = "Student" + index + ".ser";
			files[fileObjectPointer] = createFileObject(filename);

			FileOutputStream fileOutputStream = new FileOutputStream(files[fileObjectPointer]);

			try {

				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

				objectOutputStream.writeObject(student);
				System.out.println(" " + student.getName() + " Added");

				fileOutputStream.close();
			} catch (IOException e) {
				System.out.println("IO Exception");
			}
			} catch (FileNotFoundException e)

			{
				System.out.println("File Not Found Exception");
			}


	}

	public void deleteStudent(int id) {
		File[] files2;
		if (fileObjectPointer != -1) {
			Student student;
			int count = fileObjectPointer;
			count++;
			int foundAtIndex = -1;
			files2 = new File[count];

			int tempPointer = 0;
			do {


				try {
					FileInputStream fileInputStream = new FileInputStream(files[tempPointer]);
					try {
						ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


						try {

							student = (Student) objectInputStream.readObject();

							if (student.getId() == id) {

								foundAtIndex = tempPointer;
								break;
							}
						} catch (ClassNotFoundException e) {
							System.out.println("Class Not Found Exception  " + e.getMessage());
						}

					} catch (IOException e) {
						System.out.println("IO Exception");
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found Exception");
				}

			} while (tempPointer <= fileObjectPointer);

			if (foundAtIndex != -1) {
				int arrayIndex = 0;
				for (int i = 0; i < fileObjectPointer; i++) {
					if (i == foundAtIndex) {
						continue;
					}
					files2[arrayIndex] = files[i];
					arrayIndex++;
				}
				files = files2;
				System.out.println("Object Deleted");
			} else {
				System.out.println("Student Not Found");
			}

		} else {
			System.out.println("Files not Exist");
		}

	}

	public Student getStudent(int id) {
		Student student;
		if (fileObjectPointer != -1) {

			int tempPointer = 0;
			do {

				try {
					FileInputStream fileInputStream = new FileInputStream(files[tempPointer]);
					try {
						ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


						try {
							student = (Student) objectInputStream.readObject();

							if (student.getId() == id) {
								return student;

							}

						} catch (ClassNotFoundException e) {

							System.out.println("Class Not Found Exception");
							return null;
						}


					} catch (IOException e) {
						System.out.println("IO Exception");
						return null;
					}
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found Exception");
					return null;
				}
			} while (tempPointer <= fileObjectPointer);

		} else {

			return null;
		}
		return student;
	}

	public Student[] getStudents() {

		if (fileObjectPointer != -1) {
			int count = fileObjectPointer;
			count++;
			int tempPointer = 0;

			Student[] students = new Student[count];
			int arrayIndex = 0;
			do {


				try {
					FileInputStream fileInputStream = new FileInputStream(files[tempPointer]);

					try {
						ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


						try {
							students[arrayIndex] = (Student) objectInputStream.readObject();


						} catch (ClassNotFoundException e) {
							System.out.println("Class Not Found Exception,No More Student");
							break;
						}


					} catch (IOException e) {
						System.out.println("IO Exception");
						e.printStackTrace();

						return null;
					}
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found Exception");
					return null;
				}
				arrayIndex++;
				tempPointer++;
			} while (tempPointer <= fileObjectPointer);
			return students;
		} else {


			return null;
		}

	}

}
