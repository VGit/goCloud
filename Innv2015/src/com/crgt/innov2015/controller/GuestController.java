package com.crgt.innov2015.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/guest")
public class GuestController {
	/**
	 * Retrieves the login page
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String getGuestStartPage() {
		return "qStart";
	}

}
