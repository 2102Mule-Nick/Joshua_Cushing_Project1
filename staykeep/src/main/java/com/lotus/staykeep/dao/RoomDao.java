package com.lotus.staykeep.dao;

import com.lotus.staykeep.pojo.Room;

public interface RoomDao {
	public Room getRoomInfoById(int r_id);
	public void changeRoomStatus(String status, int r_id);

	
/*
	public List<Stay> getStaysByRoom(int r_id);
	public List<Reservation> getReservationsByRoom(int r_id);
	public void changeRoomStatus(int r_id, String status);
*/
}
