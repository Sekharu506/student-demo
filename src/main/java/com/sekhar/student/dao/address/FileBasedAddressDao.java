package com.sekhar.student.dao.address;

import com.sekhar.student.model.Address;

import java.io.File;

import com.sekhar.student.model.Student;

public interface FileBasedAddressDao {

	public void addAddress(Address address);

	public void deleteAddress(int doorNo);

	public Address getAddress(int doorNo);

	public Address[] getAddresses();

}
