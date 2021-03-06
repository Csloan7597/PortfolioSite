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
			
			<% boolean messageSent = (Boolean)request.getAttribute("messageSent"); 
			  //out.println("MESSAGE SENT? "+messageSent);
			  //out.println("ERROR?"+(request.getAttribute("errorMessage") != null));
			  if(messageSent) {%>
			   <font color="green">Thank you - your message was sent successfully!</font> 
			  <% } else if(request.getAttribute("errorMessage") != null) { %>
			  <font" color="red">There was an error processing your message:  ${messageError} </font> <% } %>
			  
		</div>
		<div class="section contact">
			<p>
				For Inquiries Please Call: <span><a href="tel:07769155568" style="text-decoration:none;">07769155568</a></span>
			</p>
			<p>
				Or you can email me at: <span><a href="mailto:c.sloan7597@googlemail.com" style="text-decoration:none;">c.sloan7597<br>@googlemail.com</a></span>
			</p>
		</div>