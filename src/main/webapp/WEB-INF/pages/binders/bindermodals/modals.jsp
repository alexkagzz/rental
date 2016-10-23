<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="binderModal" tabindex="-1" role="dialog"
		aria-labelledby="binderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="binderModalLabel">
						Edit/Add Binder
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="binder-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="bind-code" name="binId">
						<input type="hidden" class="form-control" id="act-bin-code" name="account">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Binder ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="bind-id"
									name="binShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Bind Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="bind-name" name="binName" 
									required>
							</div>
						</div>	
						
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Bind Policy No</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="bind-pol-no" name="binPolNo" 
									required>
							</div>
						</div>	
						
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Product</label>

							<div class="col-md-8">
								<input type="hidden" id="prd-id" rv-value="product.proCode" name="product"/>
		                     <input type="hidden" id="pr-name">
		                        <div id="prd-code" class="form-control" 
				                                 select2-url="<c:url value="/protected/setups/binders/selproducts"/>" >
				                                 
				               </div> 
							</div>
						</div>	
						
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Active Indicator</label>
							<div class="col-md-9">
								 <input type="checkbox" name="active" id="chk-active">
								 
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveBinderBtn"
						type="button" class="btn btn-primary">
						Save
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
	
	
<div class="modal fade" id="binderDetModal" tabindex="-1" role="dialog"
		aria-labelledby="binderDetModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="binderDetModalLabel">
						Edit/Add Binder Details
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="binder-det-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="det-code" name="detId">
						<input type="hidden" class="form-control" id="det-bind_code" name="binder">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Sub Class</label>

							<div class="col-md-8">
								<input type="hidden" id="sub-id" rv-value="subclass.subcode" name="subclass"/>
		                     <input type="hidden" id="sub-name">
		                        <div id="sel-sub-code" class="form-control" 
				                                 select2-url="<c:url value="/protected/setups/binders/selSubclass"/>" >
				                                 
				               </div> 
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Cover Type</label>

							<div class="col-md-8">
								<input type="hidden" id="cov-id" rv-value="covertype.covId" name="covertype"/>
		                     <input type="hidden" id="cov-name">
		                        <div id="sel-cov-code" class="form-control" 
				                                 select2-url="<c:url value="/protected/setups/binders/selCoverTypes"/>" >
				                                 
				               </div> 
							</div>
						</div>	
						
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveBinderDetBtn"
						type="button" class="btn btn-primary">
						Save
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="premRatesModal" tabindex="-1" role="dialog"
		aria-labelledby="premRatesModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="premRatesModalLabel">
						Edit/Add Premium Rates
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="prem-rates-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="prem-code" name="Id">
						<input type="hidden" class="form-control" id="prem-binder-det" name="binderDet">
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Section</label>

							<div class="col-md-8">
								<input type="hidden" id="sect-id" rv-value="product.proCode" name="section"/>
		                     <input type="hidden" id="sec-name">
		                        <div id="sect-modal" class="form-control" 
				                                 select2-url="<c:url value="/protected/setups/binders/selSections"/>" >
				                                 
				               </div> 
							</div>
						</div>	
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Range From</label>

							<div class="col-md-8">
								<input type="number" class="form-control" id="bind-id"
									name="rangeFrom"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Range To</label>

							<div class="col-md-8">
								<input type="number" class="editUserCntrls form-control"
									id="bind-name" name="rangeTo" 
									required>
							</div>
						</div>	
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Rate Type</label>

							<div class="col-md-8">
								<select class="form-control" id="sel-rt" name="rateType">
							        <option value="">Select Rate Type</option>
							        <option value="P">Percentage</option>
								    <option value="A">Amount</option>
								  </select>
							</div>
						</div>	
						
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Rate</label>

							<div class="col-md-8">
								<input type="number" class="editUserCntrls form-control"
									id="bind-pol-no" name="rate" 
									required>
							</div>
						</div>	
						
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Div Factor</label>

							<div class="col-md-8">
								<input type="number" class="editUserCntrls form-control"
									id="bind-pol-no" name="divFactor" 
									required>
							</div>
						</div>	
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Free Limit</label>

							<div class="col-md-8">
								<input type="number" class="editUserCntrls form-control"
									id="bind-pol-no" name="freeLimit" 
									required>
							</div>
						</div>	
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Prorated Full</label>

							<div class="col-md-8">
								<select class="form-control" id="sel2" name="proratedFull">
							        <option value="">Select prorated full</option>
							        <option value="P">Prorated</option>
								    <option value="F">Full</option>
								  </select>
							</div>
						</div>	
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="savepremratesBtn"
						type="button" class="btn btn-primary">
						Save
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
	