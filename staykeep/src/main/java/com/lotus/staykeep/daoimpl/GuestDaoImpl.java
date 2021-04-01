package com.lotus.staykeep.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lotus.staykeep.mapper.GuestRowMapper;
import com.lotus.staykeep.dao.GuestDao;
import com.lotus.staykeep.pojo.Guest;

//Indicates that an annotated class is a Repository.
@Repository
public class GuestDaoImpl implements GuestDao {

	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// GuestRowMapper to return Guest objects from database.
	private GuestRowMapper guestRowMapper;

	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Auto-wired GuestRowMapper setter --> nothing calls this.
	@Autowired
	public void setGuestRowMapper(GuestRowMapper guestRowMapper) {
		this.guestRowMapper = guestRowMapper;
	}

//-----------------------------------------------------------------------------------
	
	// Gets guest id, first name, last name, and credit card number given a guest id. 
	// Returns a Guest object with these values.
	@Override
	public Guest getGuestInfoById(int g_id) {
		String sql = "SELECT g_id, f_name, l_name, cc_num FROM guest WHERE g_id = ?";
		List<Guest> guestList = jdbcTemplate.query(sql, guestRowMapper, g_id);
		return guestList.get(0);
	}

	// Changes the first name of a guest given guest id.
	@Override
	public void setGuestFname(String f_name, int g_id) {
		String sql = "UPDATE guest SET f_name = ? WHERE g_id = ?";
		jdbcTemplate.update(sql, f_name, g_id);
	}

	// Changes the last name of a guest given guest id.
	@Override
	public void setGuestLname(String l_name, int g_id) {
		String sql = "UPDATE guest SET l_name = ? WHERE g_id = ?";
		jdbcTemplate.update(sql, l_name, g_id);
	}

	// Changes the credit card number of a guest given guest id. 
	@Override
	public void setGuestCcnum(String cc_num, int g_id) {
		String sql = "UPDATE guest SET cc_num = ? WHERE g_id = ?";
		jdbcTemplate.update(sql, cc_num, g_id);
	}

	// Inserts a new guest into the database.
	@Override
	public void createNewGuest(String f_name, String l_name, String cc_num) {
		String sql = "INSERT INTO guest (f_name, l_name, cc_num) VALUES ( ?, ?, ? )";
		jdbcTemplate.update(sql, f_name, l_name, cc_num);	
	}
}
