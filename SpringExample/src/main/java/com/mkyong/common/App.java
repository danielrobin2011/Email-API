package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
        MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("tekatokikuta1996@gmail.com",
    		   "daniel.robin@triconinfotech.com",
    		   "Testing123", 
    		   "Testing only \n\n Hello Spring Email Sender");
    }
}
