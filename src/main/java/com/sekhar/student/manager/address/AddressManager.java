package com.sekhar.student.manager.address;

import com.sekhar.student.model.Address;

public interface AddressManager {
	public void setAddress(Address address);

	public void makeFile(String path, String filename);

	public void removeAddress(int doorNo);
	public void updateAddress(Address address);

	public Address getAddress(int doorNo);

	public Address[] getAddresses();
}
