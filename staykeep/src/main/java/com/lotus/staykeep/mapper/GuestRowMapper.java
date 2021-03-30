/*
package com.lotus.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.extractor.GuestExtractor;
import com.lotus.staykeep.pojo.Guest;


@Component
public class GuestRowMapper implements RowMapper<Guest> {

	private GuestExtractor guestExtractor;

	@Autowired
	public void setGuestExtractor(GuestExtractor guestExtractor) {
		this.guestExtractor = guestExtractor;
	}

	@Override
	public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
		return guestExtractor.extractData(rs);
	}
}
*/