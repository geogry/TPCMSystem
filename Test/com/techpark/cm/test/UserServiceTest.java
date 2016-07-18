package com.techpark.cm.test;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techpark.cm.domain.User;
import com.techpark.cm.service.UserService;

public class UserServiceTest extends TestCase {

	public void testFindUserById(){
		BeanFactory commonFactory = new ClassPathXmlApplicationContext("applicationContext-common.xml");
		BeanFactory daoFactory = new ClassPathXmlApplicationContext("applicationContext-daos.xml");
		BeanFactory serviceFactory = new ClassPathXmlApplicationContext("applicationContext-beans.xml");
		UserService userService = (UserService)serviceFactory.getBean("userService");
		User user = userService.findUserById("20107924");
		System.out.println(user.getRelname());
	}
}
