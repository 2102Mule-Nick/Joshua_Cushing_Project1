package com.lotus.staykeep.dao;

import java.util.List;

import com.lotus.staykeep.pojo.Reservation;
import com.lotus.staykeep.pojo.Room;
import com.lotus.staykeep.pojo.Stay;

public interface RoomDao {
	// Abstract method for getting Room information by entering a room id.
	public Room getRoomInfoById(int r_id);

	// Abstract method for setting Room status by entering a status and a room id.
	public void setRoomStatus(String status, int r_id);

	// Abstract method for getting all the stays for a Room by entering a room id.
	public List<Stay> getStaysByRoom(int r_id);

	// Abstract method for getting all the reservations for a Room by entering a room id.
	public List<Reservation> getReservationsByRoom(int r_id);
}
