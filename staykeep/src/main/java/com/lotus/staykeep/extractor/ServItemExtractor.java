/*
package com.lotus.staykeep.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.pojo.ServItem;


@Component
public class ServItemExtractor implements ResultSetExtractor<ServItem> {

	@Override
	public ServItem extractData(ResultSet rs) throws SQLException, DataAccessException {
		ServItem servItem = new ServItem();
		servItem.setItem_id(rs.getInt("item_id"));
		servItem.setItem_name(rs.getString("item_name"));
		servItem.setPrice(rs.getFloat("price"));
		return servItem;
	}
}
*/