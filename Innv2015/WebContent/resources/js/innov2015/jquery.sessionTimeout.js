(function( $ ){

	$.landingRefresh = function(homePage, pageRefresh){
		var pageRefreshIn = (pageRefresh != null) ?  pageRefresh : 60*60; 
		
		$.idleTimeout($.noop(), $.noop(),{
			idleAfter: 			pageRefreshIn,
			pollingInterval: 	1,
			failedRequests:		5,
			onIdle: 			function(){
									window.location = homePage;
								}
		}); // end idleTimeout
	}; // end landingRefresh
	//$.sessionTimeout = function(splashPage, homePage, flowStage, pageTimeOut, popupTimeOut) {
	$.sessionTimeout = function(splashPage, homePage, flowStage, pageTimeOut, popupTimeOut) {
	//$.sessionTimeout = function() {
	
		// customize the dialog box and the message (including the countdown) in sfswebtemplate.jsp #sessionTimeout-dialog
		
		// setup the duration of idleAfter
		//60 secs is the set default for timeoutPage, and can be overridden if pageTimeOut is initialized
		var timeoutPage = (pageTimeOut != null) ?  pageTimeOut : 10; 
		
		//30 secs is the set default for timeoutPopup, and can be overridden if popupTimeOut is initialized
		var timeoutPopup = (popupTimeOut != null) ? popupTimeOut : 3; 
		
		// setup the dialog box
		
		// if (flowStage){
		if (false){
			/*$("#sessionTimeout-dialog").dialog({
				autoOpen: false,
				modal: true,
				width: 450,
				height: 225,
				closeOnEscape: false,
				draggable: false,
				resizable: false,
				buttons: {
					'Yes, Stay on this page': function(){
						$(this).dialog('close');
					}
				}
			});*/
		}
		else {
			/*$("#sessionTimeout-dialog").dialog({
				autoOpen: false,
				modal: true,
				width: 450,
				height: 225,
				closeOnEscape: false,
				draggable: false,
				resizable: false,
				buttons: {
					'Yes, Stay on this page': function(){
						$(this).dialog('close');
					},
					'Return to Home Page': function(){
						$.idleTimeout.options.onBackToHome.call(this);
					}
				}
			});*/
		}
	
	// cache a reference to the countdown element so we don't have to query the DOM for it on each ping.
	var $countdown = $("#dialog-countdown");
	
	// start the idle timer plugin
		$.idleTimeout('#sessionTimeout-dialog', '#sessionTimeout-resume', {
				
				idleAfter: 			timeoutPopup, // in seconds, when the dialog warning appears
				warningLength: 		timeoutPage-timeoutPopup, // in seconds, how much time under redirect
				pollingInterval: 	1,
				//keepAliveURL: 		'#',
				serverResponseEquals: 'OK',
				failedRequests:		5,
				onTimeout: 			function(){ //fires when your session times out
										window.location = homePage;
									},
				onBackToHome:		function(){
										window.location = homePage;
									},								
				onIdle: 			function(){ //fired when you warn that they've been idle before redirect
										$(this).modal("show");
									},
				onCountdown: 		function(counter){
										$countdown.html(counter); // update the counter
									}
			}); // end idleTimeout

	
	}; // end sessionTimeout
})( jQuery );