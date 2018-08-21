package com.tricon.admin.service;

import java.util.List;

import com.tricon.admin.model.Group;


public interface IAdminService {

		public List<Group>  getEmails();
		public Group getEmailId(int id);
		public String sendTheEmails();
}

	