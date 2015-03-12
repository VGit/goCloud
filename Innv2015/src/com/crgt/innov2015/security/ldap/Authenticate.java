/*
 * Copyright (c) 2009
 * United States Postal Service
 * All Rights Reserved.
 *
 * This document contains proprietary and confidential
 * information, and shall not be reproduced, transferred,
 * or disclosed to others, without the prior written consent of
 * United States Postal Service.
 */

package com.crgt.innov2015.security.ldap;

import java.util.List;

import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;

/**
 * Improved LDAP authentication service.
 * 
 * @author Shahil & Rajesh
 * @author Matthew Hill
 */

public class Authenticate {

	private static final Logger logger = LoggerFactory.getLogger(Authenticate.class);
	LdapOperations ldapOperations;

	/**
	 * Create a new authentication service.
	 * 
	 * @param ldapNamingContext
	 *            the LDAP naming context.
	 * @param ldapDomain
	 *            the LDAP domain.
	 * @param servers
	 *            a list of LDAP servers to attempt.
	 */

	public Authenticate(String ldapNamingContext, String ldapDomain,
			List<String> servers, List<String> allowedGroups) {
		this.ldapOperations = new LdapOperations(allowedGroups, ldapDomain,
				ldapNamingContext, servers);
	}

	public Authenticate(LdapOperations ldapOperations) {
		this.ldapOperations = ldapOperations;
	}

	public AuthenticateResult authenticateUser(String aceId, String pwd,
			List<String> userGroups) throws AuthenticationException,
			NamingException {
		AuthenticateResult authenticateResult;
		logger.debug("Invoking LDAP authentication:authenticateUser()");
		authenticateResult = ldapOperations.authorizeUser(aceId, pwd,
				userGroups);
		return authenticateResult;
	}
}
