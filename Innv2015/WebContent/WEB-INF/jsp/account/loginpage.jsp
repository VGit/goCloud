<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
body {
	background-color: #f3f1f1;
}

.envelope {
	background-image: url("${contextPath}/resources/images/redbluepattern.png")
}
</style>



<div class="row">
	<div class="col-md-6" style="display: none;">
		<div id="login-box">
			<div class="envelope">
				<div class="envelope-inner">
					Welcome to our application!! If you would like to check if your
					application is ready for cloud <a href="${contextPath}/guest/start">Click
						Here to get started</a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div id="login-box">
			<div class="envelope">
				<div class="envelope-inner">
					<div class="logos">Existing User? Login to deploy your
						application.</div>

					<%-- ERROR --%>
					<c:if test="${not empty error}">
						<p class="alert alert-danger">
							${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
					</c:if>

					<form tabindex="1" action="${contextPath}/auth/validate"
						method="post" id="loginForm" name="loginForm">


						<%-- USERNAME --%>
						<div tabindex="1" class="input-icon-group">
							<input type="text" class="form-control" id="username"
								placeholder="User Name" name="j_username" required /> <label
								for="username" class="sr-only">User Name Input</label> <i
								class="fa fa-user"></i>
						</div>
						<br>
						<%-- PASSWORD --%>
						<div tabindex="2" class="input-icon-group">
							<input type="password" class="form-control" id="password"
								name="j_password" placeholder="Password" required /> <label
								for="password" class="sr-only">Password Input</label> <i
								class="fa fa-key"></i>
						</div>
						<br>
						<%-- SUBMIT BUTTON ROW --%>
						<div class="clearfix" tabindex="3">
							<input type="submit" value="Login"
								class="pull-right btn btn-primary" id="loginBtn"> <a
								id="forgotPass" href="#" target="_blank">Forgot <br>
								your password?
							</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div id="login-box">
			<div class="envelope">
				<div class="envelope-inner" style="height: 300">
					<span id="signinButton"> <span class="g-signin"
						data-callback="signinCallback"
						data-clientid="116811876349-f8aucthc9lcs3kc620mosqk08j5s59cl.apps.googleusercontent.com"
						data-cookiepolicy="single_host_origin"
						data-requestvisibleactions="http://schema.org/AddAction"
						data-scope="https://www.googleapis.com/auth/plus.login"> </span>
					</span> <br>
					<br> <a href="${contextPath}/dashboard"> <img
						src="${contextPath}/resources/images/loginwithfb.png" height="33"
						width="204" />
					</a> <br> <br>
					<a href="${contextPath}/dashboard"> <img
						src="${contextPath}/resources/images/loginwithamazon.png"
						height="32" width="204" />
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://apis.google.com/js/client:platform.js" async defer></script>
<script src="${contextPath}/resources/js/lib/jquery.placeholder.js"></script>
<script>
	var isLoginPage = true;

	$(function() {
		$('input').placeholder();
		/*
		$('#loginForm').on('submit',function(e){
			if(this.j_password.value.trim().length == 0){
				e.preventDefault();
				$('.alert').html('Please fill out Password field.');
			}
		});*/

		document.loginForm.j_username.focus();
	});

	function signinCallback(authResult) {
		if (authResult['status']['signed_in']) {
			// Update the app to reflect a signed in user
			// Hide the sign-in button now that the user is authorized, for example:
			/* document.getElementById('signinButton').setAttribute('style',
					'display: none'); */
		} else {
			// Update the app to reflect a signed out user
			// Possible error values:
			//   "user_signed_out" - User is signed-out
			//   "access_denied" - User denied access to your app
			//   "immediate_failed" - Could not automatically log in the user
			console.log('Sign-in state: ' + authResult['error']);
		}
	}
</script>

