
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

     
    <jsp:include page="./head.jsp"/>

<body>

    <div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in to <spring:message code='project.name'/></div>
				<div id="login-error" class="alert alert-danger alert-dismissible">
		            <spring:message code="login.invalid.username.or.password" />
		            </div>
				<div class="panel-body">
					 <form action="j_spring_security_check" method="post"  novalidate="novalidate" autocomplete="off">
						<fieldset>
							<div class="form-group">
								 <input type="text" class="form-control" placeholder="Username" name="j_username">
							</div>
							<div class="form-group">
								 <input type="password" class="form-control" placeholder="Password" name="j_password">
							</div>
							 <button type="submit" class="btn btn-primary"><spring:message code="login.signIn" /></button>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div>

   <script type="text/javascript" src="<c:url value="/js/modules/login/login.js"/>"></script>
</body>
</html>