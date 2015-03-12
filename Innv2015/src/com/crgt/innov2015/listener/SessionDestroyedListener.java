package com.crgt.innov2015.listener;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class SessionDestroyedListener implements
		ApplicationListener<SessionDestroyedEvent> {

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		System.out.println("Session destroyed at "
				+ new SimpleDateFormat("yyyy-MM-dd").format(event.getTimestamp())
				+ " and session is " + event.getId());
	}
}
