package com.onlinecrm.com;

import com.onlinecrm.com.configuration.AppConfig;
import com.onlinecrm.com.model.User;
import com.onlinecrm.com.service.UserService;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class AppMain {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService service = (UserService) context.getBean("userService");

		/*
		 * Create Employee1
		 */
		User employee1 = new User();
		employee1.setName("Han Yenn");
		employee1.setJoiningDate(new LocalDate(2010, 10, 10));
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("ssn00000001");

		/*
		 * Create Employee2
		 */
		User employee2 = new User();
		employee2.setName("Dan Thomas");
		employee2.setJoiningDate(new LocalDate(2012, 11, 11));
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("ssn00000002");

		/*
		 * Persist both Employees
		 */
		service.saveUser(employee1);
		service.saveUser(employee2);

		/*
		 * Get all employees list from database
		 */
		List<User> employees = service.findAllUsers();
		for (User emp : employees) {
			System.out.println(emp);
		}

		/*
		 * delete an employee
		 */
		service.deleteUserBySsn("ssn00000002");

		/*
		 * update an employee
		 */

		User employee = service.findBySsn("ssn00000001");
		employee.setSalary(new BigDecimal(50000));
		service.updateUser(employee);

		/*
		 * Get all employees list from database
		 */
		List<User> employeeList = service.findAllUsers();
		for (User emp : employeeList) {
			System.out.println(emp);
		}

		context.close();
	}
}
