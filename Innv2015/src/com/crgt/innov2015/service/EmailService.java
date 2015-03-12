package com.crgt.innov2015.service;

import org.springframework.stereotype.Service;

import com.crgt.innov2015.model.EmailNotificationData;

/**
 * Service for sending email
 *
 */
@Service("emailService")
public interface EmailService {
	
	int sendEmail(EmailNotificationData EmailNotificationData);
		
}
