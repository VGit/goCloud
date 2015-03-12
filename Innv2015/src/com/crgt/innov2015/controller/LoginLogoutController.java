/**
 * 
 */
package com.crgt.innov2015.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crgt.innov2015.util.Constants;
import com.crgt.innov2015.util.LogBackConstants;

/**
 * Retrieves login related pages
 */
@Controller
@RequestMapping("/auth")
public class LoginLogoutController {

	protected static final Logger logger = LoggerFactory.getLogger("LoginLogoutController");

	/**
	 * Retrieves the login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {
		if (error == true) {
			model.put("error",
					"You have entered an invalid username or password");
		} else {
			model.put("error", "");
		}
		return "loginpage";
	}
	
	/**
	 * Retrieves the login page
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String authenticate(Model model, HttpServletRequest request) {
		String username = request.getParameter("j_username");
		String passwd = request.getParameter("j_password");
		if (Arrays.asList(Constants.usernames).contains(username)
				&& "passwd".equalsIgnoreCase(passwd)) {
			request.getSession().setAttribute("username", username);
			return "dashboard";
		} else
			return getDeniedPage();
	}
	
	/**
	 * Retrieves the denied page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {
		return Constants.DENIED_PAGE;
	}
	
	/**
	 * Retrieves the denied page
	 */
	@RequestMapping(value = "/sessionTimeOut", method = RequestMethod.GET)
	public String getSessiontimeOutPage() {
		return Constants.SESSION_EXPIRED_PAGE;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
		logger.info("Logging out user");
		HttpSession session = request.getSession();
		session.invalidate();
		SecurityContext secContext = SecurityContextHolder.getContext();
		secContext.setAuthentication(null);
		SecurityContextHolder.setContext(secContext);
		MDC.remove(LogBackConstants.USERID_MDC_KEY);
        MDC.remove(LogBackConstants.EMAIL_MDC_KEY);
        MDC.remove(LogBackConstants.ROLE_MDC_KEY);
		return "loginpage";
	}
}