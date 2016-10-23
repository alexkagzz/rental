<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<c:url value="/js/modules/utils/select2builder.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/libs/rivets/rivets.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/modules/classes/classes.js"/>"></script>
<script>
	var requestContextPath = '${pageContext.request.contextPath}';
</script>
<div class="box box-info">
	<div class="box-body">
		<div class="spacer"></div>
		<hr>
		<div class="spacer"></div>
		<button type="button" class="btn btn-info" id="btn-add-classes">New</button>
		<h4>Classes</h4>
		<input type="hidden" id="class-pk">
		<div class="spacer"></div>
		<table id="classTbl" class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>Class ID</th>
					<th>Class Description</th>
					<th>Active?</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
		</table>
		<h4>Sub Classes</h4>
		<hr>
         <input type="hidden" id="sub-tb-class-pk">
		<button type="button" class="btn btn-info" id="btn-add-subclass">New</button>
		<div class="spacer"></div>
		<table id="subclassList" class="table table-hover table-bordered">
			<thead>
				<tr>

					<th>Sub Class ID</th>
					<th>Sub Class Name</th>
					<th>Risk Unique?</th>
					<th>Active?</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
		</table>
		<h4>Cover Types and Clauses</h4>
		<hr>

		
		<div class="spacer"></div>
		<div class="panel panel-default">
					<div class="panel-body tabs">
					
						<ul class="nav nav-pills">
							<li class="active"><a href="#pilltab1" data-toggle="tab">Cover Types</a></li>
							<li><a href="#pilltab2" data-toggle="tab">Clauses</a></li>
							
						</ul>
		
						<div class="tab-content">
							<div class="tab-pane fade in active" id="pilltab1">
								<button type="button" class="btn btn-info" id="btn-add-covertypes">New</button>
							    <div class="spacer"></div>
							    <input type="hidden" id="covt-sec-pk">
								<table id="coverTypesList" class="table table-hover table-bordered">
									<thead>
										<tr>
						
											<th>Cover Type ID</th>
											<th>Cover Type Name</th>
											<th>Active?</th>
											<th width="5%"></th>
											<th width="5%"></th>
										</tr>
									</thead>
								</table>
								<h4>Sections</h4>
								<hr>
						         
								<button type="button" class="btn btn-info" id="btn-add-section">New</button>
								<div class="spacer"></div>
								<table id="sectionsList" class="table table-hover table-bordered">
									<thead>
										<tr>
						
											<th>Section ID</th>
											<th>Section Name</th>
											<th>Section Type</th>
											<th width="5%"></th>
											<th width="5%"></th>
										</tr>
									</thead>
								</table>
							</div>
							<div class="tab-pane fade" id="pilltab2">
								<button type="button" class="btn btn-info" id="btn-add-clauses">New</button>
								<div class="spacer"></div>
								<table id="clausesList" class="table table-hover table-bordered">
									<thead>
										<tr>
						
											<th width="10%">Clause ID</th>
											<th width="10%">Heading</th>
											<th width="10%">Editable</th>
											<th width="40%">Wording</th>
											<th width="5%"></th>
											<th width="5%"></th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
	</div>
</div>

<jsp:include page="classmodals/modals.jsp"></jsp:include>