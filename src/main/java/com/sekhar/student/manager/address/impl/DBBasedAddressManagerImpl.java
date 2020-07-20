package com.sekhar.student.manager.address.impl;

import com.sekhar.student.manager.address.AddressManager;
import com.sekhar.student.dao.address.DBBasedAddressDao;
import com.sekhar.student.dao.address.impl.DBBasedAddressDaoImpl;
import com.sekhar.student.model.*;

public class DBBasedAddressManagerImpl implements AddressManager {

	private DBBasedAddressDao addressDao;

	public DBBasedAddressManagerImpl() {
		addressDao = DBBasedAddressDaoImpl.getAddressDaoInstance();

	}

	public void addAddress(Address address) {

		addressDao.insertAddress(address);

	}

	public void removeAddress(int doorNo) {
		addressDao.deleteAddress(doorNo);

	}

	public Address getAddress(int doorNo) {

		Address address = addressDao.getAddress(doorNo);

		return address;

	}

	public Address[] getAddresses()

	{
		Address[] addresses = addressDao.getAddresses();

		return addresses;
	}

	public void updateAddress(Address address) {
		addressDao.updateAddress(address);

	}
}
