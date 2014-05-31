<!--   <tiles:insertDefinition name="staticview">
        <tiles:putAttribute name="title"> 
            ${title} <%--OR, <s:property value="title"/>--%>
        </tiles:putAttribute>
        <%--Remainning content--%>
    </tiles:insertDefinition> -->
    
<script type="text/javascript">
   	// Configure expand/collapse func from default.js
   	setupOpenClose();
</script>    
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<h1>${project.name}</h1>

<img src="<c:url value="${project.largeIconLink}"/>" width="100%"/>	
<br><br>

<div onClick="openClose('a1')" style="cursor:hand; cursor:pointer"><h3>Project Description</h3></div>
<div id="a1" class="texter">
<p>${project.longDescription}</p>
<br>
</div>

<div onClick="openClose('a2')" style="cursor:hand; cursor:pointer"><h3>Technologies Used:</h3></div>
<div id="a2" class="texter">
<p>${project.techUsed}</p>
<br>
</div>

<div onClick="openClose('a3')" style="cursor:hand; cursor:pointer"><h3>Project Repository Link</h3></div>
<div id="a3" class="texter">
<p><a href="${project.repoLink}">${project.name} Repository</a></p>
</div>