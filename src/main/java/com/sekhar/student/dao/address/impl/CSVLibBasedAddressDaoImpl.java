package com.sekhar.student.dao.address.impl;

import com.sekhar.student.dao.address.CSVLibBasedAddressDao;
import com.sekhar.student.model.Address;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVLibBasedAddressDaoImpl implements CSVLibBasedAddressDao {

    private File file;
    private String path;
    private File file2;

    public CSVLibBasedAddressDaoImpl() {

        this.path = "/home/cultuzz/student-demo-files/";
        file = new File(path);
        file = createFileObject("Addresses.csv");
        file2 = new File(path);
    }

    public File createFileObject(String filename) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filename.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    }

    public void deleteAddress(int doorNo) {

    }

    public Address getAddress(int doorNo) {
        return null;
    }

    public Address[] getAddresses() {
        return new Address[0];
    }
}
