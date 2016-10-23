<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				<div class="panel panel-default">
<div class="row">
	<div class="col-md-6 col-sm-6 col-xs-12">
		<ul style="list-style-type: none;">
			<li><h5 style="font-weight: bolder;">Organizations Setups</h5></li>
			<li><a href="<c:url value="/protected/organization/"/>">Organization
					Definition</a></li>
			<li><a href="<c:url value="/protected/setups/currency"/>">Currency
					Definition</a></li>
			<li><a href="<c:url value="/protected/setups/countries"/>">Countries,Counties
					and Towns</a></li>
			<li><a href="<c:url value="/protected/setups/paymentmodes"/>">Payment
					Modes</a></li>
			<li><a href="<c:url value="/protected/setups/syssequences"/>">System
					Sequences</a></li>
		</ul>
	</div>
	<div class="col-md-6 col-sm-6 col-xs-12">
		<ul style="list-style-type: none;">
			<li><h5 style="font-weight: bolder;">Accounts Setups</h5></li>
			<li><a href="<c:url value="/protected/setups/accttypes"/>">Account
					Types</a></li>
			<li><a href="<c:url value="/protected/setups/accts"/>">Accounts</a></li>
			<li><a
				href="<c:url value="/protected/clients/setups/clientslist"/>">Clients</a></li>
		</ul>
	</div>
</div>
<div class="row">
	<div class="col-md-6 col-sm-6 col-xs-12">
		<ul style="list-style-type: none;">
			<li><h5 style="font-weight: bolder;">Product Setups</h5></li>
			<li><a href="<c:url value="/protected/setups/classes/classesHome"/>">Classes
					</a></li>
			<li><a href="<c:url value="/protected/setups/products/productsHome"/>">Products
					</a></li>
			<li><a href="<c:url value="/protected/setups/binders/bindersHome"/>">Product Binders
					</a></li>
		</ul>
	</div>
</div>
</div>