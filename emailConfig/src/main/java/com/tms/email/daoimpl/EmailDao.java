package com.tms.email.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tms.email.dao.IEmailDao;
import com.tms.email.model.Recipient;



@Repository
public class EmailDao implements IEmailDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String FETCH_EMAILS="select * from recipientEmails";
	private static final String FETCH_EMAIL_BY_ID="select * from recipientEmails where id=?";

	@Override
	public List<Recipient> getEmails() {
		return this.jdbcTemplate.query(FETCH_EMAILS, new RowMapper<Recipient>() {
			public Recipient mapRow(ResultSet rs, int rowNum) throws SQLException {
			Recipient s=new Recipient();
			s.setId(rs.getInt("id"));
			s.setEmail(rs.getString("recipient_email"));
			s.setFname(rs.getString("fname"));
			s.setLname(rs.getString("lname"));
			return s;
			}
		});	
	}

	@Override
	public Recipient getEmailId(int id) {
		
		return this.jdbcTemplate.queryForObject(FETCH_EMAIL_BY_ID, new RowMapper<Recipient>() {
			public Recipient mapRow(ResultSet rs, int rowNum) throws SQLException {
			Recipient s=new Recipient();
			s.setId(rs.getInt("id"));
			s.setEmail(rs.getString("recipient_email"));
			s.setFname(rs.getString("fname"));
			s.setLname(rs.getString("lname"));
			return s;
			}
		},id);
	}

	@Override
	public String getFname(int id) {
		return this.jdbcTemplate.queryForObject(FETCH_EMAIL_BY_ID, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			Recipient s=new Recipient();
			s.setFname(rs.getString("fname"));
			return s.getFname();
			}
		},id);
	}

	@Override
	public String getLname(int id) {
		return this.jdbcTemplate.queryForObject(FETCH_EMAIL_BY_ID, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			Recipient s=new Recipient();
			s.setLname(rs.getString("lname"));
			return s.getLname();
			}
		},id);
	}



}