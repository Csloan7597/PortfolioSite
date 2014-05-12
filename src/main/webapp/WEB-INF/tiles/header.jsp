<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div>
			<%
			// TODO: Clean this up - gets current URL to highlight the correct page
			String url = request.getRequestURL().toString();
			String[] parts = url.split("/");
			String lastPart = parts[parts.length-1];
			lastPart = lastPart.substring(0, lastPart.length()-4);
			%>

			<div class="logo">
				<spring:url value='/home' var="home_url" />
				<a href="${home_url}"></a>
			</div>
			<ul id="navigation">
				<li <% if(lastPart.equals("home")) { %> class="active" <%}%>>
					
					<a href="${home_url}">Home</a>
				</li>
				<li <% if(lastPart.equals("about")) { %> class="active" <%}%>>
					<spring:url value='/about' var="about_url" />
					<a href="${about_url}">About Me</a>
				</li>
				<li <% if(lastPart.equals("projects") || lastPart.equals("project")) { %> class="active" <%}%>>
					<spring:url value='/projects' var="projects_url" />
					<a href="${projects_url}">Projects</a>
				</li>
				<li <% if(lastPart.equals("cv")) { %> class="active" <%}%>>
					<spring:url value='/cv' var="cv_url" />
					<a href="${cv_url}">CV</a>
				</li>
				<li <% if(lastPart.equals("contact")) { %> class="active" <%}%>>
					<spring:url value='/contact' var="contact_url" />
					<a href="${contact_url}">Contact</a>
				</li>
				<li> 
					<a href="http://blog.conorsloan.co.uk">Blog</a>
				</li>
			</ul>
		</div>
		
		
		
	