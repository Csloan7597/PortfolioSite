<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value='/home' var="home_url" />
<% response.sendRedirect(${home_url}); %>

TEST