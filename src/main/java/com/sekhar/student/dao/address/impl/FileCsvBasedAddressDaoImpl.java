package com.sekhar.student.dao.address.impl;

import com.sekhar.student.dao.address.FileBasedAddressDao;
import com.sekhar.student.model.Address;

import java.io.*;

public class FileCsvBasedAddressDaoImpl implements FileBasedAddressDao {

    private File file;
    private String path;
    private File file2;

    public FileCsvBasedAddressDaoImpl() {

        this.path = "/home/cultuzz/student-demo-files/";
        file = new File(path);
        file = createFileObject("Addresses.csv");
        file2 = new File(path);
    }

    public File createFileObject(String filename) {


        boolean isCreated = false;
        File tempFile = new File(path + filename);
        try {
            isCreated = tempFile.createNewFile();


        } catch (IOException e) {
            System.out.println("Exception Thrown While Creating FIle");

        }
        return tempFile;
    }

    public void addAddress(Address address) {

        try {


            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            String doorNo = String.valueOf(address.getDno());
            bufferWriter.write(doorNo);
            bufferWriter.write(",");
            bufferWriter.write(address.getStreet());
            bufferWriter.write(",");

            bufferWriter.write(address.getCity());
            bufferWriter.write(",");

            String pin = String.valueOf(address.getPin());
            bufferWriter.write(pin);
            bufferWriter.write("\n");
            bufferWriter.close();
            System.out.println(address.getStreet() + " Added");

        } catch (IOException e) {
            System.out.println(" IO  Exception");
        }

    }

    public void deleteAddress(int doorNo) {
        if (file.exists()) {

            file2 = createFileObject("temp.csv");
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                try {

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {

                        String addressArray[] = line.split(",");
                        int string_to_id = Integer.parseInt(addressArray[0]);
                        if (string_to_id == doorNo) {
                            continue;
                        } else {
                            FileWriter fileWriter = new FileWriter(file2, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(line);
                            bufferedWriter.write("\n");
                            bufferedWriter.close();

                        }


                    }

                    System.out.println("Student Deleted");

                    file.delete();
                    file = createFileObject("Students.csv");
                    file2.renameTo(file);
                    file2.delete();


                } catch (IOException e) {
                    System.out.println("IO Excepiton");
                }


            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception");
            }
        } else {
            System.out.println("NO Students Records");
        }


    }

    public Address getAddress(int doorNo) {
        if (file.exists()) {
            Address address = new Address();
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                try {
                    line = bufferedReader.readLine();
                    String[] addressArray;
                    int string_to_id = 0;
                    while ((line) != null) {
                        addressArray = line.split(",");
                        string_to_id = Integer.parseInt(addressArray[0]);
                        if (string_to_id == doorNo) {
                            break;
                        }

                        line = bufferedReader.readLine();
                    }
                    if (string_to_id == doorNo) {
                        addressArray = line.split(",");
                        address.setDno(doorNo);
                        address.setStreet(addressArray[1]);
                        address.setCity(addressArray[2]);
                        address.setPin(Integer.parseInt(addressArray[3]));

                        return address;

                    } else {
                        System.out.println("Student Not Found");
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

        } else {
            System.out.println("No Student in List");
            return null;
        }
    }

    public Address[] getAddresses() {
        if (file.exists()) {
            try {

                Address[] addresses;
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                try {
                    bufferedReader.mark(200);
                    line = bufferedReader.readLine();
                    int size = 0;
                    while ((line) != null) {
                        size++;

                        line = bufferedReader.readLine();
                    }
                    bufferedReader.reset();

                    addresses = new Address[size];
                    line = bufferedReader.readLine();
                    String[] addressArray;
                    int i = 0;
                    while ((line) != null) {
                        addresses[i] = new Address();
                        addressArray = line.split(",");
                        addresses[i].setDno(Integer.parseInt(addressArray[0]));
                        addresses[i].setStreet(addressArray[1]);
                        addresses[i].setCity(addressArray[2]);
                        addresses[i].setPin(Integer.parseInt(addressArray[3]));

                        i++;

                        line = bufferedReader.readLine();
                    }

                    return addresses;

                } catch (IOException e) {

                    System.out.println("IO Exception");
                    return null;
                }

            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception");
                return null;
            }

        } else {
            System.out.println("NO Student Records Found In File");
            return null;
        }
    }
}
