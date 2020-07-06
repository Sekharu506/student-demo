package com.sekhar.student.manager.address;

import com.sekhar.student.manager.address.impl.*;

public class AddressManagerFactory {

	public static AddressManager getAddresssManagerInstance(String persistence) {

		AddressManager addressmanager = null;

		if (persistence == "IN_MEMORY") {

			addressmanager = new InMemoryBasedAddressManagerImpl();

		} else if (persistence == "DB") {

			addressmanager = new DBBasedAddressManagerImpl();

		}

		return addressmanager;

	}

	public static AddressManager getAddressManagerInstance(String persistence, String path, String filename) {

		AddressManager addressmanager;

		addressmanager = new FileBasedAddressManagerImpl(path, filename);
		return addressmanager;

	}

}
