$(function(){

	$(document).ready(function() {
		creatPolicies();
	});
});


function creatPolicies(){
	var url = "policies";
	  var currTable = $('#polTbl').DataTable( {
			"processing": true,
			"serverSide": true,
			"ajax": url,
			lengthMenu: [ [20,30,40,50], [20,30,40,50] ],
			pageLength: 20,
			"order": [[ 9, "asc" ]],
			destroy: true,
			"columns": [
				{ "data": "polNo" },
				{ "data": "polRevNo" },
				{ "data": "client",
					   "render": function ( data, type, full, meta ) {
						      return full.client.fname + " "+full.client.otherNames;
						  }
				},
				{ "data": "agent",
					   "render": function ( data, type, full, meta ) {
						      return full.agent.name;
						  }
				},
				{ "data": "branch",
					   "render": function ( data, type, full, meta ) {
						      return full.branch.obName;
						  }
				},
				{ "data": "wefDate",
					 "render": function ( data, type, full, meta ) {
					      return moment(full.wefDate).format('DD/MM/YYYY');
					  }
				},
				{ "data": "wetDate",
					 "render": function ( data, type, full, meta ) {
					      return moment(full.wetDate).format('DD/MM/YYYY');
					  }
				},
				{ "data": "sumInsured" , 
					 "render":function(data,type,full,meta){
						  return currencyFormat(full.sumInsured);
					  }
				},
				{ "data": "premium" , 
					 "render":function(data,type,full,meta){
						  return currencyFormat(full.premium);
					  }
				},
				{ 
					"data": "policyId",
					"render": function ( data, type, full, meta ) {
						if(full.status==="A"){
							return '<form action="editInvoice" method="post"><input type="hidden" name="id" value='+full.invoiceId+'><input type="submit"  class="hyperlink-btn" value="View" ></form>';
							
						}else
						return '<form action="editInvoice" method="post"><input type="hidden" name="id" value='+full.invoiceId+'><input type="submit"  class="hyperlink-btn" value="Edit" ></form>';
						
					 }

				},
			]
		} );
	  return currTable;
}


function currencyFormat (num) {
	if(num)
    return  num.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")
    else
    	return null;
}