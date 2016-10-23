$(function(){

	$(document).ready(function() {	
		createClassesList();
		addClasses();
		makeClassSelection();
		addSubClasses();
		addCoverTypes();
		addCoverSections();
		addClauses();
	});
});

function makeClassSelection(){
	var table = $('#classTbl').DataTable();
	$('#classTbl tbody').on( 'click', 'tr', function () {
		$(this).addClass('active').siblings().removeClass('active');
		var aData = table.rows('.active').data();
		  $("#class-pk").val(aData[0].clId);
		  createSubClassesList();
		  makeSubClassSelection();
    } );
}

function makeCoverTypesSelection(){
	var table = $('#coverTypesList').DataTable();
	$('#coverTypesList tbody').on( 'click', 'tr', function () {
		$(this).addClass('active').siblings().removeClass('active');
		var aData = table.rows('.active').data();
		console.log(aData);
		  $("#covt-sec-pk").val(aData[0].covId);
		  createSectionsList();
    } );
}

function makeSubClassSelection(){
	var table = $('#subclassList').DataTable();
	$('#subclassList tbody').on( 'click', 'tr', function () {
		$(this).addClass('active').siblings().removeClass('active');
		var aData = table.rows('.active').data();
		if (aData[0] === undefined || aData[0] === null) {
		}
		else{
		  $("#sub-tb-class-pk").val(aData[0].subId);
		  createCoverTypes();
		  makeCoverTypesSelection();
		  createClausesList();
		}
    } );
}


function addClauses(){
	$("#btn-add-clauses").click(function(){
		$('#clause-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#clause-sub-pk").val($("#sub-tb-class-pk").val());
		$("#chk-cl-editable").prop("checked", false);
		$('#clauseModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
	});
	
	 var $classForm = $('#clause-form');
	 var validator = $classForm.validate();
	 $('#saveClauseBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createClause";
       var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createClausesList();			
				validator.resetForm();
				$('#clause-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$("#chk-cl-editable").prop("checked", false);
				$('#clauseModal').modal('hide');
			});

			request.error(function(jqXHR, textStatus, errorThrown){
				console.log(jqXHR);
				bootbox.alert(jqXHR.responseText);
			});
			request.always(function(){
				$btn.button('reset');
       });
		});
}

function addCoverSections(){
	$("#btn-add-section").click(function(){
		$('#sect-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#cover-sec-code-pk").val($("#covt-sec-pk").val());
		$('#sectionsModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
	});
	
	var $classForm = $('#sect-form');
	  var validator = $classForm.validate();
	 $('#saveSectBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			console.log(data);
			var url = "createSection";
   var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createSectionsList();				
				validator.resetForm();
				$('#sect-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$('#sectionsModal').modal('hide');
			});

			request.error(function(jqXHR, textStatus, errorThrown){
				console.log(jqXHR);
				bootbox.alert(jqXHR.responseText);
			});
			request.always(function(){
				$btn.button('reset');
           });
	 });

}


function addCoverTypes(){
	$("#btn-add-covertypes").click(function(){
		$('#cover-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#chk-active").prop("checked", false);
		$("#chk-unique-risk").prop("checked", false);
		$("#sub-code-pk").val($("#sub-tb-class-pk").val());
		$('#coverTypeModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
	});
	
	var $classForm = $('#cover-form');
	  var validator = $classForm.validate();
	 $('#saveCoverTypeBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createCoverType";
     var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createCoverTypes();				
				validator.resetForm();
				$('#cover-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$("#chk-cov-active").prop("checked", false);
				$('#coverTypeModal').modal('hide');
			});

			request.error(function(jqXHR, textStatus, errorThrown){
				console.log(jqXHR);
				bootbox.alert(jqXHR.responseText);
			});
			request.always(function(){
				$btn.button('reset');
     });
		});
}

