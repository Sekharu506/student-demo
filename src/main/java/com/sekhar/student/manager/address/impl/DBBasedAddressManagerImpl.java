package com.sekhar.student.manager.address.impl;

import com.sekhar.student.manager.address.AddressManager;
import com.sekhar.student.dao.address.DBBasedAddressDao;
import com.sekhar.student.dao.address.impl.DBBasedAddressDaoImpl;
import com.sekhar.student.model.*;

public class DBBasedAddressManagerImpl implements AddressManager {

	private DBBasedAddressDao addressdao;

	public DBBasedAddressManagerImpl() {
		addressdao = new DBBasedAddressDaoImpl();

	}

	public void setAddress(Address address) {

		addressdao.insertAddress(address);
		System.out.println("Address Added");

	}

	public void removeAddress(int doorNo) {
		addressdao.deleteAddress(doorNo);

	}

	public Address getAddress(int doorNo) {

		Address address = addressdao.getAddress(doorNo);

		return address;

	}

	public Address[] getAddresses()

	{
		Address[] addresses = addressdao.getAddresses();

		return addresses;
	}

	public void makeFile(String path, String filename) {
		// TODO Auto-generated method stub

	}

	public void updateAddress(Address address) {
		addressdao.updateAddress(address);

	}
}
