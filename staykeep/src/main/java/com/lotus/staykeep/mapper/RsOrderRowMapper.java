/*
package com.lotus.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.lotus.staykeep.extractor.RsOrderExtractor;
import com.lotus.staykeep.pojo.RsOrder;


public class RsOrderRowMapper implements RowMapper<RsOrder> {

	private RsOrderExtractor rsOrderExtractor;

	@Autowired
	public void setRsOrderExtractor(RsOrderExtractor rsOrderExtractor) {
		this.rsOrderExtractor = rsOrderExtractor;
	}
	
	@Override
	public RsOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rsOrderExtractor.extractData(rs);
	}

}
*/
