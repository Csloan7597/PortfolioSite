<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Projects</h1>

<c:forEach items="${projects}" var="project">

	<div class="block" width="100%">       
		<div class="section">
		   <h2><c:out value="${project.name}"/></h2>
		   <p><c:out value="${project.shortDescription}"/></p>
		   <spring:url value='/projects/${project.id}' var="project_url" />
		   Link: <a href="${project_url}">${project.name}</a>
		</div>
		<div class="section">
		<img src="<c:url value="${project.smallIconLink}"/>" width="100%"/>	
		</div><br><br>
 	</div>
	<br><br>
</c:forEach>