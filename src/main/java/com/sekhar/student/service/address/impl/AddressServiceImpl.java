package com.sekhar.student.service.address.impl;

import com.sekhar.student.service.address.AddressService;
import com.sekhar.student.manager.address.AddressManager;
import com.sekhar.student.manager.address.AddressManagerFactory;
import com.sekhar.student.model.Address;

public class AddressServiceImpl implements AddressService {
	private AddressManager addressManager;

	public AddressServiceImpl(String persistence) {
		addressManager = AddressManagerFactory.getAddresssManagerInstance(persistence);

	}

	public void addAddress(Address address) {

		addressManager.addAddress(address);

	}

	public void removeAddress(int doorNo) {
		addressManager.removeAddress(doorNo);

	}

	public void getAddress(int doorNo) {
		Address address;
		address = addressManager.getAddress(doorNo);
		if (address != null) {
			System.out.println(" DoorNo    Street    City   PinCode");
			System.out.println(" " + address.toString());

		}
	}

	public void getAddresses() {

		Address[] addresses;
		addresses = addressManager.getAddresses();
		if (addresses != null)

		{
			System.out.println(" DoorNo    Street    City   PinCode");
			for (int i = 0; i < addresses.length; i++) {
				System.out.println("  " + addresses[i].toString());
			}

		}

	}

	public void updateAddress(Address address) {
		addressManager.updateAddress(address);

	}

}
