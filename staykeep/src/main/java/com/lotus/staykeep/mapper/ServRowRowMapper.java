/*
package com.lotus.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.lotus.staykeep.extractor.ServRowExtractor;
import com.lotus.staykeep.pojo.ServRow;




public class ServRowRowMapper implements RowMapper<ServRow> {

	
	private ServRowExtractor servRowExtractor;
	
	@Autowired
	public void setServItemExtractor(ServRowExtractor servRowExtractor) {
		this.servRowExtractor = servRowExtractor;
	}
	@Override
	public ServRow mapRow(ResultSet rs, int rowNum) throws SQLException {
		return servRowExtractor.extractData(rs);
	}

}
*/