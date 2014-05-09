<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value='/home' var="home_url" />
<jsp:forward page="${home_url}" />

TEST