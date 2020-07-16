package com.sekhar.student.dao.address;

import com.sekhar.student.model.Address;

public interface FileBasedAddressDao {

    public void addAddress(Address address);

    public void deleteAddress(int doorNo);

    public Address getAddress(int doorNo);

    public Address[] getAddresses();

}
