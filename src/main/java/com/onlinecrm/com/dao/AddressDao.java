package com.onlinecrm.com.dao;

import com.onlinecrm.com.model.Address;

import java.util.List;

public interface AddressDao {

	void saveAddress(Address address);
	
	List<Address> findAllAddresses();
	
	void deleteAddressById(int id);
	
	Address findById(int id);

	void updateAddress(Address address);
}
