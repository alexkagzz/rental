<div class="modal fade" id="classModal" tabindex="-1" role="dialog"
		aria-labelledby="classModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="classModalLabel">
						Edit/Add Class
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="class-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="cl-code" name="clId">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Class ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="class-id"
									name="clShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Class Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="class-name" name="clDesc" 
									required>
							</div>
						</div>	
						
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Active Indicator</label>
							<div class="col-md-9">
								 <input type="checkbox" name="clactive" id="chk-active">
								 
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveClassBtn"
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
	
	<div class="modal fade" id="subclassModal" tabindex="-1" role="dialog"
		aria-labelledby="subclassModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="subclassModalLabel">
						Edit/Add Sub Class
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="sub-class-form" class="form-horizontal">
					   <input type="hidden" id="clasdef-pk" name="classDef">
						<input type="hidden" class="form-control" id="scl-pk" name="subId">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Sub Class ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="sub-class-id"
									name="subShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Sub Class Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="sub-class-name" name="subDesc" 
									required>
							</div>
						</div>	
						
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Risk Unique?</label>
							<div class="col-md-9">
								 <input type="checkbox" name="riskUnique" id="chk-unique-risk">
								 
							</div>
						</div>
						
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Active Indicator?</label>
							<div class="col-md-9">
								 <input type="checkbox" name="active" id="chk-sub-active">
								 
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveSubClassBtn"
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
	
	<div class="modal fade" id="coverTypeModal" tabindex="-1" role="dialog"
		aria-labelledby="coverTypeModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="coverTypeModalLabel">
						Edit/Add Cover Type
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="cover-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="cov-code" name="covId">
						<input type="hidden" id="sub-code-pk" name="subclass">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Cover Type ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="cover-id"
									name="covShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Cover Type Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="class-name" name="covName" 
									required>
							</div>
						</div>	
						
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Active Indicator</label>
							<div class="col-md-9">
								 <input type="checkbox" name="active" id="chk-cov-active">
								 
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveCoverTypeBtn"
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
	
	<div class="modal fade" id="sectionsModal" tabindex="-1" role="dialog"
		aria-labelledby="sectionsModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="sectionsModalLabel">
						Edit/Add Section
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="sect-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="sec-code" name="Id">
						<input type="hidden" class="form-control" id="cover-sec-code-pk" name="coverType">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Section ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="sec-id"
									name="shtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Section Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="class-name" name="desc" 
									required>
							</div>
						</div>	
						<div class="form-group">
							<label for="sel2" class="col-md-3 control-label">Section Type</label>
							<div class="col-md-8">
							      <select class="form-control" id="sel2" name="type">
							        <option value="">Select Section Type</option>
							        <option value="SI">Sum Insured</option>
								    <option value="LD">Loading</option>
								    <option value="DS">Discount</option>
								  </select>
							</div>
						</div>
						
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveSectBtn"
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
	
	<div class="modal fade" id="clauseModal" tabindex="-1" role="dialog"
		aria-labelledby="clauseModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="clauseModalLabel">
						Edit/Add Clause
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
				   
					<form id="clause-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="clause-code" name="clauId">
						<input type="hidden" class="form-control" id="clause-sub-pk" name="subclass">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Clause ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="clau-id"
									name="clauShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Clause Heading</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="clause-name" name="clauHeading" 
									required>
							</div>
						</div>	
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Clause Wording</label>

							<div class="col-md-8">
								<textarea rows="5" cols="20" class="form-control" name="clauWording"></textarea>
							</div>
						</div>	
						<div class="form-group">
							<label for="rate-taxable" class="col-md-3 control-label">Editable</label>
							<div class="col-md-9">
								 <input type="checkbox" name="editable" id="chk-cl-editable">
								 
							</div>
						</div>
						
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveClauseBtn"
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