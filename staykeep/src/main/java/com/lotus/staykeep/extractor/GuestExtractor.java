/*
package com.lotus.staykeep.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.pojo.Guest;

@Component
public class GuestExtractor implements ResultSetExtractor<Guest> {

	@Override
	public Guest extractData(ResultSet rs) throws SQLException, DataAccessException {
		Guest guest = new Guest();
		guest.setG_id(rs.getInt("g_id"));
		guest.setF_name(rs.getString("f_name"));
		guest.setL_name(rs.getString("l_name"));
		guest.setCc_num(rs.getString("cc_num"));
		return guest;
	}

}
*/