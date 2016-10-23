
$(function(){

	$(document).ready(function() {
		
		createProdGrpSelect();
		addProductGroup();
		addProduct();
		
	});
});

function makeProductSelection(){
	var table = $('#prodList').DataTable();
	$('#prodList tbody').on( 'click', 'tr', function () {
		$(this).addClass('active').siblings().removeClass('active');
		var aData = table.rows('.active').data();
		  $("#prg-prod-code").val(aData[0].proCode);
		  createProductSubclasses();
    } );
}

function addProduct(){
	
	$("#btn-add-prod").click(function(){
		if($("#prg-pk").val() != ''){
		
		$('#product-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$("#chk-multi-class").prop("checked", false);
		$("#chk-renewable").prop("checked", false);
		$("#chk-active").prop("checked", false);
		$("#prg-group-pks").val($("#prg-pk").val());
		$('#prodModal').modal({
			  backdrop: 'static',
			  keyboard: true
			});
		}
		else{
			bootbox.alert("Select Product group to continue");
		}
	});
	
	var $classForm = $('#product-form');
	 var validator = $classForm.validate();
	 $('#saveproductBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createProduct";
      var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				createProducts();
				validator.resetForm();
				$('#product-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				$("#chk-multi-class").prop("checked", false);
				$("#chk-renewable").prop("checked", false);
				$("#chk-active").prop("checked", false);
				$('#prodModal').modal('hide');
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

function addProductGroup(){
	$("#btn-add-group").click(function(){
		$('#prg-grp-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
		$('#prodGrpModal').modal({
			  backdrop: 'static',
			  keyboard: true
			})
	});
	
	 var $classForm = $('#prg-grp-form');
	 var validator = $classForm.validate();
	 $('#saveprgGrpBtn').click(function(){
			if (!$classForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$classForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createGroup";
       var request = $.post(url, data );
			request.success(function(){
				bootbox.alert("Record created/updated Successfully");
				validator.resetForm();
				$('#prg-grp-form').find("input[type=text],input[type=number],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea,select").val("");
				//$("#chk-cl-editable").prop("checked", false);
				$('#prodGrpModal').modal('hide');
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


function createProductSubclasses(){
	var url = "subclasses/0";
	if($("#prg-prod-code").val() != ''){
		url = "subclasses/"+$("#prg-prod-code").val();
	}
	  var currTable = $('#prodSubclassList').DataTable( {
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
                { "data": "subclass",
					  "render": function ( data, type, full, meta ) {
							   
							  return full.subclass.subShtDesc;
					   }	
				},
				{ "data": "subclass",
					  "render": function ( data, type, full, meta ) {
							   
							  return full.subclass.subDesc;
					   }	
				},
				{ 
					"data": "proCode",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "proCode",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}

function createProducts(){
	var url = "products/0";
	if($("#prg-pk").val() != ''){
		url = "products/"+$("#prg-pk").val();
	}
	  var currTable = $('#prodList').DataTable( {
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
                { "data": "proShtDesc" },
				{ "data": "proDesc" },
				{ "data": "proPolPrefix" },
				{ "data": "proClmPrefix" },
				{ "data": "multiSubClass" },
				{ "data": "renewable" },
				{ "data": "active" },
				{ 
					"data": "proCode",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editAcctTypes(this);"/>';
					}

				},
				{ 
					"data": "proCode",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-acctype='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmAcctypeDel(this);"/>';
					}

				},
			]
		} );
	  return currTable;
}


function createProdGrpSelect(){
	if($("#prd-group").filter("div").html() != undefined)
	  {
		  Select2Builder.initAjaxSelect2({
	            containerId : "prd-group",
	            sort : 'prgDesc',
	            change: function(e, a, v){
	            	 $("#prg-pk").val(e.added.prgCode);
	            	createProducts();
	            	makeProductSelection();
	            },
	            formatResult : function(a)
	            {
	            	return a.prgDesc
	            },
	            formatSelection : function(a)
	            {
	            	return a.prgDesc
	            },
	            initSelection: function (element, callback) {
//	            	var code = $("#obId").val();
//	                var name = $("#ob-name").val();
//	                model.accounts.branch.brnCode = code;
//	                var data = {obName:name,obId:code};
//	                callback(data);
                },
	            id: "prgCode",
	            width:"220px"
	        });
	  }
}

var model = {
		prggrp: {
			prgCode:"",
	    }
	};