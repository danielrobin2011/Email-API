package com.tms.email.dao;

import java.util.List;

import com.tms.email.model.Recipient;

public interface IEmailDao {
	public List<Recipient> getEmails();
	public Recipient getEmailId(int id);
	public String getFname(int id);
	public String getLname(int id);
	
}