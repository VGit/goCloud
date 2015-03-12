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

import java.util.Hashtable;

/**
 * @author B7WFH0
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class LdapObject extends Hashtable<Object, Object> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7265956465617818990L;

	public Object getAttributeValue(Object attributeName) {
        Object returnValue = null;
        if (super.containsKey(attributeName)) {
            Object[] attributeValues = (Object[]) super.get(attributeName);
            returnValue = attributeValues[0];
        } else {
            returnValue = "";
        }
        return returnValue;
    }

    public Object[] getAttributeValues(Object attributeName) {
        Object[] returnValues = null;
        if (super.containsKey(attributeName)) {
            returnValues = (Object[]) super.get(attributeName);
        } else {
            returnValues = new String[1];
            returnValues[0] = "";
        }
        return returnValues;
    }

    public String getPrimarySMTPAddress() {
        String[] proxyAddresses = (String[]) this.getAttributeValues("proxyAddresses");
        String returnValue = "";

        for (int i = 0; i < proxyAddresses.length; i++) {
            if (proxyAddresses[i].startsWith("SMTP:")) {
                returnValue = proxyAddresses[i].substring(5);
                break;
            }
        }
        return returnValue;
    }

}
