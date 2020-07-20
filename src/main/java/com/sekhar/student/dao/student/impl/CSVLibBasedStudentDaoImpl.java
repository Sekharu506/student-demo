package com.sekhar.student.dao.student.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.sekhar.student.dao.student.FileBasedStudentDao;

import com.sekhar.student.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVLibBasedStudentDaoImpl implements FileBasedStudentDao {


    private File file;
    private String path;
    private File file2;
    private static CSVLibBasedStudentDaoImpl studentDao = null;

    private CSVLibBasedStudentDaoImpl() {

        this.path = "/home/cultuzz/student-demo-files/";
        file = new File(path);
        file = createFileObject("Students.csv");
        file2 = new File(path);
    }

    public static CSVLibBasedStudentDaoImpl getStudentDaoInstance() {
        if (studentDao == null)
            studentDao = new CSVLibBasedStudentDaoImpl();
        return studentDao;
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

    public void addStudent(Student student) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] studentArray = new String[5];
            studentArray[0] = String.valueOf(student.getId());
            studentArray[1] = student.getName();
            studentArray[2] = String.valueOf(student.getPhone());
            studentArray[3] = String.valueOf(student.getDepartmentId());
            studentArray[4] = String.valueOf(student.getDno());

            csvWriter.writeNext(studentArray);
            csvWriter.close();
            System.out.println(student.getName() + " Added");

        } catch (IOException e) {
            System.out.println("IO Exception");
        }


    }

    public void deleteStudent(int id) {
        if (file.exists()) {
            int found = 0;
            file2 = createFileObject("temp.csv");
            try {
                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);
                String[] studentArray;
                try {
                    studentArray = csvReader.readNext();
                    while (studentArray != null) {
                        if (Integer.parseInt(studentArray[0]) == id) {
                            studentArray = csvReader.readNext();
                            found = 1;
                            continue;
                        } else {
                            FileWriter fileWriter = new FileWriter(file2, true);
                            CSVWriter csvWriter = new CSVWriter(fileWriter);
                            csvWriter.writeNext(studentArray);
                            csvWriter.close();
                            studentArray = csvReader.readNext();
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

    public Student getStudent(int id) {
        if (file.exists()) {
            int found = 0;
            Student student = new Student();
            try {
                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);

                String[] studentArray;
                try {
                    studentArray = csvReader.readNext();
                    while (studentArray != null) {
                        if (Integer.parseInt(studentArray[0]) == id) {
                            found = 1;
                            break;

                        }
                        studentArray = csvReader.readNext();
                    }
                    if (found == 1) {
                        student.setId(Integer.parseInt(studentArray[0]));
                        student.setName(studentArray[1]);
                        student.setPhone(Long.parseLong(studentArray[2]));
                        student.setDepartmentId(Integer.parseInt(studentArray[3]));
                        student.setDno(Integer.parseInt(studentArray[4]));
                        return student;
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

    public Student[] getStudents() {
        if (file.exists()) {

            int rows = countRows();
            Student students[] = new Student[rows];
            try {

                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReader(fileReader);


                String[] studentArray;

                try {
                    studentArray = csvReader.readNext();
                    int i = 0;
                    while (studentArray != null) {

                        students[i] = new Student();
                        students[i].setId(Integer.parseInt(studentArray[0]));
                        students[i].setName(studentArray[1]);
                        students[i].setPhone(Long.parseLong(studentArray[2]));
                        students[i].setDepartmentId(Integer.parseInt(studentArray[3]));
                        students[i].setDno(Integer.parseInt(studentArray[4]));
                        studentArray = csvReader.readNext();
                        i++;
                    }
                    return students;
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
