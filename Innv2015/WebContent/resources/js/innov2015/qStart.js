$(document).ready(function() {
	hideShowDiv();
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

function hideShowDiv() {
	$('div.qDiv').hide();
	if (divNum) {
		$('#div_' + divNum).show();
	} else {
		$('#div_1').show();
	}
}
