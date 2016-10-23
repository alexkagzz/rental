<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:url value="/js/modules/utils/select2builder.js"/>"></script>
<script type="text/javascript" src="<c:url value="/libs/rivets/rivets.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/modules/binder/binder.js"/>"></script>
<div class="box box-info">
	<div class="box-body">
	<form id="prg-grp-form" class="form-horizontal">
	    <div class="form-group form-required">
				<div class="col-md-6">
				   <label for="brn-id" class="col-md-5 control-label">
					Insurance Company</label>

				<div class="col-md-7">
		                     <input type="hidden" id="acc-id" rv-value="account.acctId"/>
		                     <input type="hidden" id="acc-name">
		                        <div id="acc-frm" class="form-control" 
				                                 select2-url="<c:url value="/protected/setups/binders/selAccounts"/>" >
				                                 
				               </div> 
				               
				</div>
				</div>
				
				
				</div>
			</form>
			<div class="spacer"></div>
		<h4>Binders</h4>
		<hr>
         <input type="hidden" id=binder-sel-pk>
		<button type="button" class="btn btn-info" id="btn-add-binder">New</button>
		<div class="spacer"></div>
		<table id="binderList" class="table table-hover table-bordered">
			<thead>
				<tr>

					<th>Binder ID</th>
					<th>Binder Name</th>
					<th>Binder Policy No</th>
					<th>Product</th>
					<th>Active?</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
		</table>
		<div class="spacer"></div>
		<h4>Binders Details</h4>
		<hr>
         <input type="hidden" id="binder-det-code-pk">
		<button type="button" class="btn btn-info" id="btn-add-binder-det">New</button>
		<div class="spacer"></div>
		<table id="binderDetList" class="table table-hover table-bordered">
			<thead>
				<tr>

					<th>Cover Type</th>
					<th>Sub Class</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
		</table>
		<div class="spacer"></div>
		<h4>Premium Rates</h4>
		<hr>
		<button type="button" class="btn btn-info" id="btn-add-prem-rates">New</button>
		<div class="spacer"></div>
		<table id="premList" class="table table-hover table-bordered">
			<thead>
				<tr>

					<th>Section</th>
					<th>Range From</th>
					<th>Range To</th>
					<th>Rate</th>
					<th>Rate Type</th>
					<th>Div Factor</th>
					<th>Prorated Full</th>
					<th>Free Limit</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
		</table>
		
	</div>
	</div>
	<jsp:include page="bindermodals/modals.jsp"></jsp:include>
	