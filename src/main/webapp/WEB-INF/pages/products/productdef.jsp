<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:url value="/js/modules/utils/select2builder.js"/>"></script>
<script type="text/javascript" src="<c:url value="/libs/rivets/rivets.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/modules/products/product.js"/>"></script>
<div class="box box-info">
	<div class="box-body">
	<form id="prg-grp-form" class="form-horizontal">
	    <div class="form-group form-required">
				<div class="col-md-6">
				   <label for="brn-id" class="col-md-5 control-label">Select
					Product Group</label>

				<div class="col-md-7">
		                     <input type="hidden" id="prg-id" rv-value="prggrp.prgCode"/>
		                     <input type="hidden" id="prg-name">
		                        <div id="prd-group" class="form-control" 
				                                 select2-url="<c:url value="/protected/setups/products/selprodgroups"/>" >
				                                 
				               </div> 
				               
				</div>
				</div>
				<div class="col-md-2">
				    <button type="button" class="btn btn-info" id="btn-add-group">New</button>
				<!--     <button type="button" class="btn btn-info" id="btn-add-classes">Edit</button>  -->
				    
				</div>
				
				<div class="col-md-2">
				    
				</div>
				
				</div>
			</form>
		<div class="spacer"></div>
		<h4>Products</h4>
		<hr>
         <input type="hidden" id="prg-pk">
		<button type="button" class="btn btn-info" id="btn-add-prod">New</button>
		<div class="spacer"></div>
		<table id="prodList" class="table table-hover table-bordered">
			<thead>
				<tr>

					<th>Product ID</th>
					<th>Product Name</th>
					<th>Policy Prefix</th>
					<th>Claim Prefix</th>
					<th>MultiClass?</th>
					<th>Renewable?</th>
					<th>Active?</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
		</table>
		<div class="spacer"></div>
		<h4>Product Sub Classes</h4>
		<hr>
         <input type="hidden" id="prg-prod-code">
		<button type="button" class="btn btn-info" id="btn-add-prod-sub">New</button>
		<div class="spacer"></div>
		<table id="prodSubclassList" class="table table-hover table-bordered">
			<thead>
				<tr>

					<th>Subclass ID</th>
					<th>SubClass Name</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="prodmodals/modals.jsp"></jsp:include>