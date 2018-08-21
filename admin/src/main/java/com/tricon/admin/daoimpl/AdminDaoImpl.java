package com.tricon.admin.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tricon.admin.dao.IAdminDao;
import com.tricon.admin.model.Group;



@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String FETCH_EMAILS="select * from recipientEmails";
	private static final String FETCH_EMAIL_BY_ID="select * from recipientEmails where id=?";

	@Override
	public List<Group> getEmails() {
		return this.jdbcTemplate.query(FETCH_EMAILS, new RowMapper<Group>() {
			public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			Group s=new Group();
			s.setId(rs.getInt("id"));
			s.setEmail(rs.getString("recipient_email"));
			return s;
			}
		});	
	}


	@Override
	public Group getEmailId(int id) {
		
		return this.jdbcTemplate.queryForObject(FETCH_EMAIL_BY_ID, new RowMapper<Group>() {
			public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			Group s=new Group();
			s.setId(rs.getInt("id"));
			s.setEmail(rs.getString("recipient_email"));
			return s;
			}
		},id);
	}
	
	
}