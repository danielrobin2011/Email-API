package com.tricon.admin.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.admin.service.IAdminService;

@RestController
public class AdminController{
    
	private IAdminService adminService;
	
	@RequestMapping(value="/sendEmails", method=RequestMethod.GET)
	public String  getEmails() {
		System.out.println("Inside: Controller");
		//String s=adminService.sendTheEmails();
		return adminService.sendTheEmails();
		
	}
}
