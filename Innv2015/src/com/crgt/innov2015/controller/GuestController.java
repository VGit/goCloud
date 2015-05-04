package com.crgt.innov2015.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import com.crgt.innov2015.model.GoCloudAnswers;
import com.crgt.innov2015.util.Constants;
import com.crgt.innov2015.util.Pair;

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
		response.sendRedirect("../gocloud-flow");
	}

	public Event validateAnswer(GoCloudAnswers answerForm, HttpSession session) {
		String qNumber = answerForm.getQuestionNumber();
		if (!StringUtils.isEmpty(qNumber)) {
			setValueInSession(answerForm, session);
			int questionNumber = new Integer(
					qNumber.substring(qNumber.length() - 1));
			if (questionNumber == 1 || questionNumber == 2
					|| questionNumber == 3) {
				if (Constants.NO.equalsIgnoreCase(answerForm.getYesNoRadio())) {
					session.setAttribute("decisionval", "internalIT");
					session.setAttribute("cloudChoice", "Internal IT");
					return new Event(this, "summary");
				}
			}
			if (questionNumber == 4 || questionNumber == 5) {
				if (Constants.YES.equalsIgnoreCase(answerForm.getYesNoRadio())) {
					session.setAttribute("cloudChoice", "Internal IT");
					session.setAttribute("decisionval", "internalIT");
					return new Event(this, "summary");
				}
			}

			if (questionNumber == 7) {
				if (Constants.NO.equalsIgnoreCase(answerForm.getYesNoRadio())) {
					session.setAttribute("cloudChoice", "Managed Services");
					session.setAttribute("decisionval", "managedServices");
					return new Event(this, "summary");
				}
			}

			if (questionNumber == 8) {
				if (Constants.NO.equalsIgnoreCase(answerForm.getYesNoRadio())) {
					session.setAttribute("cloudChoice", "Colocation");
					session.setAttribute("decisionval", "colocation");
					return new Event(this, "summary");
				}
			}

			if (questionNumber == 9) {
				if (Constants.YES.equalsIgnoreCase(answerForm.getYesNoRadio())) {
					session.setAttribute("cloudChoice", "Colocation");
					session.setAttribute("decisionval", "colocation");
					return new Event(this, "summary");
				}
				if (Constants.NO.equalsIgnoreCase(answerForm.getYesNoRadio())) {
					session.setAttribute("cloudChoice", "Public Cloud");
					session.setAttribute("decisionval", "publiccloud");
					return new Event(this, "summary");
				}
			}
			if (questionNumber == 6 || questionNumber == 7) {
				if (Constants.YES.equalsIgnoreCase(answerForm.getYesNoRadio())) {
					session.setAttribute("divNum", 8);
				} else {
					session.setAttribute("divNum", questionNumber + 1);
				}
			} else {
				session.setAttribute("divNum", questionNumber + 1);
			}
		} else {
			session.setAttribute("divNum", "");
		}
		return new EventFactorySupport().success(this);

	}

	private void setValueInSession(GoCloudAnswers answerForm,
			HttpSession session) {
		Map<String, Pair<String, String>> questionAnswerMap = (Map<String, Pair<String, String>>) session
				.getAttribute("questionAnswerMap");
		if (null == questionAnswerMap) {
			questionAnswerMap = new TreeMap<String, Pair<String, String>>();
		}
		Pair<String, String> qAndA = new Pair<String, String>(
				Constants.QUESTION_MAP.get(answerForm.getQuestionNumber()),
				answerForm.getYesNoRadio());
		questionAnswerMap.put(answerForm.getQuestionNumber(), qAndA);

		session.setAttribute("questionAnswerMap", questionAnswerMap);
	}

	public Event goPreviousQuestion(GoCloudAnswers answerForm,
			HttpSession session) {
		String qNumber = answerForm.getQuestionNumber();
		if (!StringUtils.isEmpty(qNumber)) {
			int questionNumber = new Integer(
					qNumber.substring(qNumber.length() - 1));
			if (questionNumber - 1 > 0) {
				session.setAttribute("divNum", questionNumber - 1);
			} else {
				session.setAttribute("divNum", 1);
			}
		} else {
			session.setAttribute("divNum", "");
		}
		return new EventFactorySupport().success(this);
	}

	@RequestMapping(value = "/decisionsummary", method = RequestMethod.GET)
	public String gotoDecisionSummary(ModelMap model, HttpSession session) {
		Map<String, Pair<String, String>> questionAnswerMap = (Map<String, Pair<String, String>>) session
				.getAttribute("questionAnswerMap");
		if (null == questionAnswerMap) {
			return "loginpage";
		}
		model.put("decision", session.getAttribute("decisionval"));
		return "summary";
	}

}
