package com.crgt.innov2015.controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.crgt.innov2015.model.BuildParams;
import com.crgt.innov2015.util.CspDataList;

@Controller
@RequestMapping("/cloudSelect")
public class CloudSelectController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainChooseCloud(ModelMap model, HttpSession session) {
		model.put("cspvoList", CspDataList.getCspData());
		return "chooseCloud";
	}

	@RequestMapping(value = "/getMigrateParam", method = RequestMethod.GET)
	public String getMigrateParam(ModelMap model, HttpSession session) {
		model.put("showfeedback", false);
		return "migrate";
	}

	@RequestMapping(value = "/migrateWebAppAWS", method = RequestMethod.POST)
	public String migrateWebAppAWS(BuildParams buildParams, ModelMap model,
			HttpSession session) throws SQLException {
//		https://gocloud.ci.cloudbees.com/buildByToken/buildWithParameters?job=AwsCloud&token=ILIKECOFFEE&giturl=https://github.com/mvattipulusu/guessgame&email=vattipulusu@gmail.com&S3bucket=innov2015&StackName=GoCloud1&ApplicationName=Web&EnvironmentName
		final String uri = "https://gocloud.ci.cloudbees.com/buildByToken/buildWithParameters?job={job}&token={token}&giturl=${giturl}&S3bucket={bucket}&email={email}&StackName={stackName}&ApplicationName={appname}&EnvironmentName={env}";

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
		String giturl = buildParams.getGitURL();
		String appName = buildParams.getAppName();
		String env = buildParams.getEnvironment();

		if (StringUtils.isEmpty(buildParams.getStackName())) {
			stackName = buildParams.getAppName()
					+ Calendar.getInstance().getTimeInMillis();
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
				token,giturl, S3bucket, email, stackName,appName,env);
		System.out.println("Result :" + result);
		Random random = new Random();
		int n = 100000 + Math.abs(random.nextInt() * 900000);
		model.put("buildparams", buildParams);
		model.put("cloudname", "Amazon Web Services");
		model.put("confirmNum", "AWS-"+n);
		model.put("apptype", "webapp");
		return "migratefeedback";
	}

	@RequestMapping(value = "/migrateDBAWS", method = RequestMethod.POST)
	public String migrateDBAWS(BuildParams buildParams, ModelMap model,
			HttpSession session) throws SQLException {

		// https://gocloud.ci.cloudbees.com/buildByToken/buildWithParameters?job=RDSJob&token=ILIKECOFFEE&DatabaseUser=admin&DatabasePassword=pwd&DatabaseName=db1&StackName=stkdb1
		final String uri = "https://gocloud.ci.cloudbees.com/buildByToken/buildWithParameters?job={job}&token={token}&DatabaseName={dbname}&DatabaseUser={dbuser}&DatabasePassword={dbpassword}&email={email}&StackName={stackName}";

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
		String job = "RDSJob";
		String token = "ILIKECOFFEE";
		String stackName, email = "";
		String dbname = buildParams.getDbname();
		String dbusername = buildParams.getDbusername();
		String dbpassword = buildParams.getDbpassword();

		if (StringUtils.isEmpty(buildParams.getStackName())) {
			stackName = buildParams.getAppName()
					+ Calendar.getInstance().getTimeInMillis();
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
				token, dbname, dbusername, dbpassword, email, stackName);
		System.out.println("Result :" + result);
		Random random = new Random();
		int n = 100000 + Math.abs(random.nextInt() * 900000);
		model.put("buildparams", buildParams);
		model.put("cloudname", "Amazon Web Services");
		model.put("confirmNum", "AWS-"+n);
		model.put("apptype", "dbapp");
		return "migratefeedback";
	}

	@RequestMapping(value = "/migrateWebAppCF", method = RequestMethod.POST)
	public String migrateWebAppCF(BuildParams buildParams, ModelMap model,
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
			stackName = buildParams.getAppName()
					+ Calendar.getInstance().getTimeInMillis();
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
		System.out.println("Result :" + result);
		Random random = new Random();
		int n = 100000 + Math.abs(random.nextInt() * 900000);
		model.put("buildparams", buildParams);
		model.put("cloudname", "Cloud Foundry");
		model.put("confirmNum", "CF-"+n);
		model.put("apptype", "webapp");
		return "migratefeedback";
	}

	public static void main(String[] args) throws Exception {
		CloudSelectController cc = new CloudSelectController();
		BuildParams bb = new BuildParams();
		bb.setUserEmail("VATTIPULUSU@GMAIL.COM");
		bb.setStackName("cloud-stack-aws");
		// cc.kickOffbuildInJenkins(bb, null);
	}

}
