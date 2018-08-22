package com.tms.email.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
//import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.tms.email.service.IEmailService;
import com.tms.email.dao.IEmailDao;
import com.tms.email.model.Recipient;
import org.springframework.mail.javamail.JavaMailSender;



@Service
public class EmailService implements IEmailService {
	

		@Autowired
		private IEmailDao emailDao; 
		
		public List<Recipient> getEmails() {
			
			return emailDao.getEmails();
		}
		
		public Recipient getEmailId(int id) {
			
			return emailDao.getEmailId(id);
		}
		
	    @Autowired
	    private JavaMailSender sender;
	    
	    @Autowired
		VelocityEngine velocityEngine;

		public void sendTheEmails() {
			
			
			try {				
				MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        
		        helper.setFrom("daniel.robin@triconinfotech.com");
		       
		        ArrayList<String> to= convertListToStringArray(emailDao.getEmails());
		        String[] stringArray = to.toArray(new String[0]);
		        helper.setTo(stringArray);
		        
		        Map < String, Object > model = new HashMap <String, Object> ();
		        
		        helper.setText(getContentFromTemplateGroup(model),true);
		        helper.setSubject("Ticketing Management System");
		        
		        sender.send(message);
			}
			catch(Exception e) {
				System.out.println("Snap! Something went wrong.");
			}

		}
		

		public void sendOneCreateEmail(int id) {
			
			
			try {				
				MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		       
		        Recipient s=new Recipient();
		        s=emailDao.getEmailId(id);
		        String firstName=emailDao.getFname(id);
		        String lastName=emailDao.getLname(id);
		        
		        helper.setFrom("daniel.robin@triconinfotech.com");
		        helper.setTo(s.getEmail());
		        
		        Map < String, Object > model = new HashMap < String, Object > ();
		        model.put("firstName", firstName);
		        model.put("secondName", lastName);
		        
		        helper.setText(getContentFromTemplateCreation(model),true);
		        helper.setSubject("Ticketing Management System");
		        
		        sender.send(message);
			}
			catch(Exception e) {
				System.out.println("Snap! Something went wrong.");
			}
		}
	    
	    
public void sendOneEmail(int id) {
			
			
			try {				
				MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		       
		        Recipient s=new Recipient();
		        s=emailDao.getEmailId(id);
		        String firstName=emailDao.getFname(id);
		        String lastName=emailDao.getLname(id);
		        
		        helper.setFrom("daniel.robin@triconinfotech.com");
		        helper.setTo(s.getEmail());
		        
		        Map < String, Object > model = new HashMap < String, Object > ();
		        model.put("firstName", firstName);
		        model.put("secondName", lastName);
		        
		        helper.setText(getContentFromTemplateCreation(model),true);
		        helper.setSubject("Ticketing Management System");
		        
		        sender.send(message);
			}
			catch(Exception e) {
				System.out.println("Snap! Something went wrong.");
			}
		}
		
		private ArrayList<String> convertListToStringArray(List<Recipient> a){
		    	ArrayList<String> emails=new ArrayList<String>();
		    	for(int i=0;i<a.size();i++) {
		    		String s=a.get(i).getEmail();
		    		emails.add(s);
		    	}
		    	return emails;
		}
		
		 public String getContentFromTemplateCreation(Map < String, Object > model) {
		        StringBuffer content = new StringBuffer();
		        try {
		            content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/templates/emailCreation.vm", model));
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return content.toString();
		}
		 
		 /*public String getContentFromTemplateUpdation(Map < String, Object > model) {
		        StringBuffer content = new StringBuffer();
		        try {
		            content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/templates/emailUpdation.vm", model));
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return content.toString();
		}*/
		 
		 public String getContentFromTemplateGroup(Map < String, Object > model) {
		        StringBuffer content = new StringBuffer();
		        try {
		            content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/templates/groupCreation.vm", model));
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return content.toString();
		}
	}

