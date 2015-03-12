jQuery.validator.addMethod("exactlength", function(value, element, param) {
 return this.optional(element) || value.length == param;
}, jQuery.validator.format("Please enter exactly {0} characters."));


jQuery.validator.addMethod("selectedOptionsLengthCheck", function(value, element, param) {
	 return this.optional(element) || parseInt(param) > value.length ;
}, jQuery.validator.format("Maximum selected values should be under {0}."));

