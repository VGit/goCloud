$(document).ready(function() {
//	$('#migrateBtn').on('click',function(e){
//		migrateToCloud();
//	});
});

// function loadJsonToJavascriptObject() {
// var data = JSON.parse(jsonText);
//
// for (key in data) {
// if (data.hasOwnProperty(key)) {
// var value = data[key];
// alert(value);
// }
// }
// }

function migrateToCloud() {
	var urlString = "https://gocloud.ci.cloudbees.com/buildByToken/buildWithParameters?";
	var jobName = $('#appName').val();
	var s3bucket = "itsa-test";
	var token = "BAEBAE";
	var userEmail = $('#clientEmail').val();
	var gitURL = $('#gitURL').val();
//validate all values
	
//	urlString = urlString+"job="+jobName+"&token="+token+"&S3bucket="+s3bucket;
	urlString="https://gocloud.ci.cloudbees.com/buildByToken/buildWithParameters?job=AwsCloud&token=ILIKECOFFEE&S3bucket=itsa-test";
	alert(urlString);
	$.ajax({
		url : urlString,
		type : "GET",
		contentType : "application/json",
		success : function(data) {
			$('#migrateBtn').prop("enabled",false);
			var html = getFeedbackHtml();
			$('#feedbackDiv > p').html(html).show();
		}
	});
	
	function getFeedbackHtml() {
		var html = $('#feedbackTemplate').html();
		var settings = {
			"CLOUD_NAME" : "AWS",
			"CONFIRMATION_NUMBER" : Math.floor((Math.random() * 1000000) + 1)
		};
		html = createHTMLFromTemplate(html, settings);
		return html;
	}
}
