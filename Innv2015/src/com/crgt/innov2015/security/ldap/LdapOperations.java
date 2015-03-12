package com.crgt.innov2015.security.ldap;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

public class LdapOperations {
	private static final Logger logger = LoggerFactory.getLogger(Authenticate.class);
	private static final int DEFAULT_LDAP_SEARCH_SCROPE = SearchControls.SUBTREE_SCOPE;
	private LdapObjectMapper ldapObjectMapper = new LdapObjectMapper();
	private LdapUrlResolver ldapUrlResolver = new LdapUrlResolver();
	private LdapContext ldapCtx;
	private String ldapNamingContext;
	private String ldapDomain;
	private List<String> servers;
	private List<String> allowedGroups;

	// Attibute list to get from the LDAP server
	private static final String attributeList[] = { "cn", "sn", "givenName",
			"initials", "generationQualifier", "displayName", "memberOf",
			"proxyAddresses", "sAMAccountName", "distinguishedName", "company",
			"employeeId", "streetAddress", "st", "l", "postalCode", "c",
			"title", "extensionAttribute1", "extensionAttribute2",
			"extensionAttribute3", "extensionAttribute4",
			"extensionAttribute5", "extensionAttribute6",
			"extensionAttribute7", "extensionAttribute8",
			"extensionAttribute9", "extensionAttribute10",
			"extensionAttribute11", "extensionAttribute12",
			"extensionAttribute13", "extensionAttribute4",
			"extensionAttribute15", "telephoneNumber", "pager", "mobile",
			"facsimileTelephoneNumber" };

	public LdapOperations(List<String> allowedGroups, String ldapDomain,
			String ldapNamingContext, List<String> servers) {
		super();
		this.allowedGroups = allowedGroups;
		this.ldapDomain = ldapDomain;
		this.ldapNamingContext = ldapNamingContext;
		this.servers = servers;
	}

	protected AuthenticateResult authorizeUser(String aceId, String password,
			List<String> userGroups) throws AuthenticationException,
			NamingException {
//		Hashtable<Object, Object> ldapEnv = initLdapEnv(aceId, password);
//		ldapCtx = bind(ldapEnv);
//		List<LdapObject> queryResult = ldapSearch(DEFAULT_LDAP_SEARCH_SCROPE,
//				createSamAccountNameFilter(aceId));
//		AuthenticateResult authenticateResult;
//		if (!CollectionUtils.isEmpty(queryResult)) {
//			List<String> userGroupsList = userHasGroup(userGroups,
//					allowedGroups);
//			authenticateResult = ldapObjectToAuthenticateResult(
//					queryResult.get(0), userGroupsList);
//		} else {
//			logger.warn("Null or empty result returned from LDAP search.");
//			authenticateResult = new AuthenticateResult(false);
//			authenticateResult.addErrorMessage("LDAP authentication error.");
//		}
//		ldapCtx.close();
//		if (ldapEnv != null) {
//			ldapEnv.clear();
//		}
//		return authenticateResult;
		return new AuthenticateResult();
	}

	protected LdapContext bind(Hashtable<Object, Object> ldapEnv)
			throws AuthenticationException {
		try {
			// Connect to Active Directory
			return new InitialLdapContext(ldapEnv, null);
		} catch (Exception e) {
			throw handleLdapException(e);
		}
	}

	protected AuthenticationException handleLdapException(Exception e) {
		logger.warn("Unable to bind to LDAP.");
		if (e.getMessage().indexOf("AcceptSecurityContext error, data 773") > 0) {
			return new BadCredentialsException(
					" The intial password on this account must be changed.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 52e") > 0) {
			return new BadCredentialsException(
					" The ACE ID or Password entered is not correct.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 525") > 0) {
			return new BadCredentialsException(
					" The ACE ID or Password entered is not correct.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 775") > 0) {
			return new BadCredentialsException(
					" The account entered is currently locked.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 530") > 0) {
			return new BadCredentialsException(
					" The account entered has restricted logon hours.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 531") > 0) {
			return new BadCredentialsException(
					" The account entered is locked down to a specific workstation.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 532") > 0) {
			return new BadCredentialsException(
					" The password has expired for this account.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 533") > 0) {
			return new BadCredentialsException(
					" The account entered is currently disabled.");
		} else if (e.getMessage().indexOf(
				"AcceptSecurityContext error, data 701") > 0) {
			return new BadCredentialsException(
					" The account entered has expired.");
		} else {
			return new BadCredentialsException(" bind Exception - " + e);
		}
	}

