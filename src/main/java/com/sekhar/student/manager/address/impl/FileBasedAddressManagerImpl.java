package com.sekhar.student.manager.address.impl;

import java.util.Set;

import com.sekhar.student.manager.address.AddressManager;
import com.sekhar.student.model.Address;
import com.sekhar.student.dao.address.FileBasedAddressDao;
import com.sekhar.student.dao.address.impl.FileBasedAddressDaoImpl;

public class FileBasedAddressManagerImpl implements AddressManager {
	FileBasedAddressDao addressdao;

	public FileBasedAddressManagerImpl()

	{
		addressdao = new FileBasedAddressDaoImpl();

	}

	public void makeFile(String path, String filename) {
		addressdao.createFile(path, filename);
	}

	public void setAddress(Address address) {

		addressdao.addAddress(address);

	}

	public void removeAddress(int doorNo) {

		addressdao.deleteAddress(doorNo);

	}

	public Address getAddress(int doorNo) {

		Address address;
		address = addressdao.getAddress(doorNo);
		return address;
	}

	public Address[] getAddresses() {

		Address[] addresses = new Address[100];
		addresses = addressdao.getAddresses();

		return addresses;
	}

}
