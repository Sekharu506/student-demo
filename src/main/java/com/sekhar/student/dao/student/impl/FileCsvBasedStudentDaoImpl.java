package com.sekhar.student.dao.student.impl;

import com.sekhar.student.dao.student.FileCsvBasedStudentDao;
import com.sekhar.student.model.Student;

import java.io.*;


public class FileCsvBasedStudentDaoImpl implements FileCsvBasedStudentDao {
    File file;
    private String path;
    File file2;

    public FileCsvBasedStudentDaoImpl() {

        this.path = "/home/cultuzz/student-demo-files/";
        file = new File(path);
        file = createFileObject("Students.csv");
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

    public void addStudent(Student student) {
        try {


            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            String id = String.valueOf(student.getId());
            bufferWriter.write(id);
            bufferWriter.write(",");
            bufferWriter.write(student.getName());
            bufferWriter.write(",");
            String phone = String.valueOf(student.getPhone());
            bufferWriter.write(phone);
            bufferWriter.write(",");
            String departmentId = String.valueOf(student.getDepartmentId());
            bufferWriter.write(departmentId);
            bufferWriter.write(",");
            String doorNo = String.valueOf(student.getDno());
            bufferWriter.write(doorNo);
            bufferWriter.write("\n");
            bufferWriter.close();
            System.out.println(student.getName() + " Added");

        } catch (IOException e) {
            System.out.println(" IO  Exception");
        }

    }

    public void deleteStudent(int id) {
        if (file.exists()) {

            file2 = createFileObject("temp.csv");
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                try {

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {

                        String studentString[] = line.split(",");
                        int string_to_id = Integer.parseInt(studentString[0]);
                        if (string_to_id == id) {
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

    public Student getStudent(int id) {
        if (file.exists()) {
            Student student = new Student();
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                try {
                    line = bufferedReader.readLine();
                    String[] studentString;
                    int string_to_id = 0;
                    while ((line) != null) {
                        studentString = line.split(",");
                        string_to_id = Integer.parseInt(studentString[0]);
                        if (string_to_id == id) {
                            break;
                        }

                        line = bufferedReader.readLine();
                    }
                    if (string_to_id == id) {
                        studentString = line.split(",");
                        student.setId(id);
                        student.setName(studentString[1]);
                        student.setPhone(Long.parseLong(studentString[2]));
                        student.setDepartmentId(Integer.parseInt(studentString[3]));
                        student.setDno(Integer.parseInt(studentString[4]));
                        return student;

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

    public Student[] getStudents() {
        if (file.exists()) {
            try {

                Student[] students;
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

                    students = new Student[size];
                    line = bufferedReader.readLine();
                    String[] studentArray;
                    int i = 0;
                    while ((line) != null) {
                        students[i] = new Student();
                        studentArray = line.split(",");
                        students[i].setId(Integer.parseInt(studentArray[0]));
                        students[i].setName(studentArray[1]);
                        students[i].setPhone(Long.parseLong(studentArray[2]));
                        students[i].setDepartmentId(Integer.parseInt(studentArray[3]));
                        students[i].setDno(Integer.parseInt(studentArray[4]));
                        i++;

                        line = bufferedReader.readLine();
                    }

                    return students;

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