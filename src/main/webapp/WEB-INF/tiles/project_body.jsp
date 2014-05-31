<!--   <tiles:insertDefinition name="staticview">
        <tiles:putAttribute name="title"> 
            ${title} <%--OR, <s:property value="title"/>--%>
        </tiles:putAttribute>
        <%--Remainning content--%>
    </tiles:insertDefinition> -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<h1>${project.name}</h1>

<img src="<c:url value="${project.largeIconLink}"/>" width="100%"/>	
<br>
<h3>Project Description</h3>
<p>${project.longDescription}</p>
<br>
<h3>Technologies Used:</h3> 
<p>${project.techUsed}</p>
<br>
<h3>Project Repository Link</h3>
<p><a href="${project.repoLink}">${project.name} Repository</a></p>