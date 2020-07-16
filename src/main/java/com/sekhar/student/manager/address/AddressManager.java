package com.sekhar.student.manager.address;

import com.sekhar.student.model.Address;

public interface AddressManager {
	public void addAddress(Address address);

	public void removeAddress(int doorNo);

	public void updateAddress(Address address);

	public Address getAddress(int doorNo);

	public Address[] getAddresses();
}
