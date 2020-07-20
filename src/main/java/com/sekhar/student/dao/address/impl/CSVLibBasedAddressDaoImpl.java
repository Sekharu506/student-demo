package com.sekhar.student.dao.address.impl;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.sekhar.student.dao.address.FileBasedAddressDao;
import com.sekhar.student.model.Address;

import java.io.*;
import java.util.*;

import com.opencsv.CSVReader;

public class CSVLibBasedAddressDaoImpl implements FileBasedAddressDao {

    private File file;
    private String path;
    private File file2;
    private static CSVLibBasedAddressDaoImpl addressDao = null;


    private CSVLibBasedAddressDaoImpl() {
        this.path = "/home/cultuzz/student-demo-files/";
        file = new File(path);
        file = createFileObject("Addresses.csv");
        file2 = new File(path);


    }

    public static CSVLibBasedAddressDaoImpl getAddressDaoInstance() {
        if (addressDao == null)
        
            addressDao = new CSVLibBasedAddressDaoImpl();
        return addressDao;


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
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] addressArray = new String[4];
            addressArray[0] = String.valueOf(address.getDno());
            addressArray[1] = address.getStreet();
            addressArray[2] = address.getCity();
            addressArray[3] = String.valueOf(address.getPin());

            csvWriter.writeNext(addressArray);
            csvWriter.close();
            System.out.println(address.getStreet() + " Added");

        } catch (IOException e) {
            System.out.println("IO Exception");
        }


    }

    public void deleteAddress(int doorNo) {

        if (file.exists()) {
            int found = 0;
            file2 = createFileObject("temp.csv");
            try {
                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);
                String[] addressArray;
                try {
                    addressArray = csvReader.readNext();
                    while (addressArray != null) {
                        if (Integer.parseInt(addressArray[0]) == doorNo) {
                            addressArray = csvReader.readNext();
                            found = 1;
                            continue;
                        } else {
                            FileWriter fileWriter = new FileWriter(file2, true);
                            CSVWriter csvWriter = new CSVWriter(fileWriter);
                            csvWriter.writeNext(addressArray);
                            csvWriter.close();
                            addressArray = csvReader.readNext();
                        }
                    }
                    if (found == 1) {
                        file.delete();
                        file = createFileObject("Addresses.csv");
                        file2.renameTo(file);
                        file2.delete();
                        System.out.println("Address Deleted");

                    } else {
                        file2.delete();
                    }

                } catch (IOException | CsvValidationException e) {
                    System.out.println("Csv Validation Exception");
                }


            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception");
            }


        } else {
            System.out.println("Address File Does'nt Exists");
        }

    }


    public Address getAddress(int doorNo) {
        if (file.exists()) {
            int found = 0;
            Address address = new Address();
            try {
                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);

                String[] addressArray;
                try {
                    addressArray = csvReader.readNext();
                    while (addressArray != null) {
                        if (Integer.parseInt(addressArray[0]) == doorNo) {
                            found = 1;
                            break;

                        }
                        addressArray = csvReader.readNext();
                    }
                    if (found == 1) {
                        address.setDno(doorNo);
                        address.setStreet(addressArray[1]);
                        address.setCity(addressArray[2]);
                        address.setPin(Integer.parseInt(addressArray[3]));
                        return address;
                    } else {

                        System.out.println("Address Not Found");
                        return null;
                    }

                } catch (IOException | CsvValidationException e) {
                    System.out.println("CSV Validation Exception");
                    return null;
                }


            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception");
                return null;
            }

        } else {
            System.out.println("Addresses Not Found");
            return null;
        }
    }

    public Address[] getAddresses() {
        if (file.exists()) {

            int rows = countRows();
            Address[] addresses = new Address[rows];
            try {

                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);


                String[] addressArray;

                try {
                    addressArray = csvReader.readNext();
                    int i = 0;
                    while (addressArray != null) {
                        addresses[i] = new Address();

                        addresses[i].setDno(Integer.parseInt(addressArray[0]));
                        addresses[i].setStreet(addressArray[1]);
                        addresses[i].setCity(addressArray[2]);
                        addresses[i].setPin(Integer.parseInt(addressArray[3]));

                        addressArray = csvReader.readNext();
                        i++;
                    }
                    return addresses;
                } catch (IOException | CsvValidationException e) {
                    System.out.println("CSV Validation Exception");
                    return null;
                }
            } catch (FileNotFoundException e) {
                System.out.println("File Not Exception");
                return null;
            }


        } else {
            System.out.println("No Addresses List");
            return null;
        }
    }

    public int countRows() {
        int count = 0;
        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> list = new ArrayList<String[]>();

            list = csvReader.readAll();
            count = list.size();


        } catch (Exception e) {
            System.out.println("Exception Occur");
        }
        return count;
    }
}
