package com.lotus.frontdesk.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lotus.frontdesk.extractor.RSOExtractor;

import com.lotus.frontdesk.pojo.RSOrder;

@Component
public class RSORowMapper implements RowMapper<RSOrder>{

	private RSOExtractor rSOExtractor;
	
	@Autowired
	public void setRSOrderExtractor(RSOExtractor rSOExtractor) {
		this.rSOExtractor = rSOExtractor;
	}
	
	@Override
	public RSOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rSOExtractor.extractData(rs);
	}

}
