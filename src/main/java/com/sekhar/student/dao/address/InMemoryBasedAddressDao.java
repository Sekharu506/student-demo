package com.sekhar.student.dao.address;

import java.util.Set;

import com.sekhar.student.model.*;

public interface InMemoryBasedAddressDao {
	public void addAddress(Address address);

	public void deleteAddress(int doorNo);

	public Address getAddress(int doorNo);

	public Set<Address> getAddresses();

}
