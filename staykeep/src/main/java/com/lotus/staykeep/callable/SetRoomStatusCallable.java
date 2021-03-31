package com.lotus.staykeep.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.CallableStatementCreator;

public class SetRoomStatusCallable implements CallableStatementCreator {

	private String status;
	private int r_id;
	
	@Override
	public CallableStatement createCallableStatement(Connection con) throws SQLException {
		String sql = "{call set_room_status(?, ?)}";
		CallableStatement callableStatement = con.prepareCall(sql);
		callableStatement.setString(1, status);
		callableStatement.setInt(2, r_id);
		return callableStatement;
	}

	public SetRoomStatusCallable(String status, int r_id) {
		super();
		this.status = status;
		this.r_id = r_id;
	}
}
