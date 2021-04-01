package com.lotus.staykeep.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import com.lotus.staykeep.pojo.Stay;

//Interface for handling Database functions concerning Stay objects.
public interface StayDao {
	// Abstract method for getting a Stay with a certain stay id.
	// Returns a Stay object.
	public Stay getStayInfoById(int s_id);
	
	// Abstract method for getting all reservations.
	// Returns a List of Reservation objects.
	public List<Stay> getAllStays();
	
	
	
	// Abstract method for inserting a new stay into the database.
	public void createNewStay(Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int g_id, int r_id, String bill);
}
