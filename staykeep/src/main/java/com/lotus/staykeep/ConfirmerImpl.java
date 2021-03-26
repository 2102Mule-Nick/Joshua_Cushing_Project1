package com.lotus.staykeep;

import javax.jws.WebService;

@WebService(endpointInterface = "com.lotus.staykeep.Confirmer", 
serviceName ="confirmerImplService")
public class ConfirmerImpl implements Confirmer {

	public String confirm() {
		return "SOAP ONLINE";
	}
}
