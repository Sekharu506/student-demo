package com.sekhar.student.manager.inmemory;

import java.util.Set;
import com.sekhar.student.model.*;

public interface InMemoryBasedAddressManager {

	public void setAddress(Address address);

	public void removeAddress(int doorNo);

	public Address getAddress(int doorNo);

	public Set<Address> getAddresses();

}
