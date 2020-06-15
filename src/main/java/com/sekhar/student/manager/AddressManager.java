/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.manager;

import java.util.*;
import java.util.ArrayList;

import com.test.student.model.Address;

/**
 *
 * @author kalyani
 */
public interface AddressManager {

	int TOTAL_ADDRESS = 10;
	List<Address> addresses = new ArrayList<Address>(TOTAL_ADDRESS);

	public void addAddress(Address address);

	public void deleteAddress(int d_no);

	public Address getAddress(int d_no);

}
