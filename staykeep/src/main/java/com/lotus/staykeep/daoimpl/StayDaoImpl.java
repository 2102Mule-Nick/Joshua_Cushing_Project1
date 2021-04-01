package com.lotus.staykeep.daoimpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lotus.staykeep.dao.StayDao;
import com.lotus.staykeep.mapper.StayRowMapper;
import com.lotus.staykeep.pojo.Stay;

public class StayDaoImpl implements StayDao {

	
	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// GuestRowMapper to return Guest objects from database.
	private StayRowMapper stayRowMapper;
	

	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setStayRowMapper(StayRowMapper stayRowMapper) {
		this.stayRowMapper = stayRowMapper;
	}

	@Override
	public Stay getStayInfoById(int s_id) {
		String sql = "SELECT s_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill FROM stay WHERE s_id = ?";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper, s_id);
		return stayList.get(0);
	}

	@Override
	public List<Stay> getAllStays() {
		String sql = "SELECT s_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill FROM stay";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper);
		return stayList;
	}

	@Override
	public void createNewStay(Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int g_id, int r_id, String bill) {
		String sql = "INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill) VALUES ( ?, ?, ?, ?, ?, ?, ? )";
		jdbcTemplate.update(sql, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill);
		
	}

}
