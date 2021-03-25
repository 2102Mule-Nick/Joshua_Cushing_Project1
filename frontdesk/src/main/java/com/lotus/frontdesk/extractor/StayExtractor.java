package com.lotus.frontdesk.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.lotus.frontdesk.pojo.Stay;

public class StayExtractor implements  ResultSetExtractor<Stay> {

	@Override
	public Stay extractData(ResultSet rs) throws SQLException, DataAccessException {
		Stay stay = new Stay();
		stay.setR_id(rs.getInt("s_id"));
		stay.setNum_nights(rs.getInt("num_nights"));
		stay.setCh_i_time(rs.getTime("ch_i_time"));
		stay.setCh_i_date(rs.getDate("ch_i_date"));
		stay.setCh_o_time(rs.getTime("ch_o_time"));
		stay.setCh_o_date(rs.getDate("ch_o_date"));
		stay.setG_id(rs.getInt("g_id"));
		stay.setR_id(rs.getInt("r_id"));
		stay.setStatus(rs.getString("status"));
		
		return stay;
	}

}
