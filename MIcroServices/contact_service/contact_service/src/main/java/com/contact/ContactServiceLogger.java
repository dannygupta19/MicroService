package com.contact;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ContactServiceLogger {

	
	@Before("execution(* com.contact.service.ContactService.*(..))")
	public void Around()
	{
		System.out.println("Contact Service is running Successfully...");
	}
}
