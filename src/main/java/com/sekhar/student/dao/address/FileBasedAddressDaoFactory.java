package com.sekhar.student.dao.address;

import com.sekhar.student.dao.address.impl.CSVLibBasedAddressDaoImpl;
import com.sekhar.student.dao.address.impl.FileCsvBasedAddressDaoImpl;


public class FileBasedAddressDaoFactory {

    public static FileBasedAddressDao getInstanceOfAddressDao(String csvChoice) {
        FileBasedAddressDao addressDao = null;

        if (csvChoice.equalsIgnoreCase("csvLib")) {
            addressDao = CSVLibBasedAddressDaoImpl.getAddressDaoInstance();
        } else if (csvChoice.equalsIgnoreCase("csvNonLib")) {
            addressDao = FileCsvBasedAddressDaoImpl.getAddressDaoInstance();
        }

        return addressDao;
    }


}
