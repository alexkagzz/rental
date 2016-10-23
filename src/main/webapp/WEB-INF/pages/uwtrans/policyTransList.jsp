<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:url value="/js/modules/utils/select2builder.js"/>"></script>
<script type="text/javascript" src="<c:url value="/libs/rivets/rivets.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/modules/uwtrans/policies.js"/>"></script>
	<div class="box box-info">
	<div class="box-body">
	     <div class="spacer"></div>
	<hr>
	<div class="spacer"></div>
	 <a href="<c:url value='/protected/clients/setups/clientsform'/> " class="btn btn-info pull-right">New</a>
	<h4>Policies List</h4>
	
	
	
	<div class="spacer"></div>
	<table id="polTbl" class="table table-hover table-bordered">
		<thead>
			<tr>
                <th>Policy No</th>
				<th>Revision No</th>
				<th>Client</th>
				<th>Agent</th>
				<th>Branch</th>
				<th>Wef Date</th>
				<th>Wet Date</th>
				<th>Sum Insured</th>
				<th>Premium</th>
				<th width="5%"></th>
			</tr>
		</thead>
	</table>
	
	</div>
	</div>