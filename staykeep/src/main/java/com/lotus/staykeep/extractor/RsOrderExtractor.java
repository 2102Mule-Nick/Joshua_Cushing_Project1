/*
package com.lotus.staykeep.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.pojo.RsOrder;

@Component
public class RsOrderExtractor implements  ResultSetExtractor<RsOrder> {

	@Override
	public RsOrder extractData(ResultSet rs) throws SQLException, DataAccessException {

		RsOrder rsOrder = new RsOrder();
		rsOrder.setOrder_id(rs.getInt("order_id"));
		rsOrder.setR_id(rs.getInt("r_id"));
		rsOrder.setOrder_total(rs.getFloat("order_total"));

		return rsOrder;
		
	}

}
*/