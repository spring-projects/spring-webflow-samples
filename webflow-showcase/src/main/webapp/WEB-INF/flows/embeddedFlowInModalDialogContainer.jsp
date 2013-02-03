<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h2 class="alt">Flow In a Modal Dialog</h2>
	<h4 class="alt"><a href="<c:url value="/"/>">Home</a></h4>
	<hr>
	<c:if test="${param.result eq 'success'}">
		<p class="success">Flow completed with success!</p>
	</c:if>
	<c:if test="${param.result eq 'cancel'}">
		<p class="error">Flow ended with cancellation!</p>
	</c:if>
	<div>
		<p>
		<h4><a id="startFlow" href="embedded-flow-in-modal-dialog">Launch Flow</a></h4>
		<script type="text/javascript">
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:"startFlow",event:"onclick",popup:true,params:{fragments:"body",mode:"embedded"}}));
		</script>
		</p>
	</div>
</div>