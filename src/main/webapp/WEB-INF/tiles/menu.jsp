<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<img src="<c:url value="/resources/images/menu_line.jpg"/>" />

<div id = "menu-wrapper">
<spring:url value='/' var="home_url" />
<a href="${home_url}"><img src="<c:url value="/resources/images/home.jpg"/>" /></a>
<img src="<c:url value="/resources/images/separator.jpg"/>" />
<spring:url value='/about' var="about_url" />
<a href="${about_url}"><img src="<c:url value="/resources/images/about_me.jpg"/>" /></a>
<img src="<c:url value="/resources/images/separator.jpg"/>" />
<spring:url value='/projects' var="projects_url" />
<a href="${projects_url}"><img src="<c:url value="/resources/images/projects.jpg"/>" /></a>
<img src="<c:url value="/resources/images/separator.jpg"/>" />
<spring:url value='/contact' var="contact_url" />
<a href="${contact_url}"><img src="<c:url value="/resources/images/contact.jpg"/>" /></a>
</div>

<img src="<c:url value="/resources/images/menu_line.jpg"/>" />