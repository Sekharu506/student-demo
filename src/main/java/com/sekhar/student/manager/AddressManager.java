/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.manager;

import com.test.student.model.Address;
import java.util.Set;

public interface AddressManager {

	public void addAddress(Address address);

	public void deleteAddress(int doorNo);

	public Address getAddress(int doorNo);

	public Set<Address> getAddresses();
}
