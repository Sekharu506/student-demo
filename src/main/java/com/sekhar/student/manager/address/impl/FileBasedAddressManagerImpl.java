package com.sekhar.student.manager.address.impl;

import com.sekhar.student.manager.address.AddressManager;
import com.sekhar.student.model.Address;
import com.sekhar.student.dao.address.FileBasedAddressDao;
import com.sekhar.student.dao.address.impl.FileBasedAddressDaoImpl;

public class FileBasedAddressManagerImpl implements AddressManager {
	FileBasedAddressDao addressdao;

	public FileBasedAddressManagerImpl(String path, String filename)

	{
		addressdao = new FileBasedAddressDaoImpl(path, filename);

	}

	public void addAddress(Address address) {

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

	public void updateAddress(Address address) {
		// TODO Auto-generated method stub

	}

}
