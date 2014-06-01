<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
   	// Configure expand/collapse func from default.js
   	//sayHello();
   	//logHello();
   	setupOpenClose();
   	setTitle("${project.name} | Conor Sloan");
</script>  


    
  
<h1>${project.name}</h1>

<img src="<c:url value="${project.largeIconLink}"/>" width="100%"/>	

<br><br>

<div onClick="openClose('p1')" style="cursor:hand; cursor:pointer"><h3>Project Description</h3></div>
<div id="p1" class="texter">
<p>${project.longDescription}</p>
<br>
</div>

<div onClick="openClose('p2')" style="cursor:hand; cursor:pointer"><h3>Technologies Used</h3></div>
<div id="p2" class="texter">
<p>${project.techUsed}</p>
<br>
</div>

<div onClick="openClose('p3')" style="cursor:hand; cursor:pointer"><h3>Project Repository Link</h3></div>
<div id="p3" class="texter">
<p><a href="${project.repoLink}">${project.name} Repository</a></p>
</div>