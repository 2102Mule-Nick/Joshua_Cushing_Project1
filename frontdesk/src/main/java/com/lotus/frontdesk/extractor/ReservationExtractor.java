package com.lotus.frontdesk.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.lotus.frontdesk.pojo.Reservation;


public class ReservationExtractor implements  ResultSetExtractor<Reservation>{

	@Override
	public Reservation extractData(ResultSet rs) throws SQLException, DataAccessException {
		Reservation reservation = new Reservation();
		
		reservation.setRes_id(rs.getInt("res_id"));
		reservation.setNum_nights(rs.getInt("num_nights"));
		reservation.setCh_i_time(rs.getTime("ch_i_time"));
		reservation.setCh_i_date(rs.getDate("ch_i_date"));
		reservation.setCh_o_time(rs.getTime("ch_o_time"));
		reservation.setCh_o_date(rs.getDate("ch_o_date"));
		reservation.setG_id(rs.getInt("g_id"));
		reservation.setR_id(rs.getInt("r_id"));
		return reservation;
	}
}
