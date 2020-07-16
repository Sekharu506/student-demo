package com.sekhar.student.manager.address.impl;

import com.sekhar.student.dao.address.FileBasedAddressDao;
import com.sekhar.student.dao.address.FileBasedAddressDaoFactory;
import com.sekhar.student.dao.address.impl.FileCsvBasedAddressDaoImpl;
import com.sekhar.student.manager.address.AddressManager;
import com.sekhar.student.model.Address;

public class FileBasedAddressManagerImpl implements AddressManager {
	private FileBasedAddressDao addressDao;

	public FileBasedAddressManagerImpl(String csvChoice) {
		addressDao = FileBasedAddressDaoFactory.getInstanceOfAddressDao(csvChoice);

	}

	public void addAddress(Address address) {

		addressDao.addAddress(address);

	}

	public void removeAddress(int doorNo) {

		addressDao.deleteAddress(doorNo);

	}

	public Address getAddress(int doorNo) {

		Address address;
		address = addressDao.getAddress(doorNo);
		return address;
	}

	public Address[] getAddresses() {

		Address[] addresses = new Address[100];
		addresses = addressDao.getAddresses();

		return addresses;
	}

	public void updateAddress(Address address) {
		// TODO Auto-generated method stub

	}

}
