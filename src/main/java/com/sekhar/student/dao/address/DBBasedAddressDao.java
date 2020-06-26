package com.sekhar.student.dao.address;

import com.sekhar.student.model.*;

public interface DBBasedAddressDao {

	public void insertAddress(Address address);

	public void deleteAddress(int doorNO);

	public void updateAddress(Address address);

	public Address getAddress(int doorNo);

	public Address[] getAddresses();

}
