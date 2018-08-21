package com.tricon.admin.dao;

import java.util.List;

import com.tricon.admin.model.Group;

public interface IAdminDao {
	public List<Group> getEmails();
	public Group getEmailId(int id);
}
