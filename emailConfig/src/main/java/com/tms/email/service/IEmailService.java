package com.tms.email.service;

import java.util.List;

import com.tms.email.model.Recipient;


public interface IEmailService {

		public List<Recipient>  getEmails();
		public Recipient getEmailId(int id);
		public void sendTheEmails();
		public void sendOneEmail(int id);
}