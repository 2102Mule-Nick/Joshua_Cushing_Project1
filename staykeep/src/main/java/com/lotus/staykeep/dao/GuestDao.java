package com.lotus.staykeep.dao;

import java.sql.Date;
import java.sql.Time;

import com.lotus.staykeep.pojo.Guest;
 
//Interface for handling Database functions concerning Guest objects.
public interface GuestDao {

	// Abstract method for getting a Guest with a certain guest id.
	// Returns a Guest object.
	public Guest getGuestInfoById(int g_id);

	// Abstract method for setting guest first name given the guest id.
	public void setGuestFname(String f_name, int g_id);
	
	// Abstract method for setting guest last name given the guest id.
	public void setGuestLname(String l_name, int g_id);
	
	// Abstract method for setting guest credit card number name given the guest id.
	public void setGuestCcnum(String cc_num, int g_id);
	
	// Abstract method for inserting a new guest into the database.
	public void createNewGuest(String f_name, String l_name, String cc_num);
}
