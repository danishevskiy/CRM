package com.onlinecrm.com.service;

import com.onlinecrm.com.model.Address;

import java.util.List;

public interface AddressService {

	void saveAddress(Address address);

	List<Address> findAllAddresses();

	void deleteAddressById(int id);

	Address findById(int id);

	void updateAddress(Address address);
}
