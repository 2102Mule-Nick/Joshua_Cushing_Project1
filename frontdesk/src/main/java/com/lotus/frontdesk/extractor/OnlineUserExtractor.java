package com.lotus.frontdesk.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.lotus.frontdesk.pojo.OnlineUser;

public class OnlineUserExtractor implements ResultSetExtractor<OnlineUser>{

	@Override
	public OnlineUser extractData(ResultSet rs) throws SQLException, DataAccessException {
		OnlineUser onlineUser = new OnlineUser();
		onlineUser.setOu_id(rs.getInt("ou_id"));
		onlineUser.setEmail(rs.getString("email"));
		onlineUser.setPhone(rs.getString("phone"));
		onlineUser.setUser_name(rs.getString("user_name"));
		onlineUser.setPass_word(rs.getString("pass_word"));
		onlineUser.setG_id(rs.getInt("g_id"));
		return onlineUser;
	}

}
