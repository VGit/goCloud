package com.crgt.innov2015.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cloudSelect")
public class CloudSelectController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainChooseCloud(Model model, HttpSession session) {
		return "chooseCloud";
	}

}
