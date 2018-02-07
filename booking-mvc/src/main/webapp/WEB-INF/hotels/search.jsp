<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertAttribute name="searchForm" />

<c:if test="${not empty confirmed}">
	<div class="confirmed">${confirmed}</div>
</c:if>

<tiles:insertAttribute name="bookingsTable" />
