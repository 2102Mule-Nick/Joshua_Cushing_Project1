package com.lotus.staykeep.dao;

import java.util.List;

import com.lotus.staykeep.pojo.Reservation;
import com.lotus.staykeep.pojo.Room;
import com.lotus.staykeep.pojo.Stay;

//Interface for handling Database functions concerning Room objects.
public interface RoomDao {
	
	// Abstract method for getting a Room with a certain room id.
	// Returns a Room object.
	public Room getRoomInfoById(int r_id);

	// Abstract method for setting room status given the room id.
	public void setRoomStatus(String status, int r_id);

	// Abstract method for getting all stays with a certain room id. (Stays IN that room)
	// Returns a List of Stay objects.
	public List<Stay> getStaysByRoom(int r_id);

	// Abstract method for getting all reservations with a certain room id. (Reservations FOR that room)
	// Returns a List of Reservation objects.
	public List<Reservation> getReservationsByRoom(int r_id);
}
