package com.lotus.frontdesk.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import com.lotus.frontdesk.extractor.ServItemExtractor;

import com.lotus.frontdesk.pojo.ServItem;

@Component
public class ServItemRowMapper implements RowMapper<ServItem> {

	private ServItemExtractor servItemExtractor;
	
	@Autowired
	public void setServItemExtractor(ServItemExtractor servItemExtractor) {
		this.servItemExtractor = servItemExtractor;
	}
	
	@Override
	public ServItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		return servItemExtractor.extractData(rs);
	}

}
