package com.sekhar.student.dao.department.impl;

import com.sekhar.student.dao.department.FileCsvBasedDepartmentDao;
import com.sekhar.student.model.Department;

import java.io.*;

public class FileCsvBasedDepartmentDaoImpl implements FileCsvBasedDepartmentDao {
    private File file;
    private String path;
    private File file2;

    public FileCsvBasedDepartmentDaoImpl() {

        this.path = "/home/cultuzz/student-demo-files/";
        file = new File(path);
        file = createFileObject("Departments.csv");
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

    public void addDepartment(Department department) {
        try {


            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            String departmentId = String.valueOf(department.getDepartmentId());
            bufferWriter.write(departmentId);
            bufferWriter.write(",");
            bufferWriter.write(department.getDepartmentName());
            bufferWriter.write(",");
            String courses[] = department.getCourses();

            bufferWriter.write(courses[0]);
            bufferWriter.write(",");
            bufferWriter.write(courses[1]);
            bufferWriter.write(",");

            bufferWriter.write(courses[2]);
            bufferWriter.write("\n");
            bufferWriter.close();
            System.out.println(department.getDepartmentName() + " Added");

        } catch (IOException e) {
            System.out.println(" IO  Exception");
        }

    }

    public void deleteDepartment(int departmentId) {
        if (file.exists()) {

            file2 = createFileObject("temp.csv");
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                try {

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {

                        String departmentArray[] = line.split(",");
                        int string_to_id = Integer.parseInt(departmentArray[0]);
                        if (string_to_id == departmentId) {
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

    public Department getDepartment(int departmentId) {
        if (file.exists()) {
            Department department = new Department();
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                try {
                    line = bufferedReader.readLine();
                    String[] departmentArray;
                    int string_to_id = 0;
                    while ((line) != null) {
                        departmentArray = line.split(",");
                        string_to_id = Integer.parseInt(departmentArray[0]);
                        if (string_to_id == departmentId) {
                            break;
                        }

                        line = bufferedReader.readLine();
                    }
                    if (string_to_id == departmentId) {
                        departmentArray = line.split(",");
                        department.setDepartmentId(departmentId);
                        department.setDepartmentName(departmentArray[1]);
                        String courses[] = new String[3];
                        courses[0] = departmentArray[2];
                        courses[1] = departmentArray[3];
                        courses[2] = departmentArray[4];
                        department.setCourses(courses);


                        return department;

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

    public Department[] getDepartments() {
        if (file.exists()) {
            try {

                Department[] departments;
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                try {
                    bufferedReader.mark(100);
                    line = bufferedReader.readLine();
                    int size = 0;
                    while ((line) != null) {
                        size++;

                        line = bufferedReader.readLine();
                    }
                    bufferedReader.reset();

                    departments = new Department[size];
                    line = bufferedReader.readLine();
                    String[] departmentArray;
                    int i = 0;
                    while ((line) != null) {
                        departments[i] = new Department();
                        departmentArray = line.split(",");
                        departments[i].setDepartmentId(Integer.parseInt(departmentArray[0]));
                        departments[i].setDepartmentName(departmentArray[1]);
                        String courses[] = new String[3];
                        courses[0] = departmentArray[2];
                        courses[1] = departmentArray[3];
                        courses[2] = departmentArray[4];
                        departments[i].setCourses(courses);
                        i++;

                        line = bufferedReader.readLine();
                    }

                    return departments;

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

