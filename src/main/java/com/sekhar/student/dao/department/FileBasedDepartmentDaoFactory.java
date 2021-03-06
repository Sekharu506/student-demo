package com.sekhar.student.dao.department;

import com.sekhar.student.dao.department.FileBasedDepartmentDao;
import com.sekhar.student.dao.department.impl.CSVLibBasedDepartmentDaoImpl;
import com.sekhar.student.dao.department.impl.FileCsvBasedDepartmentDaoImpl;


public class FileBasedDepartmentDaoFactory {
    public static FileBasedDepartmentDao getInstanceOfDepartmentDao(String csvChoice) {
        FileBasedDepartmentDao departmentDao = null;

        if (csvChoice.equalsIgnoreCase("csvLib")) {
            departmentDao = CSVLibBasedDepartmentDaoImpl.getDepartmentDaoInstance();
        } else if (csvChoice.equalsIgnoreCase("csvNonLib")) {
            departmentDao = FileCsvBasedDepartmentDaoImpl.getDapartmentDaoInstance();
        }

        return departmentDao;
    }

}
