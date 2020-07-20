package com.sekhar.student.manager.address.impl;

import com.sekhar.student.dao.address.InMemoryBasedAddressDao;
import com.sekhar.student.dao.address.impl.InMemoryBasedAddressDaoImpl;
import com.sekhar.student.manager.address.AddressManager;

import com.sekhar.student.model.*;
import java.util.Set;

public class InMemoryBasedAddressManagerImpl implements AddressManager {

	private InMemoryBasedAddressDao addressDao = null;

	public InMemoryBasedAddressManagerImpl() {
		addressDao = InMemoryBasedAddressDaoImpl.getAddressDaoInstance();
		// if some thing true then addressdao = new
	}

	public void addAddress(Address address) {

		addressDao.addAddress(address);
		System.out.println("Address Added");

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
		Set<Address> addresses = addressDao.getAddresses();
		int size = addresses.size();
		Address[] addressarray = new Address[size];
		addresses.toArray(addressarray);
		return addressarray;
	}

	public void updateAddress(Address address) {
		// TODO Auto-generated method stub

	}
}
