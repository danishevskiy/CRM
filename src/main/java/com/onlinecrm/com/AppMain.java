package com.onlinecrm.com;

import com.onlinecrm.com.configuration.AppConfig;
import com.onlinecrm.com.model.User;
import com.onlinecrm.com.service.UserService;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class AppMain {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = (UserService) context.getBean("userService");

		//AddressService addressService = (AddressService) context.getBean("addressService");

		//CompanyService companyService = (CompanyService) context.getBean("companyService");

		/*
		 * Create User1
		 */
		User user1 = new User();
		user1.setName("admin");
		user1.setSurname("admin");
		user1.setEmail("admin@i.dws");
		user1.setPhone("38067676767");
		user1.setPosition("Manager");
		user1.setPassword("admin");
		user1.setJoiningDate(new LocalDate(2010, 10, 10));

		userService.saveUser(user1);
		System.out.println(user1.toString());

		/*
		 * Create Address1
		 */
		/*Address address1 = new Address();

		address1.setCity("Kiev");
		address1.setCountry("Ukraine");
		address1.setStreet("Peremogu aveny");
		address1.setNumber("4");
		address1.setZipCode("20200");

		addressService.saveAddress(address1);
		System.out.println(address1.toString());

		Company company1 = new Company();
		company1.setName("KIEP");
		company1.setJoiningDate(new LocalDate(2000,10,10));
		company1.setNameChief("Iurii");
		company1.setSurnameChief("Malahov");
		company1.setAddress(address1);
		company1.setPassword("1111");
		company1.setTIN("12345678912345");

		companyService.saveCompany(company1);
		System.out.println(company1.toString());










		/*
		 * Persist both Employees
		 */

		//service.saveUser(employee2);

		/*
		 * Get all employees list from database
		 */
		/*List<User> employees = service.findAllUsers();
		for (User emp : employees) {
			System.out.println(emp);
		}*/

		/*
		 * delete an employee
		 */
		//service.deleteUserByName("Han Yenn");

		/*
		 * update an employee
		 */

		/*User employee = service.findByName("Han Yenn");
		employee.setPosition("director");
		service.updateUser(employee);
*/
		/*
		 * Get all employees list from database
		 */
		List<User> employeeList = userService.findAllUsers();
		for (User emp : employeeList) {
			System.out.println(emp);
		}

		context.close();
	}
}
