package com.sekhar.student.manager.address;

import com.sekhar.student.manager.address.impl.*;

public class AddressManagerFactory {

	public static AddressManager getAddresssManagerInstance(String persistence) {

		AddressManager addressManager = null;

		if (persistence.equalsIgnoreCase("IN_MEMORY")) {

			addressManager = new InMemoryBasedAddressManagerImpl();

		} else if (persistence.equalsIgnoreCase("DB")) {

			addressManager = new DBBasedAddressManagerImpl();

		} else if (persistence.equalsIgnoreCase("FILE")) {
			addressManager = new FileBasedAddressManagerImpl();
		}

		return addressManager;

	}

}
