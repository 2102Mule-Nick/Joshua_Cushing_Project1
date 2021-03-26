package com.lotusserver;

import javax.jws.WebService;

@WebService(endpointInterface = "com.lotusserver.MessageGen",
serviceName = "messageGenService")
public class MessageGenImpl implements MessageGen {

	@Override
	public String getConfirmMessage() {
		return "<SOAP ONLINE>";
	}
}
