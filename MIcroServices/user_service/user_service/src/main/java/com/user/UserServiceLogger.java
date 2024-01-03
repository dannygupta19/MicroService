package com.user;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;
@Aspect
@Component
public class UserServiceLogger {

	
	@Before("execution(* com.user.service.UserService.*(..))")
	public void Before()
	{
		System.out.println("User Service Started...");
	}
	
	@After("execution(* com.user.service.UserService.*(..))")
	public void After()
	{
		System.out.println("User Service Run Successfully ");
	}
}
