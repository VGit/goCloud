package com.crgt.innov2015.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author tsilpa
 * 
 */
@Controller
@RequestMapping("/")
public class HomeController {

	final static Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String linkToDashboard(Model model, HttpSession session) {
		return "dashboard";
	}
}
