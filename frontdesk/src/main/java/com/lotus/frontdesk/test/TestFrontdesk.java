package com.lotus.frontdesk.test;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lotus.staykeep.Confirmer;
import com.lotus.staykeep.ConfirmerImplService;

public class TestFrontdesk {
	
	//Check to see that staykeep returns the proper message.
	@Test
	public void staykeepSoapShouldConfirm() {
		//Initial Confirmation that Soap is working
		ConfirmerImplService cis = new ConfirmerImplService();
		Confirmer confirmer = cis.getConfirmerImplPort();
		assertEquals("SOAP ONLINE", confirmer.confirm());
	}
}
