<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="<c:url value="/protected/home"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
			<li><a href="<c:url value="/protected/home/orgsetups"/>"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>System Setups</a></li>
			<li><a href="<c:url value="/protected/home/trans"/>"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg>Transactions</a></li>
        </ul>

	</div>




