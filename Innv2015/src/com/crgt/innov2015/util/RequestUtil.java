package com.crgt.innov2015.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.crgt.innov2015.security.ldap.AuthenticateResult;

/**
 * Helper class to take request inputs and process them
 * 
 * @author mvattipulusu
 * 
 */
public class RequestUtil {


	public static String getAceId() {
		AuthenticateResult userDetails = RequestUtil.getUserDetails();
		return null != userDetails ? (null != userDetails.getUsername() ? userDetails.getUsername(): Constants.FLAG_EMPTY)
				: Constants.FLAG_EMPTY;
	}
	
	public static String getEmailId() {
		AuthenticateResult userDetails = RequestUtil.getUserDetails();
		return null != userDetails ? (null != userDetails.getEmail() ? userDetails.getEmail(): Constants.FLAG_EMPTY)
				: Constants.FLAG_EMPTY;
	}
	
	public static AuthenticateResult getUserDetails() {
		AuthenticateResult userDetails = null;
		Object principalObject = (Object) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
		if (principalObject.getClass().equals(AuthenticateResult.class)) {
			userDetails = (AuthenticateResult) principalObject;
		}
		return userDetails;
	}

}