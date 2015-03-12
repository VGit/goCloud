package com.crgt.innov2015.listener;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionCreatedEvent;

public class SessionCreatedListener implements
		ApplicationListener<HttpSessionCreatedEvent> {
	private int counter = 0;

	@Override
	public void onApplicationEvent(
			HttpSessionCreatedEvent httpSessionCreatedEvent) {
		counter++;
		System.out.println("Total sessions created " + counter);

		System.out.println("Session created at "
				+ new SimpleDateFormat("yyyy-MM-dd").format(httpSessionCreatedEvent.getTimestamp())
				+ " and session is " + httpSessionCreatedEvent.getSession());
	}

}
