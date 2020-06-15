/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sekhar.student.managerimpl;

import com.sekhar.student.manager.AddressManager;
import com.test.student.model.Address;

/**
 *
 * @author kalyani
 */
public class AddressManagerImpl implements AddressManager {

	public void addAddress(Address address) {
		addresses.add(address);
	}

	public void deleteAddress(int d_no) {
		for (int i = 0; i < addresses.size(); i++) {
			if (addresses.get(i).d_no == d_no) {
				addresses.remove(i);
				System.out.println("Address Removed");
				break;
			} else {
				System.out.println("Address not Found");
			}

		}

	}

	public Address getAddress(int d_no) {
		int index = -1;
		for (int i = 0; i < addresses.size(); i++) {
			if (addresses.get(i).d_no == d_no) {
				index = i;
				break;
			}

		}
		return addresses.get(index);
	}
}
