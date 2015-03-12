package com.crgt.innov2015.security.ldap;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

import javax.net.SocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LdapUrlResolver {
	private static final Logger logger = LoggerFactory.getLogger(LdapUrlResolver.class);
	
	SocketFactory ldapSocketFactory;
    public LdapUrlResolver(SocketFactory ldapSocketFactory){
    	this.ldapSocketFactory=ldapSocketFactory;
    } 
    public LdapUrlResolver() {
    	ldapSocketFactory=SocketFactory.getDefault();
    }
    
    
	public String getUrl(List<String> servers){
		 String returnedUrl = null;

	        for (String hostname : servers) {
	            try {
	                // Create new tcp/ip socket
	            	
	                Socket ldapSocket = ldapSocketFactory.createSocket();
	                // Bind to a local ephemeral port
	                ldapSocket.bind(null);
	                // Connect to host and port with a timeout of 500 milliseconds
	                ldapSocket.connect(new InetSocketAddress(hostname, 636), 500);
	                // Close the connection
	                ldapSocket.close();
	                // If no exceptions are thrown, then use the URL
	                returnedUrl = "ldap://" + hostname + ":636";
	                break;
	            } catch (Exception e) {
	                logger.error("Unable to connect to socket: " + hostname + '.');
	            }
	        }
	        logger.info("Authenticating with URL: " + returnedUrl);
	        return returnedUrl;
	}

}
