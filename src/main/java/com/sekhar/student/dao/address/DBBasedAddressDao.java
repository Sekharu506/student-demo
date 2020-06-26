package com.sekhar.student.dao.db;

import com.sekhar.student.model.*;

public interface DBAddressDao {

	public void insertAddress(Address address);

	public void deleteAddress(int doorNO);

	public void updateAddress(int doorNo);

	public void getAddress(int doorNo);

}
