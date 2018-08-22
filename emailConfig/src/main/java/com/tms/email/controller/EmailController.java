package com.tms.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tms.email.service.IEmailService;

@RestController
public class EmailController{
    
	@Autowired
	private IEmailService adminService;
	
	@RequestMapping(value="/sendEmails", method=RequestMethod.GET)
	public void getEmails(){
		System.out.println("Inside: Controller");
		adminService.sendTheEmails();
	}
	
	@RequestMapping(value="/sendEmailCreate/{id}", method=RequestMethod.GET)
	public void getEmailIdForCreate(@PathVariable int id) {
		System.out.println("Inside: Controller");
		adminService.sendOneEmail(id);
	}
	
}