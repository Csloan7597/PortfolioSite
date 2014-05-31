<!--   <tiles:insertDefinition name="staticview">
        <tiles:putAttribute name="title"> 
            ${title} <%--OR, <s:property value="title"/>--%>
        </tiles:putAttribute>
        <%--Remainning content--%>
    </tiles:insertDefinition> -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<h1>${project.name}</h1>

<img src="<c:url value="${project.largeIconLink}"/>" width="100%"/>	
<br><br>
<p>${project.longDescription}</p>
<br><br>
<p><b>Technologies Used:</b> ${project.techUsed}</p>
<br><br>
This project can be found at the following link: <a href="${project.repoLink}">${project.name} Repository</a>