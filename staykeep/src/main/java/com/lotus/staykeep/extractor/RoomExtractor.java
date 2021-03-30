package com.lotus.staykeep.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.pojo.Room;

@Component
public class RoomExtractor implements  ResultSetExtractor<Room>{

	@Override
	public Room extractData(ResultSet rs) throws SQLException, DataAccessException {
		Room room = new Room();
		room.setR_id(rs.getInt("r_id"));
		room.setStatus(rs.getString("status"));
		room.setBed_num(rs.getInt("bed_num"));
		room.setBed_size(rs.getString("bed_size"));
		room.setLux_level(rs.getString("lux_lev"));
		room.setCpn(rs.getFloat("cpn"));
		
		return room;
	}

}
