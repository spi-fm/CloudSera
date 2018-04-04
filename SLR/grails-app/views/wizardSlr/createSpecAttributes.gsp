<%@ page import="es.uca.pfc.User"%>
<%@ page import="es.uca.pfc.Slr"%>
<%@ page import="es.uca.pfc.Criterion"%>
<!DOCTYPE html>
<html lang="en">

<head>

<%-- Head Meta --%>
<g:render template="headMeta" contextPath="/" />

<title>SLR | Create SLR (Wizard)</title>

<%-- CSS --%>
<g:render template="css" contextPath="/" />
<script type="text/javascript">
		function getIdAttribute(id)
		{
			document.getElementById("idAttribute").value = id.toString();
			document.getElementById('divErrorAttribute').style.display = "none";
		}
		function getAttributeForEdit(id,name,type,options)
		{
			document.getElementById("idEditAttribute").value = id.toString();
			document.getElementById("nombreEdit").value = name.toString();
			document.getElementById("tipoEdit").value = type.toString();
			if(document.getElementById("tipoEdit").value == "list")
			{
				document.getElementById("opcionesEdit").style.visibility = "visible";
				document.getElementById("lbOptionsEdit").style.visibility = "visible";
			}
			else
			{
				document.getElementById("opcionesEdit").style.visibility = "hidden";
				document.getElementById("lbOptionsEdit").style.visibility = "hidden";
			}
			document.getElementById("opcionesEdit").value = options.toString();
			document.getElementById('divErrorEditAttribute').style.display = "none";
			
		}
		function loadModal()
		{
			if(${null != errorAttribute && errorAttribute != ""})
			{
				$('#myModalAttribute').modal('show');
				if (${tipoAttribute == "list"})
				{
					//document.getElementById("opciones").disabled = false;
					document.getElementById("opciones").style.visibility = "visible";
					document.getElementById("lbOptions").style.visibility = "visible";
				}
			}
			else if (${successAttribute})
			{
				document.getElementById('divSuccessAttribute').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccessAttribute').style.display = "none";
				}, 5000);
			}

			if(${null != errorEditAttribute && errorEditAttribute != ""})
			{
				$('#myModalEditAttribute').modal('show');
				if (${tipoEditAttribute == "list"})
				{
					//document.getElementById("opcionesEdit").disabled = false;
					document.getElementById("opcionesEdit").style.visibility = "visible";
					document.getElementById("lbOptionsEdit").style.visibility = "visible";
				}
			}
			else if (${successEditAttribute})
			{
				document.getElementById('divSuccessEditAttribute').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccessEditAttribute').style.display = "none";
				}, 5000);
			}
		}
		function getIdSlr(id)
		{
			document.getElementById("guidSlr").value = id.toString();
			document.getElementById('divErrorAttribute').style.display = "none";
		}
		function typeChange()
		{
			if(document.getElementById("tipo").value == "list")
			{
				//document.getElementById("opciones").disabled = false;
				document.getElementById("opciones").style.visibility = "visible";
				document.getElementById("lbOptions").style.visibility = "visible";
			}
			else
			{
				//document.getElementById("opciones").disabled = true;
				document.getElementById("opciones").style.visibility = "hidden";
				document.getElementById("lbOptions").style.visibility = "hidden";
			}
		}
	</script>
</head>

