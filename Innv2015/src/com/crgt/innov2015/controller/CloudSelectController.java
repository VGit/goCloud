package com.crgt.innov2015.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import oracle.sql.DATE;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.crgt.innov2015.model.BuildParams;

@Controller
@RequestMapping("/cloudSelect")
public class CloudSelectController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainChooseCloud(Model model, HttpSession session) {
		return "chooseCloud";
	}

	@RequestMapping(value = "/getMigrateParam", method = RequestMethod.GET)
	public String getMigrateParam(Model model, HttpSession session) {
		return "migrate";
	}

	@RequestMapping(value = "/migrateApp", method = RequestMethod.POST)
	public void kickOffbuildInJenkins(BuildParams buildParams,
			HttpSession session) throws SQLException {
		final String uri = "https://gocloud.ci.cloudbees.com/buildByToken/buildWithParameters?job={job}&token={token}&S3bucket={bucket}&email={email}&StackName={stackName}";

		// Map<String, String> params = new HashMap<String, String>();
		// params.put("job", "AwsCloud");
		// params.put("token", "ILIKECOFFEE");
		// params.put("S3bucket", "innov2015");
		// params.put("email", buildParams.getUserEmail());
		// if (StringUtils.isEmpty(buildParams.getStackName())) {
		// params.put("stackname",
		// buildParams.getAppName() + DATE.getCurrentDate());
		// } else {
		// params.put("stackname", buildParams.getStackName());
		// }
		String job = "AwsCloud";
		String token = "ILIKECOFFEE";
		String S3bucket = "innov2015";
		String stackName, email = "";

		if (StringUtils.isEmpty(buildParams.getStackName())) {
			stackName = buildParams.getAppName() + DATE.getCurrentDate();
		} else {
			stackName = buildParams.getStackName();
		}
		if (StringUtils.isEmpty(buildParams.getUserEmail())) {
			email = "madhu.vattipulusu@gmail.com";
		} else {
			email = buildParams.getUserEmail();
		}
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class, job,
				token, S3bucket, email, stackName);

		System.out.println(result);
	}

	public static void main(String[] args) throws Exception {
		CloudSelectController cc = new CloudSelectController();
		BuildParams bb = new BuildParams();
		bb.setUserEmail("VATTIPULUSU@GMAIL.COM");
		bb.setStackName("cloud-stack-aws");
		cc.kickOffbuildInJenkins(bb, null);
	}

}
