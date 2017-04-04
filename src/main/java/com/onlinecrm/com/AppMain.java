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

		UserService service = (UserService) context.getBean("userService");

		/*
		 * Create Employee1
		 */
		User employee1 = new User();
		employee1.setName("Han Yenn");
		employee1.setSurname("val");
		employee1.setEmail("dan@i.dws");
		employee1.setPhone("38067676767");
		employee1.setPosition("Manager");
		employee1.setPassword("1");
		employee1.setJoiningDate(new LocalDate(2010, 10, 10));


		service.saveUser(employee1);
		System.out.println(employee1.toString());



		/*
		 * Create Employee2
		 */
		/*User employee2 = new User();
		employee2.setName("Han Yenn");
		employee2.setJoiningDate(new LocalDate(2010, 10, 10));
		employee2.setEmail("dan@i.d");
		employee2.setPosition("Manager");
		employee2.setSurname("valt");
		employee2.setPassword("2");
		employee2.setPhone("38067676777");*/

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
		List<User> employeeList = service.findAllUsers();
		for (User emp : employeeList) {
			System.out.println(emp);
		}

		context.close();
	}
}
