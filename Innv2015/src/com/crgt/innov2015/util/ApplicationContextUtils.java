package com.crgt.innov2015.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils implements ApplicationContextAware {
	
	private  final static Logger logger = LoggerFactory.getLogger("ApplicationContextUtils");
	 
	  private static ApplicationContext ctx;
	 
	  @Override
	  public void setApplicationContext(ApplicationContext appContext)
	      throws BeansException {
	    ctx = appContext;
	    try {
	    	Constants.EXECUTION_ENVIRONMENT = "local";
	    } catch (Exception e){
	    	logger.error("EXECUTION_ENVIRONMENT not properly configured on appserver, com.crgt.env not defined.  Defaulting to DEV.");
	    	Constants.EXECUTION_ENVIRONMENT = Constants.EXECUTION_ENVIRONMENT_DEV;
	    }
	  }
	 
	  public static ApplicationContext getApplicationContext() {
	    return ctx;
	  }
	}