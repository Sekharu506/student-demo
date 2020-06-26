package com.sekhar.student.manager.address;

import com.sekhar.student.manager.address.impl.*;

public class AddressManagerFactory {

	private static String persistence;

	public static AddressManager getAddresssManagerInstance(String persistence) {
		AddressManagerFactory.persistence = persistence;
		AddressManager addressmanager = null;

		if (persistence == "IN_MEMORY") {

			addressmanager = new InMemoryBasedAddressManagerImpl();

		} else if (persistence == "DB") {

			addressmanager = new DBBasedAddressManagerImpl();

		} else if (persistence == "FILE") {

			addressmanager = new FileBasedAddressManagerImpl();

		}

		return addressmanager;

	}

}
