<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="section">
			<h1>Contact Me</h1>
			<p>
				Please feel free to leave a message for me in the box below!
			</p>
			<spring:url value='/contact/addMessage' var="add_message_url" />
			<form:form method="post" action="${add_message_url}" modelAttribute="message" class="message">
				<form:input path="name" />
				<form:input path="email" />
				<form:input path="subject" />
				<form:textarea path="message"/>
				<input type="submit" value="Send"/>
			</form:form>
		</div>
		<div class="section contact">
			<p>
				For Inquiries Please Call: <span>07769155568</span>
			</p>
			<p>
				Or you can email me at: <span><a href="mailto:c.sloan7597@googlemail.com" style="text-decoration:none;">c.sloan7597<br>@googlemail.com</a></span>
			</p>
		</div>