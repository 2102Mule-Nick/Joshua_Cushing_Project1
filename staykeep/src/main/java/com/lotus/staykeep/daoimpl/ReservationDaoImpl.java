package com.lotus.staykeep.daoimpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lotus.staykeep.dao.ReservationDao;
import com.lotus.staykeep.mapper.GuestRowMapper;
import com.lotus.staykeep.mapper.ReservationRowMapper;
import com.lotus.staykeep.pojo.Guest;
import com.lotus.staykeep.pojo.Reservation;
import com.lotus.staykeep.pojo.Stay;

public class ReservationDaoImpl implements ReservationDao {

	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// GuestRowMapper to return Guest objects from database.
	private ReservationRowMapper reservationRowMapper;
	
	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Auto-wired ReservationRowMapper setter --> nothing calls this.
	@Autowired
	public void setReservationRowMapper(ReservationRowMapper reservationRowMapper) {
		this.reservationRowMapper = reservationRowMapper;
	}
//-----------------------------------------------------------------------------------------
	
	// Gets reservation id, check in time, check in date, check out time, check out date, room id, user id number given a reseration id. 
	// Returns a Reservation object with these values.
	@Override
	public Reservation getResById(int res_id) {
		String sql = "SELECT res_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status FROM reservaton WHERE res_id = ?";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper, res_id);
		return reservationList.get(0);
	}

	// Gets reservation id, check in time, check in date, check out time, check out date, room id, user id number for all reservations. 
	// Returns a list of all Reservation objects.
	@Override
	public List<Reservation> getAllRes() {
		String sql = "SELECT res_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status FROM reservaton";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper);
		return reservationList;
	}

	
	// Gets reservation id, check in time, check in date, check out time, 
	// check out date, room id, user id number for all reservations with a certain status. 
	// Returns a list of all Reservation objects with that status.
	@Override
	public List<Reservation> getAllResStatus(String status) {
		String sql = "SELECT res_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status FROM reservaton WHERE status = ?";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper, status);
		return reservationList;
	}

	@Override
	public void setResInTime(Time ch_i_time, int res_id) {
		String sql = "UPDATE reservation SET ch_i_time = ? WHERE r_id = ?";
		jdbcTemplate.update(sql, ch_i_time, res_id);
		
	}

	@Override
	public void setResInDate(Date ch_i_date, int res_id) {
		String sql = "UPDATE reservation SET ch_i_date = ? WHERE r_id = ?";
		jdbcTemplate.update(sql, ch_i_date, res_id);
	}

	@Override
	public void setResOutTime(Time ch_o_time, int res_id) {
		String sql = "UPDATE reservation SET ch_o_time = ? WHERE r_id = ?";
		jdbcTemplate.update(sql, ch_o_time, res_id);
		
	}

	@Override
	public void setResOutDate(Date ch_o_date, int res_id) {
		String sql = "UPDATE reservation SET ch_o_date = ? WHERE r_id = ?";
		jdbcTemplate.update(sql, ch_o_date, res_id);
	}

	@Override
	public void setResStatus(String status, int res_id) {
		String sql = "UPDATE reservation SET status = ? WHERE res_id = ?";
		jdbcTemplate.update(sql, status, res_id);
	}

	@Override
	public void changeResToStay(Reservation res) {
		System.out.println("ADD FUNCTIONALITY L8R");
	}

	@Override
	public void createNewReservation(Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int r_id, int u_id, String status) {
		String sql = "INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status) VALUES ( ?, ?, ?, ?, ?, ?, ? )";
		jdbcTemplate.update(sql, ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status);
		
	}
}
