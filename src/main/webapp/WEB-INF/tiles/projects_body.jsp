<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${projects}" var="project">     
   
   Project Name: <c:out value="${project.name}"/>
   Project Description: <c:out value="${project.description}"/>
   <spring:url value='/projects/${project.id}' var="project_url" />
   Link: <a href="${project_url}">${project.name}</a>
   <br><br>
</c:forEach>