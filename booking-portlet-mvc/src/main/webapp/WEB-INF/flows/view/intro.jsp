<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<h2>Welcome to Spring Travel</h2>
<p>
 	This reference application shows how to use Spring MVC and Web Flow together with JavaServerPages (JSP) in a portlet.
</p>
<p>
	The key features illustrated in this sample include:
</p>
<ul>
	<li>A declarative navigation model enabling full browser button support and dynamic navigation rules</li>
	<li>A fine-grained state management model, including support for ConversationScope and ViewScope</li>
	<li>Managed persistence contexts with the Java Persistence API (JPA)</li>
	<li>Unified Expression Language (EL) integration</li>
	<li>Declarative page authoring with JSP, JSTL, and Spring MVC's form tag library
	<li>Exception handling support across all layers of the application</li>
	<li>Spring IDE tooling integration, with support for graphical flow modeling and visualization</li>
</ul>
<p align="right">
	<portlet:actionURL var="actionUrl">
		<portlet:param name="execution" value="${flowExecutionKey}" />
		<portlet:param name="_eventId" value="main" />
	</portlet:actionURL>
	<a href="${actionUrl}">
		Start your Spring Travel experience
	</a>
</p>
