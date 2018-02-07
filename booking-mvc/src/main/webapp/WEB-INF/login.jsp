<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="span-5">
	<p>Valid username/passwords are:</p>
	<ul>
		<li>keith/melbourne</li>
		<li>erwin/leuven</li>
		<li>jeremy/atlanta</li>
		<li>scott/rochester</li>
	</ul>
</div>

<div class="span-10 append-2 last">
	<c:if test="${not empty param.login_error}">
		<div class="error">
			Your login attempt was not successful, try again.
		</div>
	</c:if>
	<form name="f" action="<c:url value="/loginProcess" />" method="post">
		<fieldset>
			<legend>Login Information</legend>
			<p>
				<label for="username">User:</label>
				<br />
				<input type="text" name="username" id="username" />
			</p>
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ElementDecoration({
					elementId : "username",
					widgetType : "dijit.form.ValidationTextBox",
					widgetAttrs : { required : true }}));
			</script>
			<p>
				<label for="password">Password:</label>
				<br />
				<input type="password" name="password" id="password" />
			</p>
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ElementDecoration({
					elementId : "password",
					widgetType : "dijit.form.ValidationTextBox",
					widgetAttrs : { required : true}}));
			</script>
			<p>
				<input type="checkbox" name="_spring_security_remember_me" id="remember_me" />
				<label for="remember_me">Don't ask for my password for two weeks:</label>
			</p>
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ElementDecoration({
					elementId : "remember_me",
					widgetType : "dijit.form.CheckBox"}));
			</script>
			<div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</div>
			<p>
				<button id="submit" type="submit">Login</button>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
				</script>
			</p>
		</fieldset>
	</form>
</div>
