package com.crgt.innov2015.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
	public void getGuestStartPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("username", "Guest");
		response.sendRedirect("../gocloud-flow");
	}

	public Event validateAnswer(GoCloudAnswers answerForm, HttpSession session) {
		String qNumber = answerForm.getQuestionNumber();
		if (!StringUtils.isEmpty(qNumber)) {
			int questionNumber = new Integer(
					qNumber.substring(qNumber.length() - 1));
			session.setAttribute("divNum", questionNumber + 1);
		} else {
			session.setAttribute("divNum", "");
		}
		return new EventFactorySupport().success(this);
	}

	public Event goPreviousQuestion(GoCloudAnswers answerForm, HttpSession session) {
		String qNumber = answerForm.getQuestionNumber();
		if (!StringUtils.isEmpty(qNumber)) {
			int questionNumber = new Integer(
					qNumber.substring(qNumber.length() - 1));
			if(questionNumber - 1 > 0) {
				session.setAttribute("divNum", questionNumber - 1);
			} else {
				session.setAttribute("divNum", 1);
			}
		} else {
			session.setAttribute("divNum", "");
		}
		return new EventFactorySupport().success(this);
	}

}
