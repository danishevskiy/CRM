package com.onlinecrm.com.service.serviceImpl;

import com.onlinecrm.com.dao.AddressDao;
import com.onlinecrm.com.model.Address;
import com.onlinecrm.com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	public void saveAddress(Address address) {
		addressDao.saveAddress(address);
	}

	public List<Address> findAllAddresses() {
		return  addressDao.findAllAddresses();
	}

	public void deleteAddressById(int id) {
		addressDao.deleteAddressById(id);
	}

	public Address findById(int id) {
		return  addressDao.findById(id);
	}

	public void updateAddress(Address address){
		addressDao.updateAddress(address);
	}
}
