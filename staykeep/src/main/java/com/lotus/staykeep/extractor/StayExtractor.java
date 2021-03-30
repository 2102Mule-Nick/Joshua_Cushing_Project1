package com.lotus.staykeep.extractor;


import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.pojo.Stay;

@Component
public class StayExtractor implements  ResultSetExtractor<Stay> {

	@Override
	public Stay extractData(ResultSet rs) throws SQLException, DataAccessException {
		Stay stay = new Stay();
		stay.setR_id(rs.getInt("s_id"));
		stay.setCh_i_time(rs.getTime("ch_i_time"));
		stay.setCh_i_date(rs.getDate("ch_i_date"));
		stay.setCh_o_time(rs.getTime("ch_o_time"));
		stay.setCh_o_date(rs.getDate("ch_o_date"));
		stay.setG_id(rs.getInt("g_id"));
		stay.setR_id(rs.getInt("r_id"));
		stay.setBill(rs.getString("bill"));
		
		return stay;
	}

}
