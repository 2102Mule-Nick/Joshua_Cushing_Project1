package com.lotusserver;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MessageGen {
	@WebMethod
	String getConfirmMessage();
}
