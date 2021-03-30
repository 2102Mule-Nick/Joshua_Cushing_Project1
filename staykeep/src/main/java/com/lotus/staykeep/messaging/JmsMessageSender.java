/*
package com.lotus.staykeep.messaging;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;

public class JmsMessageSender {
	private JmsTemplate jmsTemplate;
	
	private Queue queueNumberOne;

	private Topic topicNumberOne;
	
	@Autowired
	@Qualifier("destinationQueue")
	public void setQueueNumberOne(Queue queueNumberOne) {
		this.queueNumberOne = queueNumberOne;
	}

	@Autowired
	public void setTopic(Topic topicNumberOne) {
		this.topicNumberOne = topicNumberOne;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void simpleSendQ(String msg) {
		jmsTemplate.send(queueNumberOne, (s) -> s.createTextMessage(msg));
	}

	public void simpleSendT(String msg) {
		jmsTemplate.send(topicNumberOne, (s) -> s.createTextMessage(msg));

	}
}
*/