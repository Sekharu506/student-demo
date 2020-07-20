package com.sekhar.student.dao.student;

import com.sekhar.student.dao.student.FileBasedStudentDao;
import com.sekhar.student.dao.student.impl.CSVLibBasedStudentDaoImpl;
import com.sekhar.student.dao.student.impl.FileCsvBasedStudentDaoImpl;

public class FileBasedStudentDaoFactory {

    public static FileBasedStudentDao getInstanceOfAddressDao(String csvChoice) {
        FileBasedStudentDao studentDao = null;

        if (csvChoice.equalsIgnoreCase("csvLib")) {
            studentDao = CSVLibBasedStudentDaoImpl.getStudentDaoInstance();
        } else if (csvChoice.equalsIgnoreCase("csvNonLib")) {
            studentDao = FileCsvBasedStudentDaoImpl.getStudentDaoInstance();
        }

        return studentDao;
    }
}
