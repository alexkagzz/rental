

$(function(){

	$(document).ready(function() {
		createProductForSel();
		createAccountsForSel();
		createProdSubclassSel();
		createCoverTypesSel();
		createCoverSections();
		addBinder();
		addBinderDetails();
		addBinderPremRates();
	});
});

function makeBinderSelection(){
	var table = $('#binderList').DataTable();
	$('#binderList tbody').on( 'click', 'tr', function () {
		$(this).addClass('active').siblings().removeClass('active');
		var aData = table.rows('.active').data();
		 $("#binder-sel-pk").val(aData[0].binId);
		 model.product.proCode = aData[0].product.proCode;
		 createAcctBindDet();
		 makeBinderDetSelection();
    } );
}

function makeBinderDetSelection(){
	var table = $('#binderDetList').DataTable();
	$('#binderDetList tbody').on( 'click', 'tr', function () {
		$(this).addClass('active').siblings().removeClass('active');
		var aData = table.rows('.active').data();
		 $("#binder-det-code-pk").val(aData[0].detId);
		 model.covertype.covId = aData[0].covertype.covId;
		 createPremRatesTbl();
    } );
}

function addBinderPremRates(){
	
	$("#btn-add-prem-rates").click(function(){
		if($("#binder-det-code-pk").val() != ''){
		$('#prem-rates-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#prem-binder-det").val($("#binder-det-code-pk").val());
		$('#premRatesModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
		}
		else{
			bootbox.alert("Select Binder Detail to continue");
		}
		
	});
	var $classForm = $('#prem-rates-form');
	 var validator = $classForm.validate();
	 $('#savepremratesBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createPremRates";
   var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createPremRatesTbl();
				validator.resetForm();
				$('#prem-rates-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$('#premRatesModal').modal('hide');
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

function addBinderDetails(){
	
	$("#btn-add-binder-det").click(function(){
		if($("#binder-sel-pk").val() != ''){
		$('#binder-det-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#det-bind_code").val($("#binder-sel-pk").val());
		$('#binderDetModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
		}
		else{
			bootbox.alert("Select Binder to continue");
		}
		
	});
	
	var $classForm = $('#binder-det-form');
	 var validator = $classForm.validate();
	 $('#saveBinderDetBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createBinderDet";
     var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createProdSubclassSel();
				createCoverTypesSel();
				createAcctBindDet();
				validator.resetForm();
				$('#binder-det-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$('#binderDetModal').modal('hide');
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

function addBinder(){
	
	$("#btn-add-binder").click(function(){
		if($("#acc-id").val() != ''){
		$('#binder-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#act-bin-code").val($("#acc-id").val());
		$('#binderModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
		}
		else{
			bootbox.alert("Select Account to continue");
		}
	});
	
	
	var $classForm = $('#binder-form');
	 var validator = $classForm.validate();
	 $('#saveBinderBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createBinder";
      var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createAcctBinders();
				validator.resetForm();
				createProductForSel();
				$('#binder-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$('#binderModal').modal('hide');
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

function createAcctBindDet(){
	var url = "binderdetails/0";
	if($("#binder-sel-pk").val() != ''){
		url = "binderdetails/"+$("#binder-sel-pk").val();
	}
	  var currTable = $('#binderDetList').DataTable( {
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
				{ "data": "covertype",
					  "render": function ( data, type, full, meta ) {
							   
							  return full.covertype.covName;
					   }	
				},
				{ "data": "subclass",
					  "render": function ( data, type, full, meta ) {
							   
							  return full.subclass.subDesc;
					   }	
				},
				{ 
					"data": "detId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "detId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}


function createPremRatesTbl(){
	var url = "premrates/0";
	if($("#binder-det-code-pk").val() != ''){
		url = "premrates/"+$("#binder-det-code-pk").val();
	}
	  var currTable = $('#premList').DataTable( {
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
				{ "data": "section",
					  "render": function ( data, type, full, meta ) {
							   
							  return full.section.desc;
					   }	
				},
                { "data": "rangeFrom" },
				{ "data": "rangeTo" },
				{ "data": "rate" },
				{ "data": "rateType" },
				{ "data": "divFactor" },
				{ "data": "proratedFull" },
				{ "data": "freeLimit" },
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

function createAcctBinders(){
	var url = "binders/0";
	if($("#acc-id").val() != ''){
		url = "binders/"+$("#acc-id").val();
	}
	  var currTable = $('#binderList').DataTable( {
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
                { "data": "binShtDesc" },
				{ "data": "binName" },
				{ "data": "binPolNo" },
				{ "data": "product",
					  "render": function ( data, type, full, meta ) {
							   
							  return full.product.proDesc;
					   }	
				},
				{ "data": "active" },
				{ 
					"data": "binId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "binId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}

function createAccountsForSel(){
	if($("#acc-frm").filter("div").html() != undefined)
	  {
		  Select2Builder.initAjaxSelect2({
	            containerId : "acc-frm",
	            sort : 'name',
	            change: function(e, a, v){
	            	$("#acc-id").val(e.added.acctId);
	            	createAcctBinders();
	            	makeBinderSelection();
	            },
	            formatResult : function(a)
	            {
	            	return a.name
	            },
	            formatSelection : function(a)
	            {
	            	return a.name
	            },
	            initSelection: function (element, callback) {
	            	
                },
	            id: "acctId",
	            width:"220px"
	        });
	  }
}

function createProductForSel(){
	if($("#prd-code").filter("div").html() != undefined)
	  {
		  Select2Builder.initAjaxSelect2({
	            containerId : "prd-code",
	            sort : 'proDesc',
	            change: function(e, a, v){
	            	$("#prd-id").val(e.added.proCode);
	            },
	            formatResult : function(a)
	            {
	            	return a.proDesc
	            },
	            formatSelection : function(a)
	            {
	            	return a.proDesc
	            },
	            initSelection: function (element, callback) {
//	            	var code = $("#obId").val();
//	                var name = $("#ob-name").val();
//	                model.accounts.branch.brnCode = code;
//	                var data = {obName:name,obId:code};
//	                callback(data);
                },
	            id: "proCode",
	            width:"220px"
	        });
	  }
}

function createProdSubclassSel(){
	if($("#sel-sub-code").filter("div").html() != undefined)
	  {
		  Select2Builder.initAjaxSelect2({
	            containerId : "sel-sub-code",
	            sort : 'psId',
	            change: function(e, a, v){
	            	$("#sub-id").val(e.added.subclass.subId);
	            	 model.subclass.subcode = e.added.subclass.subId;
	            	 createCoverTypesSel();
	            },
	            formatResult : function(a)
	            {
	            	return a.subclass.subDesc
	            },
	            formatSelection : function(a)
	            {
	            	return a.subclass.subDesc
	            },
	            initSelection: function (element, callback) {
	            	
                },
	            id: "psId",
	            width:"220px",
	            params: {proCode: function(){
	            	return model.product.proCode;
	            }}
	        });
	  }
}

function createCoverSections(){
	if($("#sect-modal").filter("div").html() != undefined)
	  {
		  Select2Builder.initAjaxSelect2({
	            containerId : "sect-modal",
	            sort : 'desc',
	            change: function(e, a, v){
	            	$("#sect-id").val(e.added.id);
	            },
	            formatResult : function(a)
	            {
	            	return a.desc
	            },
	            formatSelection : function(a)
	            {
	            	return a.desc
	            },
	            initSelection: function (element, callback) {
	            	
                },
	            id: "id",
	            width:"220px",
	            params: {covCode: function(){
	            	return  model.covertype.covId;
	            }}
	        });
	  }
}

function createCoverTypesSel(){
	if($("#sel-cov-code").filter("div").html() != undefined)
	  {
		  Select2Builder.initAjaxSelect2({
	            containerId : "sel-cov-code",
	            sort : 'covShtDesc',
	            change: function(e, a, v){
	            	$("#cov-id").val(e.added.covId);
	            },
	            formatResult : function(a)
	            {
	            	return a.covName
	            },
	            formatSelection : function(a)
	            {
	            	return a.covName
	            },
	            initSelection: function (element, callback) {
	            	
                },
	            id: "covId",
	            width:"220px",
	            params: {subCode: function(){
	            	return model.subclass.subcode;
	            }}
	        });
	  }
}


var model = {
		product: {
			proCode:"",
	    },
	    account:{
	    	acctId:"",
	    },
	    subclass:{
	    	subcode:"",
	    },
	    covertype:{
	    	covId:""
	    }
	};