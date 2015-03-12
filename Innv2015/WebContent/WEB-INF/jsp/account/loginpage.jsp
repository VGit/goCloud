<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
body {
	background-color: #f3f1f1;
}
</style>



<div class="row">
	<div class="col-md-6">
		<div id="login-box">
			<div class="envelope">
				<div class="envelope-inner">
					Welcome to our application!! If you would like to check if your
					application is ready for cloud <a href="${contextPath}/guest/start">Click Here to get started</a>
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
</div>

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
</script>

