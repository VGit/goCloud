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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Result object for LDAP (ACE) searches.
 *
 * @author Matthew Hill
 */

public class AuthenticateResult implements Serializable {
	
	private static final long serialVersionUID = -7912289992565085946L;
	
	private String email;
    private String firstname;
    private String lastname;
    private String telephone;
    private String initials;
    private String generationQualifier;
    private String username;
    private String displayName;
    private String financeNumber;
    private List<String> errorMessages=new ArrayList<String>();
    private boolean authenticated;
    private List<String> userGroups;

    public AuthenticateResult(String email, String firstname, String lastname,
            String telephone, String initials, String generationQualifier,
            String username, String displayName, String financeNumber, boolean authenticated) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.initials = initials;
        this.generationQualifier = generationQualifier;
        this.username = username;
        this.displayName = displayName;
        this.financeNumber = financeNumber;
        this.authenticated = authenticated;
        
    }

    public AuthenticateResult(boolean authenticated) {
        this.authenticated = authenticated;
    }

    
    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGenerationQualifier() {
        return generationQualifier;
    }

    public String getInitials() {
        return initials;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getErrorMessages() {
	    return errorMessages;
    }
    
    public void addErrorMessage(String errorMessage){
    	errorMessages.add(errorMessage);
    }

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public void setGenerationQualifier(String generationQualifier) {
		this.generationQualifier = generationQualifier;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getFinanceNumber() {
		return financeNumber;
	}

	public void setFinanceNumber(String financeNumber) {
		this.financeNumber = financeNumber;
	}

	public void setUserGroups(List<String> userGroups) {
		this.userGroups = userGroups;
	}

	public List<String> getUserGroups() {
		return userGroups;
	}
    
	public AuthenticateResult() {
		super();
		this.email = "Silpa.N.Talluri@usps.gov";
		this.firstname = "Silpa";
		this.lastname = "Talluri";
		this.username = "J236N0";
//
//		 this.email = "Elizabeth.A.Visneski@usps.gov";
//		 this.firstname = "Elizabeth";
//		 this.lastname = "Visneski";
//		 this.username = "B8P3M0";

		this.displayName = "";
		this.financeNumber = "";
		this.authenticated = true;
	}

    
}
