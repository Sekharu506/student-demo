package com.sekhar.student.dao.address.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.sekhar.student.model.Address;

import com.sekhar.student.dao.address.FileBasedAddressDao;

public class FileBasedAddressDaoImpl implements FileBasedAddressDao {
	private File file;
	private String path;
	private String filename;

	public FileBasedAddressDaoImpl() {
		this.path = "/home/cultuzz/";
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

	public void addAddress(Address address) {
		if (file.exists()) {
			try {
				FileOutputStream fout = new FileOutputStream(file);

				try {

					ObjectOutputStream fileobject = new ObjectOutputStream(fout);

					fileobject.writeObject(address);
					System.out.println(" " + address.getDno() + " Added");

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

	public void deleteAddress(int doorNo) {
		File file2;
		file2 = createFileObject("temp.txt");
		if (file.exists() && file2.exists()) {
			Address address;
			try {
				FileInputStream fin = new FileInputStream(file);
				FileOutputStream fout = new FileOutputStream(file2);
				try {
					ObjectInputStream fileobjectin = new ObjectInputStream(fin);
					ObjectOutputStream fileobjectout = new ObjectOutputStream(fout);

					do {
						try {

							address = (Address) fileobjectin.readObject();

							if (address.getDno() == doorNo) {
								continue;
							} else {
								fileobjectout.writeObject(address);
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

	public Address getAddress(int doorNO) {

		if (file.exists()) {
			Address address;

			try {
				FileInputStream fin = new FileInputStream(file);
				try {
					ObjectInputStream fileobject = new ObjectInputStream(fin);

					do {
						try {
							address = (Address) fileobject.readObject();

							if (address.getDno() == doorNO) {
								return address;

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

	public Address[] getAddresses() {

		if (file.exists()) {
			Address[] addresses = new Address[100];

			try {
				FileInputStream fin = new FileInputStream(file);

				try {
					ObjectInputStream fileobject = new ObjectInputStream(fin);
					int i = 0;
					do {
						try {
							addresses[i] = (Address) fileobject.readObject();

							i++;

						} catch (ClassNotFoundException e) {
							fileobject.close();
							System.out.println("Class Not Found Exception,No More Student");
							break;
						}

					} while (true);
					fileobject.close();
					return addresses;

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