	protected String createSamAccountNameFilter(String aceId) {
		return "(samAccountName=" + aceId + ")";
	}

	protected List<String> userHasGroup(List<String> groups,
			List<String> allowedGroups) {
		List<String> userGroups = new ArrayList<String>();
		for (String allowedGroup : allowedGroups) {
			if (groups.contains(allowedGroup)) {
				userGroups.add(allowedGroup);
			}
		}
		return userGroups;
	}

	protected AuthenticateResult ldapObjectToAuthenticateResult(
			LdapObject ldapObject, List<String> userHasGroups) {
		AuthenticateResult result = new AuthenticateResult(
				ldapObject.getPrimarySMTPAddress(),
				(String) ldapObject.getAttributeValue("givenName"),
				(String) ldapObject.getAttributeValue("sn"),
				(String) ldapObject.getAttributeValue("telephoneNumber"),
				(String) ldapObject.getAttributeValue("initials"),
				(String) ldapObject.getAttributeValue("generationQualifier"),
				(String) ldapObject.getAttributeValue("sAMAccountName"),
				(String) ldapObject.getAttributeValue("displayName"),
				(String) ldapObject.getAttributeValue("extensionAttribute6"),
				// TODO change this back when writing code to check user groups.
				// !userHasGroups.isEmpty());
				userHasGroups.isEmpty());
		if (userHasGroups.isEmpty()) {
			result.addErrorMessage("User is not a member of the allowed groups. The configured allowable groups for this kiosk are: "
					+ allowedGroups);
		}
		return result;
	}

	protected List<LdapObject> ldapSearch(int scope, String filter)
			throws AuthenticationException {

		// Initialize Search Results
		try {
			// Create the search controls
			SearchControls ldapSearchControls = new SearchControls();
			// Specify the attributes to return
			ldapSearchControls.setReturningAttributes(attributeList);
			// Specify the search scope
			ldapSearchControls.setSearchScope(scope);
			// Run the search
			NamingEnumeration<SearchResult> answer = ldapCtx.search(
					ldapNamingContext, filter, ldapSearchControls);
			// Transform the search results to a list of ldapObjects
			List<LdapObject> queryResults = ldapObjectMapper
					.createLdapObjectList(answer);
			// Close Search Result
			answer.close();
			return queryResults;
		} catch (Exception e) {
			logger.error("ldapSearch: Operation Failed.", e);
			return null;
		}
	}

	protected Hashtable<Object, Object> initLdapEnv(String aceId,
			String password) {
		String providerUrl;
		Hashtable<Object, Object> ldapEnv;

		providerUrl = ldapUrlResolver.getUrl(servers);
		if (providerUrl == null) {
			logger.error("Unable to initialize LDAP environment; no available servers.");
			return null;
		}
		ldapEnv = new Hashtable<Object, Object>();
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		ldapEnv.put(Context.SECURITY_PRINCIPAL, ldapDomain + "\\" + aceId);
		ldapEnv.put(Context.SECURITY_CREDENTIALS, password);
		ldapEnv.put(Context.PROVIDER_URL, providerUrl);

		// specify use of ssl socket with custom socket factory if required
		if (providerUrl.toLowerCase().endsWith(":636")) {
			ldapEnv.put("java.naming.ldap.factory.socket",
					CustomSocketFactory.class.getName());
		}

		return ldapEnv;
	}

	public LdapUrlResolver getLdapUrlResolver() {
		return ldapUrlResolver;
	}

	public void setLdapUrlResolver(LdapUrlResolver ldapUrlResolver) {
		this.ldapUrlResolver = ldapUrlResolver;
	}

	public LdapContext getLdapCtx() {
		return ldapCtx;
	}

	public void setLdapCtx(LdapContext ldapCtx) {
		this.ldapCtx = ldapCtx;
	}

	public LdapObjectMapper getLdapObjectMapper() {
		return ldapObjectMapper;
	}

	public void setLdapObjectMapper(LdapObjectMapper ldapObjectMapper) {
		this.ldapObjectMapper = ldapObjectMapper;
	}
}
