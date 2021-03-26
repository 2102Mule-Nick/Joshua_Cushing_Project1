package com.lotus.frontdesk.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.lotus.frontdesk.pojo.RSOrder;

public class RSOExtractor implements ResultSetExtractor<RSOrder> {

	@Override
	public RSOrder extractData(ResultSet rs) throws SQLException, DataAccessException {
		RSOrder rSOrder = new RSOrder();
		rSOrder.setOrder_id(rs.getInt("order_id"));
		rSOrder.setR_id(rs.getInt("r_id"));
		rSOrder.setOrder_total(rs.getFloat("order_tot"));
		return rSOrder;
	}

}
