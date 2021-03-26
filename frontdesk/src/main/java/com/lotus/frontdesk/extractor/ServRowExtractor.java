package com.lotus.frontdesk.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.lotus.frontdesk.pojo.ServRow;

public class ServRowExtractor implements ResultSetExtractor<ServRow> {

	@Override
	public ServRow extractData(ResultSet rs) throws SQLException, DataAccessException {
		ServRow servRow = new ServRow();
		servRow.setRow_id(rs.getInt("row_id"));
		servRow.setItem_id(rs.getInt("item_id"));
		servRow.setOrder_id(rs.getInt("order_id"));
		return servRow;
	}

}