function addSubClasses(){
	$("#btn-add-subclass").click(function(){
		$('#sub-class-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#chk-sub-active").prop("checked", false);
		$("#chk-unique-risk").prop("checked", false);
		$("#clasdef-pk").val($("#class-pk").val());
		$('#subclassModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
	});
	
	 var $classForm = $('#sub-class-form');
	 var validator = $classForm.validate();
	 $('#saveSubClassBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createSubClass";
       var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createSubClassesList();			
				validator.resetForm();
				$('#sub-class-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$("#chk-active").prop("checked", false);
				$("#chk-unique-risk").prop("checked", false);
				$('#subclassModal').modal('hide');
			});

			request.error(function(jqXHR, textStatus, errorThrown){
				console.log(jqXHR);
				bootbox.alert(jqXHR.responseText);
			});
			request.always(function(){
				$btn.button('reset');
       });
		});
}

function addClasses(){
	$("#btn-add-classes").click(function(){
		$('#class-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#chk-active").prop("checked", false);
		$('#classModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
		
	});
	
	var $classForm = $('#class-form');
	  var validator = $classForm.validate();
	 $('#saveClassBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createClassDef";
       var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				$('#classTbl').DataTable().ajax.reload();				
				validator.resetForm();
				$('#class-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$("#chk-active").prop("checked", false);
				$('#classModal').modal('hide');
			});

			request.error(function(jqXHR, textStatus, errorThrown){
				console.log(jqXHR);
				bootbox.alert(jqXHR.responseText);
			});
			request.always(function(){
				$btn.button('reset');
       });
		});
}


function createCoverTypes(){
	var url = "coverTypes/0";
	if($("#sub-tb-class-pk").val() != ''){
		url = "coverTypes/"+$("#sub-tb-class-pk").val();
	}
	  var currTable = $('#coverTypesList').DataTable( {
			"processing": true,
			"serverSide": true,
			autoWidth: true,
			"ajax": {
				'url': url,
			},
			lengthMenu: [ [5], [5] ],
			pageLength: 5,
			destroy: true,
			"columns": [
                { "data": "covShtDesc" },
				{ "data": "covName" },
				{ "data": "active" },
				{ 
					"data": "covId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "covId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}


function createSubClassesList(){
	var url = "subclassList/0";
	if($("#class-pk").val() != ''){
		url = "subclassList/"+$("#class-pk").val();
	}
	  var currTable = $('#subclassList').DataTable( {
			"processing": true,
			"serverSide": true,
			autoWidth: true,
			"ajax": {
				'url': url,
			},
			lengthMenu: [ [5], [5] ],
			pageLength: 5,
			destroy: true,
			"columns": [
                { "data": "subShtDesc" },
				{ "data": "subDesc" },
				{ "data": "riskUnique" },
				{ "data": "active" },
				{ 
					"data": "subId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "subId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}


function createSectionsList(){
	var url = "sections/0";
	if($("#covt-sec-pk").val() != ''){
		url = "sections/"+$("#covt-sec-pk").val();
	}
	  var currTable = $('#sectionsList').DataTable( {
			"processing": true,
			"serverSide": true,
			autoWidth: true,
			"ajax": {
				'url': url,
			},
			lengthMenu: [ [5], [5] ],
			pageLength: 5,
			destroy: true,
			"columns": [
                { "data": "shtDesc" },
				{ "data": "desc" },
				{ "data": "type" },
				{ 
					"data": "Id",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "Id",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}


function createClausesList(){
	var url = "clauses/0";
	if($("#sub-tb-class-pk").val() != ''){
		url = "clauses/"+$("#sub-tb-class-pk").val();
	}
	  var currTable = $('#clausesList').DataTable( {
			"processing": true,
			"serverSide": true,
			"ajax": {
				'url': url,
			},
			lengthMenu: [ [5], [5] ],
			pageLength: 5,
			destroy: true,
			"columns": [
                { "data": "clauShtDesc" },
				{ "data": "clauHeading" },
				{ "data": "editable" },
				{ "data": "clauWording" },
				{ 
					"data": "clauId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "clauId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}


function createClassesList(){
	var url = "classesList";
	  var currTable = $('#classTbl').DataTable( {
			"processing": true,
			"serverSide": true,
			autoWidth: true,
			"ajax": {
				'url': url,
			},
			lengthMenu: [ [5], [5] ],
			pageLength: 5,
			destroy: true,
			"columns": [
                { "data": "clShtDesc" },
				{ "data": "clDesc" },
				{ "data": "clactive" },
				{ 
					"data": "clId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "clId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}