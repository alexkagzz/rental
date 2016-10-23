<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<tiles:insertAttribute name="head" />
<body>
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
		
	<tiles:insertAttribute name="menu" />
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/protected/home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active"><tiles:getAsString name="title"/></li>
			</ol>
		</div><!--/.row-->
		
		
		
		<tiles:insertAttribute name="body" />
		
		<!--/.row-->
	</div>	<!--/.main-->

	
</body>

</html>