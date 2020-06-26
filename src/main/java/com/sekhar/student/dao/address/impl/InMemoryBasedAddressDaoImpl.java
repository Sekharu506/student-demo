package com.sekhar.student.dao.address.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sekhar.student.dao.address.InMemoryBasedAddressDao;
import com.sekhar.student.model.Address;

public class InMemoryBasedAddressDaoImpl implements InMemoryBasedAddressDao {
	Set<Address> addresses = new HashSet<Address>();

	public void addAddress(Address address) {
		addresses.add(address);

	}

	public void deleteAddress(int doorNo) {
		if (!addresses.isEmpty()) {
			Address address;
			int found = 0;
			Iterator<Address> iterator = addresses.iterator();

			while (iterator.hasNext()) {

				address = iterator.next();

				if (address.getDno() == doorNo) {
					found = 1;

					addresses.remove(address);
					System.out.println(" " + address.getStreet() + " removed");
					break;

				}

			}

			if (found == 0) {
				System.out.println(" Address Not Found");
			}
		} else {
			System.out.println("No Address List");
		}

	}

	public Address getAddress(int doorNo) {
		if (!addresses.isEmpty()) {
			Address address;
			int found = 0;
			Iterator<Address> iterator = addresses.iterator();
			do {
				address = iterator.next();

				if (address.getDno() == doorNo) {
					found = 1;
					break;
				}

			} while (iterator.hasNext());

			if (found == 1) {
				return address;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

}
