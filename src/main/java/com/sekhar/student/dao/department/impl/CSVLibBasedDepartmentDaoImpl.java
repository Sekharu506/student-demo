package com.sekhar.student.dao.department.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.sekhar.student.dao.department.FileBasedDepartmentDao;
import com.sekhar.student.model.Address;
import com.sekhar.student.model.Department;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVLibBasedDepartmentDaoImpl implements FileBasedDepartmentDao {


    private File file;
    private String path;
    private File file2;
    private static CSVLibBasedDepartmentDaoImpl departmentDao = null;

    private CSVLibBasedDepartmentDaoImpl() {

        this.path = "/home/cultuzz/student-demo-files/";
        file = new File(path);
        file = createFileObject("Departments.csv");
        file2 = new File(path);
    }

    public static CSVLibBasedDepartmentDaoImpl getDepartmentDaoInstance() {
        if (departmentDao == null)
            departmentDao = new CSVLibBasedDepartmentDaoImpl();
        return departmentDao;
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


    public void addDepartment(Department department) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] departmentArray = new String[5];
            departmentArray[0] = String.valueOf(department.getDepartmentId());
            departmentArray[1] = department.getDepartmentName();
            String[] courses = department.getCourses();
            departmentArray[2] = courses[0];
            departmentArray[3] = courses[1];
            departmentArray[4] = courses[2];


            csvWriter.writeNext(departmentArray);
            csvWriter.close();
            System.out.println(department.getDepartmentName() + " Added");

        } catch (IOException e) {
            System.out.println("IO Exception");
        }

    }

    public void deleteDepartment(int departmentId) {
        if (file.exists()) {
            int found = 0;
            file2 = createFileObject("temp.csv");
            try {
                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);
                String[] departmentArray;
                try {
                    departmentArray = csvReader.readNext();
                    while (departmentArray != null) {
                        if (Integer.parseInt(departmentArray[0]) == departmentId) {
                            departmentArray = csvReader.readNext();
                            found = 1;
                            continue;
                        } else {
                            FileWriter fileWriter = new FileWriter(file2, true);
                            CSVWriter csvWriter = new CSVWriter(fileWriter);
                            csvWriter.writeNext(departmentArray);
                            csvWriter.close();
                            departmentArray = csvReader.readNext();
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


    public Department getDepartment(int departmentId) {
        if (file.exists()) {
            int found = 0;
            Department department = new Department();
            try {
                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);

                String[] departmentArray;
                try {
                    departmentArray = csvReader.readNext();
                    while (departmentArray != null) {
                        if (Integer.parseInt(departmentArray[0]) == departmentId) {
                            found = 1;
                            break;

                        }
                        departmentArray = csvReader.readNext();
                    }
                    if (found == 1) {
                        department.setDepartmentId(Integer.parseInt(departmentArray[0]));
                        department.setDepartmentName(departmentArray[1]);
                        String courses[] = new String[3];
                        courses[0] = departmentArray[2];
                        courses[1] = departmentArray[3];
                        courses[2] = departmentArray[4];
                        department.setCourses(courses);
                        return department;
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


    public Department[] getDepartments() {
        if (file.exists()) {

            int rows = countRows();
            System.out.println(rows);
            Department[] departments = new Department[rows];
            try {

                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);


                String[] departmentArray;

                try {
                    departmentArray = csvReader.readNext();
                    int i = 0;
                    while (departmentArray != null) {
                        departments[i] = new Department();
                        departments[i].setDepartmentId(Integer.parseInt(departmentArray[0]));
                        departments[i].setDepartmentName(departmentArray[1]);
                        String courses[] = new String[3];
                        courses[0] = departmentArray[2];
                        courses[1] = departmentArray[3];
                        courses[2] = departmentArray[4];
                        departments[i].setCourses(courses);
                        departmentArray = csvReader.readNext();
                        i++;
                    }
                    return departments;
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
