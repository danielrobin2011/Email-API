package com.tricon.admin.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tricon.admin.dao.IAdminDao;
import com.tricon.admin.model.Group;
import com.tricon.admin.service.IAdminService;
import org.springframework.mail.javamail.JavaMailSender;



@Service
public class AdminService implements IAdminService {
	

		@Autowired
		private IAdminDao adminDao; 
		
		public List<Group> getEmails() {
			
			return adminDao.getEmails();
		}
		
		public Group getEmailId(int id) {
			
			return adminDao.getEmailId(id);
		}
		
	    @Autowired
	    private JavaMailSender sender;
	    
	    @Autowired
	    private IAdminService adminService;
	    
	    @Autowired
		public String sendTheEmails() {
			
			
			try {				
				MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        
		        helper.setFrom("daniel.robin@triconinfotech.com");
		        
		        
		        ArrayList<String> to= convertListToStringArray(adminService.getEmails());
		        String[] stringArray = to.toArray(new String[0]);
		        helper.setTo(stringArray);
		        helper.setText("How are you?");
		        helper.setSubject("Hi");
		        
		        sender.send(message);
			}
			catch(Exception e) {
				System.out.println("Snap! Something went wrong.");
			}
			return "Success";
		}
		
		private ArrayList<String> convertListToStringArray(List<Group> a){
		    	ArrayList<String> emails=new ArrayList<String>();
		    	for(int i=0;i<a.size();i++) {
		    		String s=a.get(i).getEmail();
		    		emails.add(s);
		    	}
		    	return emails;
		}
		
	}


