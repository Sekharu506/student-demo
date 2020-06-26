package com.sekhar.student.manager.address.impl;

import com.sekhar.student.dao.address.InMemoryBasedAddressDao;
import com.sekhar.student.dao.address.impl.InMemoryBasedAddressDaoImpl;
import com.sekhar.student.manager.address.AddressManager;

import com.sekhar.student.model.*;
import java.util.Set;

public class InMemoryBasedAddressManagerImpl implements AddressManager {

	private InMemoryBasedAddressDao addressdao = null;

	public InMemoryBasedAddressManagerImpl() {
		addressdao = new InMemoryBasedAddressDaoImpl();
		// if some thing true then addressdao = new
	}

	public void setAddress(Address address) {

		addressdao.addAddress(address);
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
		Set<Address> addresses = addressdao.getAddresses();
		int size = addresses.size();
		Address[] addressarray = new Address[size];
		addresses.toArray(addressarray);
		return addressarray;
	}
}
