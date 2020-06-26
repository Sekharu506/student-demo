package com.sekhar.student.manager.address;

import com.sekhar.student.model.Address;

public interface AddressManager {
	public void setAddress(Address address);

	public void removeAddress(int doorNo);

	public Address getAddress(int doorNo);

	public Address[] getAddresses();
}
