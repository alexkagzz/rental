<div class="modal fade" id="prodGrpModal" tabindex="-1" role="dialog"
		aria-labelledby="prodGrpModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="prodGrpModalLabel">
						Add Product Group
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="prg-grp-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="prg-code" name="prgCode">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Product Group</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="grp-desc"
									name="prgDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Type</label>

							<div class="col-md-8">
								 <select class="form-control" id="sel2" name="prgType">
							        <option value="">Select Product Group</option>
							        <option value="M">Motor</option>
								    <option value="F">Fire</option>
								    <option value="MD">Medical</option>
								    <option value="Ms">Miscellenous</option>
								  </select>
							</div>
						</div>	
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveprgGrpBtn"
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
	
	<div class="modal fade" id="prodModal" tabindex="-1" role="dialog"
		aria-labelledby="prodModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="prodModalLabel">
						Edit/Add Product
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="product-form" class="form-horizontal">
					<input type="hidden" id="prg-group-pks" name="proGroup">
						<input type="hidden" class="form-control" id="pro-code" name="proCode">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Product ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="pro-sht-desc"
									name="proShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Product Name</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="pro-name"
									name="proDesc"  required>
							</div>
						</div>	
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Policy Prefix</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="pro-pol-prefix"
									name="proPolPrefix"  required>
							</div>
						</div>	
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Claim Prefix</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="pro-clm-prefix"
									name="proClmPrefix"  required>
							</div>
						</div>	
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Multi Sub Class?</label>
							<div class="col-md-9">
								 <input type="checkbox" name="multiSubClass" id="chk-multi-class">
								 
							</div>
						</div>
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Renewable?</label>
							<div class="col-md-9">
								 <input type="checkbox" name="renewable" id="chk-renewable">
								 
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
					<button data-loading-text="Saving..." id="saveproductBtn"
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