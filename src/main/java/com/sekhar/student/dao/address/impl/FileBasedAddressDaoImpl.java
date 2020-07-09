package com.sekhar.student.dao.address.impl;

import com.sekhar.student.dao.address.FileBasedAddressDao;
import com.sekhar.student.model.Address;

import java.io.*;

public class FileBasedAddressDaoImpl implements FileBasedAddressDao {
    private File[] files;
    private File[] files2;
    private int fileObjectPointer = -1;
    private final String path;


    public FileBasedAddressDaoImpl() {
        this.path = "/home/cultuzz/student-demo-file/addresses/";

        files = new File[100];

    }

    public File createFileObject(String filename) {

        File tempFile = new File(path + filename);
        boolean isCreated = false;
        try {
            isCreated = tempFile.createNewFile();

            if (isCreated) {
                System.out.println(tempFile.getName() + " File Created");

            } else {
                System.out.println("File Already Created");

            }
        } catch (IOException e) {
            System.out.println("Exception Thrown While Creating FIle");

        }
        return tempFile;
    }

    public void addAddress(Address address) {

        fileObjectPointer++;

        String filename = "Address" + fileObjectPointer + ".ser";
        files[fileObjectPointer] = createFileObject(filename);
        if (files[fileObjectPointer].exists()) {
            try {


                FileOutputStream fileOutputStream = new FileOutputStream(files[fileObjectPointer]);

                try {

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    objectOutputStream.writeObject(address);
                    System.out.println(" " + address.getDno() + " Added");

                    objectOutputStream.close();
                } catch (IOException e) {
                    System.out.println("IO Exception");
                }

            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception");
            }
        } else {
            System.out.println("File Doesnt Exists");
        }

    }

    public void deleteAddress(int doorNo) {

        int foundAtIndex = -1;

        int count = 0;
        Address address;

        if (fileObjectPointer > -1) {


            do {
                try {
                    FileInputStream fileInputStream = new FileInputStream(files[count]);
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


                        try {
                            address = (Address) objectInputStream.readObject();

                            if (address.getDno() == doorNo) {

                                foundAtIndex = count;
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
            } while (count <= fileObjectPointer);

            if (foundAtIndex == -1) {
                System.out.println("Object Not Found");
            } else {
                int fileSize = fileObjectPointer;
                fileSize++;
                files2 = new File[fileSize];
                int arrayIndex = 0;
                for (int i = 0; i <= fileSize; i++) {

                    if (i == foundAtIndex) {
                        continue;
                    }
                    files2[arrayIndex] = files[i];
                    arrayIndex++;
                }
                files = files2;
                fileObjectPointer--;
                System.out.println("Removed");
            }
        } else {
            System.out.println("NO Address list");
        }

    }


    public Address getAddress(int doorNO) {
        if (fileObjectPointer != -1) {
            int count = 0;

            Address address = new Address();
            do {


                try {
                    FileInputStream fileInputStream = new FileInputStream(files[count]);
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


                        try {
                            address = (Address) objectInputStream.readObject();

                            if (address.getDno() == doorNO) {


                            }

                        } catch (ClassNotFoundException e) {
                            objectInputStream.close();
                            System.out.println("Class Not Found Exception");

                        }


                    } catch (IOException e) {
                        System.out.println("IO Exception");

                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File Not Found Exception");


                }
                return address;
            } while (count <= fileObjectPointer);
        } else {
            System.out.println("Empty Addresses");
            return null;
        }
    }

    public Address[] getAddresses() {
        Address[] addresses = null;
        if (fileObjectPointer != -1) {

            int count = 0;
            int i = 0;
            addresses = new Address[fileObjectPointer];
            do {


                try {
                    FileInputStream fileInputStream = new FileInputStream(files[count]);

                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


                        try {

                            addresses[i] = (Address) objectInputStream.readObject();


                        } catch (ClassNotFoundException e) {
                            System.out.println("Class Not Found Exception,No More Student");
                        }


                    } catch (IOException e) {
                        System.out.println("IO Exception");

                    }


                } catch (FileNotFoundException e) {
                    System.out.println("File Not Found Exception");
                    return null;
                }
                count++;
                i++;
            } while (count <= fileObjectPointer);
            return addresses;

        } else {
            System.out.println("NO Addresses");
        }
        return addresses;
    }
}



