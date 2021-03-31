package com.lotus.staykeep.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lotus.staykeep.callable.SetRoomStatusCallable;
import com.lotus.staykeep.dao.RoomDao;
import com.lotus.staykeep.mapper.ReservationRowMapper;
import com.lotus.staykeep.mapper.RoomRowMapper;
import com.lotus.staykeep.mapper.StayRowMapper;
import com.lotus.staykeep.pojo.Reservation;
import com.lotus.staykeep.pojo.Room;
import com.lotus.staykeep.pojo.Stay;

// Indicates that an annotated class is a Repository.
// A Repository is a mechanism for encapsulating storage,
// retrieval, and search behavior which emulates a collection of objects
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

	// Autowired setter - nothing calls this.
	@Autowired
	public void setJdbcdTemplate(JdbcTemplate jdbcdTemplate) {
		this.jdbcTemplate = jdbcdTemplate;
	}

	// Autowired setter - nothing calls this.
	@Autowired
	public void setRoomRowMapper(RoomRowMapper roomRowMapper) {
		this.roomRowMapper = roomRowMapper;
	}

	// Autowired setter - nothing calls this.
	@Autowired
	public void setStayRowMapper(StayRowMapper stayRowMapper) {
		this.stayRowMapper = stayRowMapper;
	}
	
	// Autowired setter - nothing calls this.
	@Autowired
	public void setReservationRowMapper(ReservationRowMapper reservationRowMapper) {
		this.reservationRowMapper = reservationRowMapper;
	}

//--------------------------------------------------------------

	// Method that gets all room info for a given room id number (r_id).
	@Override
	public Room getRoomInfoById(int r_id) {
		String sql = "select * from get_room_info_by_id( ? )";
		List<Room> roomList = jdbcTemplate.query(sql, roomRowMapper, r_id);
		return roomList.get(0);
	}

	// Method that sets the status of a room given its r_id.
	// The statuses should always be "Resetting", "Open", "Occupied", or
	// "Maintenance".
	@Override
	public void setRoomStatus(String status, int r_id) {
		SetRoomStatusCallable setRoomStatusCallable = new SetRoomStatusCallable(status, r_id);
		jdbcTemplate.call(setRoomStatusCallable, new ArrayList<>());
	}

	// Method that gets all stays info for a given room id number (r_id).
	// This includes the current stay (if any) and all past stays.
	@Override
	public List<Stay> getStaysByRoom(int r_id) {
		String sql = "select * from get_stays_by_room( ? )";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper, r_id);
		return stayList;
	}

	// Method that gets all reservation info for a given room id number (r_id).
	// This includes past, upcoming, and canceled reservations.
	@Override
	public List<Reservation> getReservationsByRoom(int r_id) {
		String sql = "select * from  get_reservations_by_room( ? )";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper, r_id);
		return reservationList;
	}
}











/*
 * 
 * 
 * @Override public void changeRoomStatus(String status, int r_id) {
 * 
 * ChangeRoomStatusCallable call = new ChangeRoomStatusCallable(status, r_id);
 * 
 * //String sql = "select change_room_status(?, ?)";
 * 
 * //String sql = "update room set status = ? where r_id = ?";
 * jdbcTemplate.call(call, new ArrayList<>()); }
 */

/*
 * private StayRowMapper stayRowMapper;
 * 
 * private ReservationRowMapper reservationRowMapper;
 * 
 * 
 * 
 * @Autowired public void setStayRowMapper(StayRowMapper stayRowMapper) {
 * this.stayRowMapper = stayRowMapper; }
 * 
 * @Autowired public void setReservationRowMapper(ReservationRowMapper
 * reservationRowMapper) { this.reservationRowMapper = reservationRowMapper; }
 * 
 * 
 * //TRY TO GET THIS ONE TO WORK WITH A PREPPED FUNCTION ON DBEAVER
 * 
 * @Override public List<Stay> getStaysByRoom(int r_id) { String sql =
 * "select * from get_stays_by_room( ? )"; List<Stay> stayList =
 * jdbcTemplate.query(sql, stayRowMapper, r_id); return stayList; }
 * 
 * //TRY TO GET THIS ONE TO WORK WITH A PREPPED FUNCTION ON DBEAVER
 * 
 * @Override public List<Reservation> getReservationsByRoom(int r_id) { String
 * sql = "select * from  get_reservations_by_room( ? )"; List<Reservation>
 * reservationList = jdbcTemplate.query(sql, reservationRowMapper, r_id); return
 * reservationList; }
 * 
 * @Override public void changeRoomStatus(int r_id, String status) { String sql
 * = "select change_room_status(?, ?)"; jdbcTemplate.query(sql, roomRowMapper,
 * r_id, status); }
 */