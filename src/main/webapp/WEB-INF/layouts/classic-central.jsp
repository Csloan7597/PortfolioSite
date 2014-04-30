<!DOCTYPE HTML>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true"/></title>  
  		<tiles:importAttribute name="css" /> 
  		<link href="<c:url value="${css}"/>" rel="stylesheet" type="text/css" /> 
  		<tiles:importAttribute name="script" /> 
  		<script type="text/javascript" src="<c:url value="${script}"/>"></script> 
    </head>
    <body>
    <div id = "center-wrapper">
        <div id="header">
            <tiles:insertAttribute name="header" />
        </div>
        <div></div>
        <tiles:insertAttribute name="menu" />
        <div></div>
        <div id="page">
            <tiles:insertAttribute name="body" />
        </div>
        <div></div>
        <div id="footer_wrapper">
            <tiles:insertAttribute name="footer" />
        </div>
    </div>
    </body>
</html>