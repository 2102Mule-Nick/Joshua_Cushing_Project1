package com.lotus.staykeep.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.CallableStatementCreator;

public class ChangeRoomStatusCallable implements CallableStatementCreator{

	private String status;
	private int r_id;
	
	@Override
	public CallableStatement createCallableStatement(Connection con) throws SQLException {
		String sql = "{call change_room_status(?, ?)}";
		CallableStatement call = con.prepareCall(sql);
		
		call.setString(1, status);
		call.setInt(2, r_id);
		return call;
	}

	public ChangeRoomStatusCallable(String status, int r_id) {
		super();
		this.status = status;
		this.r_id = r_id;
	}
	


	
	
}
