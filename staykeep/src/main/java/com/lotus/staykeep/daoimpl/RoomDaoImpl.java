package com.lotus.staykeep.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lotus.staykeep.dao.RoomDao;
import com.lotus.staykeep.mapper.ReservationRowMapper;
import com.lotus.staykeep.mapper.RoomRowMapper;
import com.lotus.staykeep.mapper.StayRowMapper;
import com.lotus.staykeep.pojo.Reservation;
import com.lotus.staykeep.pojo.Room;
import com.lotus.staykeep.pojo.Stay;

// Indicates that an annotated class is a Repository.
@Repository
public class RoomDaoImpl implements RoomDao {

	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// RoomRowMapper to return Room objects from database.
	private RoomRowMapper roomRowMapper;

	// StayRowMapper to return Stay objects from database.
	private StayRowMapper stayRowMapper;
	
	// ReservationRowMapper to return Stay objects from database.
	private ReservationRowMapper reservationRowMapper;

	// Auto-wired setter --> nothing calls this.
	@Autowired
	public void setJdbcdTemplate(JdbcTemplate jdbcdTemplate) {
		this.jdbcTemplate = jdbcdTemplate;
	}

	// Auto-wired setter --> nothing calls this.
	@Autowired
	public void setRoomRowMapper(RoomRowMapper roomRowMapper) {
		this.roomRowMapper = roomRowMapper;
	}

	// Auto-wired setter --> nothing calls this.
	@Autowired
	public void setStayRowMapper(StayRowMapper stayRowMapper) {
		this.stayRowMapper = stayRowMapper;
	}
	
	// Auto-wired setter --> nothing calls this.
	@Autowired
	public void setReservationRowMapper(ReservationRowMapper reservationRowMapper) {
		this.reservationRowMapper = reservationRowMapper;
	}

//--------------------------------------------------------------

	// Method that gets all room info for a given room id number (r_id).
	@Override
	public Room getRoomInfoById(int r_id) {
		String sql = "SELECT r_id, status, bed_num, bed_size, lux_lev, cpn FROM room WHERE	 r_id = ?";
		List<Room> roomList = jdbcTemplate.query(sql, roomRowMapper, r_id);
		return roomList.get(0);
	}

	// Method that sets the status of a room given its r_id.
	// The statuses should always be "Resetting", "Open", "Occupied", or
	// "Maintenance".
	@Override
	public void setRoomStatus(String status, int r_id) {
		String sql = "UPDATE room SET status = ? WHERE r_id = ?";
		jdbcTemplate.update(sql, status, r_id);
	}
	
	// Method that gets all stays info for a given room id number (r_id).
	// This includes the current stay (if any) and all past stays.
	@Override
	public List<Stay> getStaysByRoom(int r_id) {
		String sql = "SELECT s_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill FROM stay WHERE r_id = ?";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper, r_id);
		return stayList;
	}

	// Method that gets all reservation info for a given room id number (r_id).
	// This includes past, upcoming, and canceled reservations.
	@Override
	public List<Reservation> getReservationsByRoom(int r_id) {
		String sql = "SELECT res_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, u_id, r_id, status FROM reservation WHERE r_id = ?";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper, r_id);
		return reservationList;
	}
}