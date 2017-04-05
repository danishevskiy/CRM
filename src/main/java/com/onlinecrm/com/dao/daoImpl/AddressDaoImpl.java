package com.onlinecrm.com.dao.daoImpl;

import com.onlinecrm.com.dao.AbstractDao;
import com.onlinecrm.com.dao.AddressDao;
import com.onlinecrm.com.model.Address;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

//@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao implements AddressDao {

	public void saveAddress(Address address) {
		persist(address);
	}

	@SuppressWarnings("unchecked")
	public List<Address> findAllAddresses() {
		Criteria criteria = getSession().createCriteria(Address.class);
		return (List<Address>) criteria.list();
	}

	public void deleteAddressById(int id) {
		Query query = getSession().createSQLQuery("delete from address where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	
	public Address findById(int id){
		Criteria criteria = getSession().createCriteria(Address.class);
		criteria.add(Restrictions.eq("id", id));
		return (Address) criteria.uniqueResult();
	}
	
	public void updateAddress(Address address){
		getSession().update(address);
	}
	
}
