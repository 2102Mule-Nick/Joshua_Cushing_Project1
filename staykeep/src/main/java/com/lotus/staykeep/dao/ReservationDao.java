package com.lotus.staykeep.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import com.lotus.staykeep.pojo.Reservation;

// Interface for handling Database functions concerning Reservation objects.
public interface ReservationDao {
	
	// Abstract method for getting a Reservation with a certain reservation id.
	// Returns a Reservation object.
	public Reservation getResById(int res_id);
	
	// Abstract method for getting all reservations.
	// Returns a List of Reservation objects.
	public List<Reservation> getAllRes();
	
	// Abstract method for getting all reservations with a certain status.
	// Returns a List of Reservation objects.
	public List<Reservation> getAllResStatus(String status);
	
	// Abstract method for setting reservation check in time given the reservation id.
	public void setResInTime(Time ch_i_time, int res_id);
	
	// Abstract method for setting reservation check in date given the reservation id.
	public void setResInDate(Date ch_i_date, int res_id);
	
	// Abstract method for setting reservation check out time given the reservation id.
	public void setResOutTime(Time ch_o_time, int res_id);
	
	// Abstract method for setting reservation check out date given the reservation id.
	public void setResOutDate(Date ch_o_date, int res_id);
	
	// Abstract method for setting reservation status given the reservation id.
	public void setResStatus(String status, int res_id);
	
	// Abstract method for transferring a Reservation into a stay.
	public void changeResToStay(Reservation res);
	
	// Abstract method for inserting a new reservation into the database.
	public void createNewReservation(Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int r_id, int u_id, String status);
}
