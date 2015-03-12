package com.crgt.innov2015.model;

import com.crgt.innov2015.security.ldap.AuthenticateResult;
import com.crgt.innov2015.util.Constants;
import com.crgt.innov2015.util.RequestUtil;

public class EmailNotificationData {
	
	private String[] emailTo;
	private String[] prodEmailTo;		
	private String emailFrom;
	private String[] emailCc;
	private String[] prodEmailCc;
	private String subject;	
	private String emailText;		
	
	public EmailNotificationData(String[] emailTo, String emailFrom, String[] emailCc, String subject, String emailText) {	
		setEmailTo(emailTo);
		this.emailFrom = emailFrom;
		setEmailCc(emailCc);
		setSubject(subject);		
		setEmailText(emailText);
	}
	
	public EmailNotificationData() {		
	}
	
	public String[] getEmailTo() {
		return emailTo;
	}
	
	public void setEmailTo(String[] emailTo) {
		this.prodEmailTo = emailTo;
		if (Constants.EXECUTION_ENVIRONMENT.equalsIgnoreCase(Constants.EXECUTION_ENVIRONMENT_PROD)) {
			this.emailTo = emailTo;
		} else if (Constants.EXECUTION_ENVIRONMENT.equalsIgnoreCase(Constants.EXECUTION_ENVIRONMENT_TRAINING)) {
			this.emailTo = getLoggedInUserEmail();
		} else {
			this.emailTo = Constants.EMAIL_GROUP;
		}
	}
	
	public String getEmailFrom() {
		return emailFrom;
	}
	
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}	

	public String[] getEmailCc() {
		return emailCc;
	}
			
	public void setEmailCc(String[] emailCc) {
		if (emailCc != null && emailCc.length > 0) {
			this.prodEmailCc = emailCc;
			if (Constants.EXECUTION_ENVIRONMENT
					.equalsIgnoreCase(Constants.EXECUTION_ENVIRONMENT_PROD)) {
				this.emailCc = emailCc;
			} else if (Constants.EXECUTION_ENVIRONMENT
					.equalsIgnoreCase(Constants.EXECUTION_ENVIRONMENT_TRAINING)) {
				this.emailCc = getLoggedInUserEmail();
			} else {
				this.emailCc = Constants.EMAIL_GROUP;
			}
		}
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		if (Constants.EXECUTION_ENVIRONMENT.equalsIgnoreCase(Constants.EXECUTION_ENVIRONMENT_PROD)) 
			this.subject = subject;
		else 
			this.subject =  Constants.EXECUTION_ENVIRONMENT + ": " + subject;
	}
	
	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
		if (!Constants.EXECUTION_ENVIRONMENT
				.equalsIgnoreCase(Constants.EXECUTION_ENVIRONMENT_PROD)) {
			StringBuilder sb = new StringBuilder();
			sb.append(emailText);
			sb.append("</br></br></br></br></br></br>");
			sb.append("*********** BEGIN LOWER ENVIRONMENT TEST INFO  *************</br>");
			sb.append("*</br>");
			sb.append("*  This email originally would have been sent to:</br>");
			sb.append("*</br>");
			for (String str : prodEmailTo) {
				sb.append("* " + str + "</br>");
			}
			sb.append("*</br>");			
			if (null != prodEmailCc && prodEmailCc.length > 0) {
				sb.append("*  This email originally would have been also copied to:</br>");
				sb.append("*</br>");
				
				for (String str : prodEmailCc) {
					if (str != null) {
						sb.append("* " + str + "</br>");
					}
				}
			}
			sb.append("*</br>");
			sb.append("*  NOTE: THIS BLOCK WILL NOT APPEAR IN A PRODUCTION ENVIRONMENT</br>");
			sb.append("*</br>");
			sb.append("*********** END LOWER ENVIRONMENT TEST INFO  *************</br>");
			this.emailText = sb.toString();
		}
	}

	private String[] getLoggedInUserEmail() {
		String[] retVal = new String[1];
		AuthenticateResult userDetails = RequestUtil.getUserDetails();
		if (userDetails != null) {
			retVal[0] = userDetails.getEmail();
		}
		return retVal;
	}
}
