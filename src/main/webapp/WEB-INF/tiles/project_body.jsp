<!--   <tiles:insertDefinition name="staticview">
        <tiles:putAttribute name="title"> 
            ${title} <%--OR, <s:property value="title"/>--%>
        </tiles:putAttribute>
        <%--Remainning content--%>
    </tiles:insertDefinition> -->
    
   
<h1>${project.name}</h1>

<img src="<c:url value="${project.largeIconLink}"/>" width="100%"/>	

<p>${project.longDescription}</p>