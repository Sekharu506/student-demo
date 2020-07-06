package com.sekhar.student.service.address.impl;

import com.sekhar.student.service.address.AddressService;
import com.sekhar.student.manager.address.AddressManager;
import com.sekhar.student.manager.address.AddressManagerFactory;
import com.sekhar.student.model.Address;

public class AddressServiceImpl implements AddressService {
	AddressManager addressmanager;

	public AddressServiceImpl(String persistence) {
		addressmanager = AddressManagerFactory.getAddresssManagerInstance(persistence);

	}

	public AddressServiceImpl(String persistence, String path, String filename) {
		addressmanager = AddressManagerFactory.getAddressManagerInstance(persistence, path, filename);

	}

	public void addAddress(Address address) {

		addressmanager.addAddress(address);

	}

	public void removeAddress(int doorNo) {
		addressmanager.removeAddress(doorNo);

	}

	public void getAddress(int doorNo) {
		Address address;
		address = addressmanager.getAddress(doorNo);
		if (address == null) {
			System.out.println(" DoorNo    Street    City   PinCode");
			System.out.println("No Address Found");

		} else {
			System.out.println(" " + address.toString());

		}
	}

	public void getAddresses() {

		Address[] addresses;
		addresses = addressmanager.getAddresses();
		if (addresses != null)

		{
			System.out.println(" DoorNo    Street    City   PinCode");
			for (int i = 0; i < addresses.length; i++) {
				System.out.println("  " + addresses[i].toString());
			}

		} else {
			System.out.println("No Address Data Found");
		}

	}

	public void updateAddress(Address address) {
		addressmanager.updateAddress(address);

	}

}
