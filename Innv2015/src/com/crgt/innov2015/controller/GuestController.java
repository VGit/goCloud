package com.crgt.innov2015.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import com.crgt.innov2015.model.GoCloudAnswers;

@Controller
@RequestMapping("/guest")
public class GuestController {
	/**
	 * Retrieves the login page
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public void getGuestStartPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.getSession().setAttribute("username", "Guest");
		response.sendRedirect("../gocloud-flow");
	}

	public Event validateAnswer(GoCloudAnswers answerForm, HttpSession session) {
		if ("q1".equalsIgnoreCase(answerForm.getQuestionNumber())) {
			session.setAttribute("divNum", 2);
		} else if ("q2".equalsIgnoreCase(answerForm.getQuestionNumber())) {
			session.setAttribute("divNum", 3);
		} else if ("q3".equalsIgnoreCase(answerForm.getQuestionNumber())) {
			session.setAttribute("divNum", 4);
		} else if ("q4".equalsIgnoreCase(answerForm.getQuestionNumber())) {
			session.setAttribute("divNum", "");
		}
		return new EventFactorySupport().success(this);
	}

	public Event goPreviousQuestion() {

		return new EventFactorySupport().success(this);
	}

}
