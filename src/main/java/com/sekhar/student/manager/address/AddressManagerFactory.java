package com.sekhar.student.manager.address;

import com.sekhar.student.dao.address.FileBasedAddressDaoFactory;
import com.sekhar.student.manager.address.impl.*;

public class AddressManagerFactory {

	public static AddressManager getAddressManagerInstance(String persistence) {

		AddressManager addressManager = null;

		if (persistence.equalsIgnoreCase("IN_MEMORY")) {

			addressManager = new InMemoryBasedAddressManagerImpl();

		} else if (persistence.equalsIgnoreCase("DB")) {

			addressManager = new DBBasedAddressManagerImpl();

		}

		return addressManager;

	}

	public static AddressManager getAddressManagerInstance(String peristence, String csvChoice) {
		AddressManager addressManager;
		addressManager = new FileBasedAddressManagerImpl(csvChoice);

		return addressManager;
	}
}
