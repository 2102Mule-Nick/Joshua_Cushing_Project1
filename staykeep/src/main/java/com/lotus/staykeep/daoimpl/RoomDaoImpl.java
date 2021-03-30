package com.lotus.staykeep.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lotus.staykeep.callable.ChangeRoomStatusCallable;
import com.lotus.staykeep.dao.RoomDao;
import com.lotus.staykeep.mapper.RoomRowMapper;
import com.lotus.staykeep.pojo.Room;


@Repository
public class RoomDaoImpl implements RoomDao {

	private JdbcTemplate jdbcTemplate;
	
	private RoomRowMapper roomRowMapper;
	
	@Autowired
	public void setJdbcdTemplate(JdbcTemplate jdbcdTemplate) {
		this.jdbcTemplate = jdbcdTemplate;
	}
	
	@Autowired
	public void setRoomRowMapper(RoomRowMapper roomRowMapper) {
		this.roomRowMapper = roomRowMapper;
	}
//----------------------------------------------------------
		@Override
		public Room getRoomInfoById(int r_id) {
			String sql = "select * from get_room_info_by_id( ? )";
			List<Room> roomList = jdbcTemplate.query(sql, roomRowMapper, r_id);
			return roomList.get(0);
		}

		@Override
		public void changeRoomStatus(String status, int r_id) {	
			
			ChangeRoomStatusCallable call = new ChangeRoomStatusCallable(status, r_id);
			
			//String sql = "select change_room_status(?, ?)";
		
			//String sql =  "update room set status = ? where r_id = ?";
			jdbcTemplate.call(call, new ArrayList<>());
		}


}



















/*
private StayRowMapper stayRowMapper;

private ReservationRowMapper reservationRowMapper;



@Autowired
public void setStayRowMapper(StayRowMapper stayRowMapper) {
	this.stayRowMapper = stayRowMapper;
}

@Autowired
public void setReservationRowMapper(ReservationRowMapper reservationRowMapper) {
	this.reservationRowMapper = reservationRowMapper;
}


//TRY TO GET THIS ONE TO WORK WITH A PREPPED FUNCTION ON DBEAVER
@Override
public List<Stay> getStaysByRoom(int r_id) {
	String sql = "select * from get_stays_by_room( ? )";
	List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper, r_id);
	return stayList;
}

//TRY TO GET THIS ONE TO WORK WITH A PREPPED FUNCTION ON DBEAVER
@Override
public List<Reservation> getReservationsByRoom(int r_id) {
	String sql = "select * from  get_reservations_by_room( ? )";
	List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper, r_id);
	return reservationList;
}

@Override
public void changeRoomStatus(int r_id, String status) {
	String sql = "select change_room_status(?, ?)";
	jdbcTemplate.query(sql, roomRowMapper, r_id, status);	
}
*/