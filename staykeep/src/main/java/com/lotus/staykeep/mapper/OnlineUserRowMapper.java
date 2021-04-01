
package com.lotus.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.extractor.OnlineUserExtractor;
import com.lotus.staykeep.pojo.OnlineUser;



@Component
public class OnlineUserRowMapper implements RowMapper<OnlineUser> {

	private OnlineUserExtractor onlineUserExtractor;

	@Autowired
	public void setOnlineUserExtractor(OnlineUserExtractor onlineUserExtractor) {
		this.onlineUserExtractor = onlineUserExtractor;
	}
	
	@Override
	public OnlineUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		return onlineUserExtractor.extractData(rs);
	}

}
