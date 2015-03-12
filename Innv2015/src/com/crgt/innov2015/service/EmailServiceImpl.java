package com.crgt.innov2015.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.crgt.innov2015.model.EmailNotificationData;
import com.crgt.innov2015.util.Constants;

public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	final static Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public int sendEmail(final EmailNotificationData emailNotification) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.setTo(emailNotification.getEmailTo());
				helper.setFrom(emailNotification.getEmailFrom());
				if (null != emailNotification.getEmailCc()) {
					helper.setCc(emailNotification.getEmailCc());
				}
				helper.setSubject(emailNotification.getSubject());
				helper.setText((emailNotification.getEmailText()), true);
			}
		};
		try {
			this.mailSender.send(preparator);
			log.info("Sent message successfully....");
		} catch (MailException ex) {
			log.info(ex.getMessage());
			return Constants.ERROR;
		}

		return Constants.SUCCESS;
	}

}