<body onload="loadModal();">

	<%--Ventana modal crear atributo --%>
	<div class="modal fade" id="myModalAttribute" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Create Specific
						Attribute</h4>
				</div>
				<g:form controller="wizardSlr" action="saveSpecAttributes"
					method="POST" name="myFormAttribute" id="myFormAttribute">
					<g:hiddenField name="guidSlr" value="${slrInstance.guid}" />
					<div class="modal-body">
						<g:if
							test="${null != errorAttribute && !errorAttribute.equals("")}">
							<div id="divErrorAttribute" class="alert alert-danger"
								role="alert">
								<i class="fa fa-remove fa-fw"></i>
								${errorAttribute}
							</div>
						</g:if>
						<div class="form-inline">
							<table>
								<tr>
									<td><b>Name:</b></td>
									<td><input id="nombre" type="text" name="nombre"
										class="form-control" value="${nombreAttribute}" /></td>
								</tr>
								<tr>
									<td><b>Type:</b></td>
									<td><select id="tipo" name="tipo" onchange="typeChange();">
											<g:if test="${tipoAttribute == 'string'}">
												<option value="string" selected="selected">String</option>
											</g:if>
											<g:else>
												<option value="string">String</option>
											</g:else>
											<g:if test="${tipoAttribute == 'number'}">
												<option value="number" selected="selected">Number</option>
											</g:if>
											<g:else>
												<option value="number">Number</option>
											</g:else>
											<g:if test="${tipoAttribute == 'list'}">
												<option value="list" selected="selected">List</option>
											</g:if>
											<g:else>
												<option value="list">List</option>
											</g:else>
									</select></td>
								</tr>
								<tr>
									<td><label id="lbOptions" style="visibility: hidden;"><b>Options:
												(;)</b></label></td>
									<td><g:if
											test="${opcionesAttribute == null || opcionesAttribute == 'null'}">
											<textarea id="opciones" class="form-control" name="opciones" style="resize: none; width: 400px; height: 80px; visibility: hidden;"></textarea>
										</g:if> <g:else>
											<textarea id="opciones" class="form-control" name="opciones" style="resize: none; width: 400px; height: 80px; visibility: hidden;">${opcionesAttribute}</textarea>
										</g:else></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
						<g:submitButton name="create" class="btn btn-primary"
							value="Create attribute" />
					</div>
				</g:form>
			</div>
		</div>
	</div>

	<%--Ventana modal editar atributo --%>
	<div class="modal fade" id="myModalEditAttribute" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Edit Specific
						Attribute</h4>
				</div>
				<g:form controller="wizardSlr" action="editSpecAttributes"
					method="POST" name="myFormEditAttribute" id="myFormEditAttribute">
					<g:hiddenField name="guidSlr" value="${slrInstance.guid}" />
					<g:hiddenField name="idEditAttribute" value="${idEditAttribute}" />
					<div class="modal-body">
						<g:if
							test="${null != errorEditAttribute && !errorEditAttribute.equals("")}">
							<div id="divErrorEditAttribute" class="alert alert-danger"
								role="alert">
								<i class="fa fa-remove fa-fw"></i>
								${errorEditAttribute}
							</div>
						</g:if>
						<div class="form-inline">
							<table>
								<tr>
									<td><b>Name:</b></td>
									<td><input id="nombreEdit" type="text" name="nombreEdit"
										class="form-control" value="${nombreEditAttribute}" /></td>
								</tr>
								<tr>
									<td><b>Type:</b></td>
									<td><select id="tipoEdit" name="tipoEdit"
										disabled="disabled">
											<g:if test="${tipoEditAttribute == 'string'}">
												<option value="string" selected="selected">String</option>
											</g:if>
											<g:else>
												<option value="string">String</option>
											</g:else>
											<g:if test="${tipoEditAttribute == 'number'}">
												<option value="number" selected="selected">Number</option>
											</g:if>
											<g:else>
												<option value="number">Number</option>
											</g:else>
											<g:if test="${tipoEditAttribute == 'list'}">
												<option value="list" selected="selected">List</option>
											</g:if>
											<g:else>
												<option value="list">List</option>
											</g:else>
									</select></td>
								</tr>
								<tr>
									<td><label id="lbOptionsEdit" style="visibility: hidden;"><b>Options:
												(;)</b></label></td>
									<td><g:if
											test="${opcionesEditAttribute == null || opcionesEditAttribute == 'null'}">
											<textarea id="opcionesEdit" class="form-control"
												name="opcionesEdit"
												style="resize: none; width: 400px; height: 80px; visibility: hidden;"
												disabled="disabled"></textarea>
										</g:if> <g:else>
											<textarea id="opcionesEdit" class="form-control"
												name="opcionesEdit"
												style="resize: none; width: 400px; height: 80px; visibility: hidden;"
												disabled="disabled">
												${opcionesEditAttribute}
											</textarea>
										</g:else></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
						<g:submitButton name="create" class="btn btn-primary"
							value="Edit attribute" />
					</div>
				</g:form>
			</div>
		</div>
	</div>

	<%-- Ventana modal para eliminar atributo --%>
	<div class="modal fade" id="myModalDrop" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Delete Atributo</h4>
				</div>
				<g:form controller="wizardSlr" action="deleteSpecAttributes"
					id="myFormDelete" name="myFormDelete" method="DELETE">
					<g:hiddenField name="idAttribute" value="0" />
					<g:hiddenField name="guidSlr" value="${slrInstance.guid}" />
					<div class="modal-body">
						The delete of this attribute will remove all attributes for every
						reference.
						<p></p>
						<p>Do you want to delete this attribute ?</p>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">No</button>
						<g:submitButton id="boton" name="boton" class="btn btn-primary"
							value="Yes" />
					</div>
				</g:form>
			</div>
		</div>
	</div>

	<div id="wrapper">

		<%-- Head --%>
		<g:render template="head" contextPath="/" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Create SLR (Wizard) <small>${slrInstance.title}</small></h1>

					<ol class="breadcrumb">
						<li><g:link controller="index" action="menu">Home</g:link></li>
						<li><g:link controller="slr" action="myList">My SLR's</g:link></li>
						<li class="active">Create SLR (Wizard)</li>
					</ol>
				</div>

				<!-- /.col-lg-12 -->
			</div>

			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-wizard">
						<li class="active"><a href="#">1. Need of SLR</a></li>
						<li class="active"><a href="#">2. Researchs Questions</a></li>
						<li class="active"><a href="#">3. Criterions</a></li>
						<li class="active"><a href="#">4. Specific Attributes</a></li>
						<li><a href="#">Finish!!</a></li>
					</ul>
				</div>
			</div>

			<div class="row" style="padding-top: 20px;">
				<h3>4. Specifics Attributes</h3>
				<div class="col-lg-6" align="left">
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#myModalAttribute">Create Attribute</button>
				</div>
				<div class="col-lg-6" align="right">
					<g:link class="btn btn-primary" controller="wizardSlr"
						action="createSearch"
						onclick="closeModalWithMessage('myModal','Creating Specific Attributes...');"
						params="[guidSlr: "${slrInstance.guid}"]">Finish</g:link>
				</div>
			</div>
			<div class="row" style="padding-top: 20px;">
				<g:if test="${null != error && !error.equals("")}">
					<div id="divError" class="alert alert-danger" role="alert">
						<i class="fa fa-remove fa-fw"></i>
						${error}
					</div>
				</g:if>
				<div class="col-lg-12">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-myattributes">
						<thead>
							<tr>
								<th>Name</th>
								<th>Type:</th>
								<th>Created:</th>
								<th>Last modification:</th>
								<th>Options</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${specAttributesListInstance}"
								var="attributeInstance">
								<g:set var="strOptions" value="" />
								<tr class="gradeX">
									<td>
										${attributeInstance.name}
									</td>
									<td>
										${attributeInstance.tipo}
									</td>
									<td>
										${formatDate(format: 'HH:mm - dd/MMM/yyyy', date: attributeInstance.submitDate)}
									</td>
									<td>
										${formatDate(format: 'HH:mm - dd/MMM/yyyy', date: attributeInstance.modifyDate)}
									</td>
									<td><g:if test="${attributeInstance.tipo != "list"}">
                            				--
                            			</g:if> <g:else>
											<g:each in="${attributeInstance.options}"
												var="optionInstance">
												<g:if test="${optionInstance != '--'}">
													<p>
														${optionInstance}
													</p>
													<% strOptions += optionInstance + ";" %>
												</g:if>
											</g:each>
										</g:else></td>
									<td>
										<button title="Edit Attribute" type="button"
											class="btn btn-default btn-circle" data-toggle="modal"
											data-target="#myModalEditAttribute"
											onclick="getAttributeForEdit('${attributeInstance.id.toString()}','${attributeInstance.name.toString()}','${attributeInstance.tipo.toString()}','${strOptions}')">
											<i class="fa fa-edit"></i>
										</button> <g:if test="${slrInstance.noDrop == false}">
											<button title="Delete Specific Attribute" type="button"
												class="btn btn-default btn-circle" data-toggle="modal"
												data-target="#myModalDrop"
												onclick="getIdAttribute('${attributeInstance.id.toString()}')">
												<i class="fa fa-times"></i>
											</button>
										</g:if> <g:else>
											<button title="Delete Specific Attribute" type="button"
												class="btn btn-default btn-circle disabled"
												data-toggle="modal" data-target="#myModalDrop">
												<i class="fa fa-times"></i>
											</button>
										</g:else>
									</td>
								</tr>
							</g:each>
						</tbody>
					</table>

				</div>

			</div>
		</div>
		<!-- /#page-wrapper -->

		<%-- Foot --%>
		<g:render template="foot" contextPath="/" />

	</div>
	<!-- /#wrapper -->

	<%-- JavaScript --%>
	<g:render template="javascript" contextPath="/" />

	<script
		src="${resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js')}"></script>
	<script
		src="${resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js')}"></script>

	<script type="text/javascript">
	    $(document).ready(function() {
	        $('#dataTables-myattributes').DataTable({
	                responsive: true
	        });
	    });
    </script>

</body>

</html>
