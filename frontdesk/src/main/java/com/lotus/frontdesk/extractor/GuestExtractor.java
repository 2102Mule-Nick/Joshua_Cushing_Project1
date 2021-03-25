package com.lotus.frontdesk.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.lotus.frontdesk.pojo.Guest;

public class GuestExtractor implements ResultSetExtractor<Guest> {

	@Override
	public Guest extractData(ResultSet rs) throws SQLException, DataAccessException {
		Guest guest = new Guest();
		guest.setG_id(rs.getInt("g_id"));
		guest.setF_name(rs.getString("f_name"));
		guest.setL_name(rs.getString("l_name"));
		return guest;
	}

}
