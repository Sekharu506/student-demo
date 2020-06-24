package com.sekhar.student.manager.inmemory.impl;

import com.sekhar.student.dao.inmemory.impl.InMemoryBasedAddressDaoImpl;
import com.sekhar.student.manager.inmemory.*;
import com.sekhar.student.model.*;
import java.util.Set;

public class InMemoryBasedAddressManagerImpl implements InMemoryBasedAddressManager {

	final InMemoryBasedAddressDaoImpl addressdao = new InMemoryBasedAddressDaoImpl();

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

	public Set<Address> getAddresses()

	{
		Set<Address> addresses = addressdao.getAddresses();
		return addresses;
	}
}
