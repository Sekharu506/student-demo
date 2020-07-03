package com.sekhar.student.service.address;

import com.sekhar.student.model.Address;

public interface AddressService {
	public void makeFile(String path, String filename);

	public void updateAddress(Address address);

	public void setAddress(Address address);

	public void removeAddress(int doorNo);

	public void getAddress(int doorNo);

	public void getAddresses();

}
