package com.crgt.innov2015.security.ldap;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;


public class LdapObjectMapper {
	 
	protected LdapObject searchResultToLdapObject(SearchResult searchResult){
		Attributes attrs = searchResult.getAttributes();
        LdapObject ldapObject = new LdapObject();
        if (attrs != null) {
            try {
                for (NamingEnumeration<? extends Attribute> ae = attrs.getAll(); ae.hasMore();) {
                    Attribute attr = (Attribute) ae.next();
                    String values[] = new String[attr.size()];
                    int value_pos = 0;
                    for (NamingEnumeration<?> e = attr.getAll(); e.hasMore();) {
                        values[value_pos++] = e.next().toString();
                    }
                    ldapObject.put(attr.getID(), values);
                }
            } catch (Exception e) {
                // do nothing;
            }
        }
        return ldapObject;
		
	}
	protected List<LdapObject> createLdapObjectList(NamingEnumeration<SearchResult> answer) throws NamingException{
	    	ArrayList<LdapObject> queryResults = new ArrayList<LdapObject>();  
	    	while (answer.hasMoreElements()) {
	                SearchResult sr = answer.next();
	                LdapObject attributes = searchResultToLdapObject(sr);
	                if (attributes.size() != 0) {
	                    queryResults.add(attributes);
	                }
	            }
	    	return queryResults;
	    }
}
