<%@ page import="es.uca.pfc.User" %>
<%@ page import="es.uca.pfc.Slr" %>
<%@ page import="es.uca.pfc.Criterion" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>SLR | Create SLR (Wizard)</title>

	<%-- CSS --%>
    <g:render template="css" contextPath="/"/>
	<script type="text/javascript">
		function getIdCriterion(id)
		{
			document.getElementById("idCriterion").value = id.toString();
			document.getElementById('divErrorCriterion').style.display = "none";
		}	
		function getCriterionForEdit(id,name,description)
		{
			document.getElementById("idEditCriterion").value = id.toString();
			document.getElementById("nombreEdit").value = name.toString();
			document.getElementById("descripcionEdit").value = description.toString();
			document.getElementById('divErrorEditCriterion').style.display = "none";
		}
		function loadModal()
		{
			if(${null != errorCriterion && errorCriterion != ""})
			{
				$('#myModalCriterion').modal('show');
			}
			else if (${successCriterion})
			{
				document.getElementById('divSuccessCriterion').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccessCriterion').style.display = "none";
				}, 5000);
			}

			if(${null != errorEditCriterion && errorEditCriterion != ""})
			{
				$('#myModalEditCriterion').modal('show');
			}
			else if (${successEditCriterion})
			{
				document.getElementById('divSuccessEditCriterion').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccessEditCriterion').style.display = "none";
				}, 5000);
			}
		}
		function getIdSlr(id)
		{
			document.getElementById("guidSlr").value = id.toString();
			document.getElementById('divErrorCriterion').style.display = "none";
		}
	</script>
</head>

<body onload="loadModal();">

	<%--Ventana modal crear criterio --%>
	<div class="modal fade" id="myModalCriterion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
	    	<div class="modal-content">
	    		<div class="modal-header">
      				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      				<h4 class="modal-title" id="myModalLabel">Create criterion</h4>
			    </div>
		    	<g:form controller="wizardSlr" action="saveCriterions" method="POST" name="myFormCriterion" id="myFormCriterion">
		    		<g:hiddenField name="guidSlr" value="${slrInstance.guid}" />
		    		<div class="modal-body">
				    	<g:if test="${null != errorCriterion && !errorCriterion.equals("")}">
					    	<div id="divErrorCriterion" class="alert alert-danger" role="alert"><i class="fa fa-remove fa-fw"></i> ${errorCriterion}</div>
				    	</g:if>
				    	<div class="form-inline">
				    		<table>
				    			<tr>
				    				<td><b>Name:</b></td>
				    				<td><input id="nombre" type="text" name="nombre" class="form-control" value="${nombreCriterion}" /></td>
				    			</tr>
				    			<tr>
				    				<td><b>Description:</b></td>
				    				<td><textarea id="descripcion" class="form-control" name="descripcion" style="resize: none; width: 400px; height: 80px;">${descripcionCriterion}</textarea></td>
				    			</tr>
				    		</table>
				    	</div>
				    </div>
				    <div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
						<g:submitButton name="create" class="btn btn-primary" value="Create Criterion"/>
					</div>
				</g:form>
		    </div>
		</div>
    </div>
    
    <%--Ventana modal editar criterio --%>
	<div class="modal fade" id="myModalEditCriterion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
	    	<div class="modal-content">
	    		<div class="modal-header">
      				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      				<h4 class="modal-title" id="myModalLabel">Edit criterion</h4>
			    </div>
		    	<g:form controller="wizardSlr" action="editCriterions" method="POST" name="myFormEditCriterion" id="myFormEditCriterion">
		    		<g:hiddenField name="guidSlr" value="${slrInstance.guid}" />
		    		<g:hiddenField name="idEditCriterion" value="${idEditCriterion}" />
		    		<div class="modal-body">
				    	<g:if test="${null != errorEditCriterion && !errorEditCriterion.equals("")}">
					    	<div id="divErrorEditCriterion" class="alert alert-danger" role="alert"><i class="fa fa-remove fa-fw"></i> ${errorEditCriterion}</div>
				    	</g:if>
				    	<div class="form-inline">
				    		<table>
				    			<tr>
				    				<td><b>Name:</b></td>
				    				<td><input id="nombreEdit" type="text" name="nombreEdit" class="form-control" value="${nombreEditCriterion}" /></td>
				    			</tr>
				    			<tr>
				    				<td><b>Description:</b></td>
				    				<td><textarea id="descripcionEdit" class="form-control" name="descripcionEdit" style="resize: none; width: 400px; height: 80px;">${descripcionEditCriterion}</textarea></td>
				    			</tr>
				    		</table>
				    	</div>
				    </div>
				    <div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
						<g:submitButton name="create" class="btn btn-primary" value="Edit Criterion"/>
					</div>
				</g:form>
		    </div>
		</div>
    </div>

	<%-- Ventana modal para eliminar criterio --%>
    <div class="modal fade" id="myModalDrop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Delete criterion</h4>
				</div>
				<%--<g:form url="[action:'delete']" method="DELETE"> --%>
				<g:form controller="wizardSlr" action="deleteCriterions" id="myFormDelete" name="myFormDelete" method="DELETE">
					<g:hiddenField name="idCriterion" value="0" />
					<g:hiddenField name="guidSlr" value="${slrInstance.guid}" />
		    		<div class="modal-body">
						If you delete this criterion, all references with this criterion will be replacec for the 'included' criterion.
						<p> </p>
						<p>Do you want to delete this criterion ?</p>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">No</button>
						<g:submitButton id="boton" name="boton" class="btn btn-primary" value="Yes"/>
					</div>
				</g:form>
			</div>
		</div>
	</div>

    <div id="wrapper">

        <%-- Head --%>
        <g:render template="head" contextPath="/"/>
        
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
						<li><a href="#">4. Specific Attributes</a></li>
						<li><a href="#">Finish!!</a></li>
					</ul>
            	</div>
            </div>
            
           	<div class="row" style="padding-top: 20px;">
           		<h3>3. Criterions</h3>
           		<div class="col-lg-6" align="left">
   	        		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalCriterion">Create criterion</button>
           		</div>
       			<div class="col-lg-6" align="right">
       				<g:link class="btn btn-primary" controller="wizardSlr" action="createSpecAttributes" onclick="closeModalWithMessage('myModal','Creating Criterions...');" params="[guid: "${slrInstance.guid}"]">Create Specific Attributes</g:link>
       			</div>
           	</div>
            <div class="row" style="padding-top: 20px;">
                <g:if test="${null != error && !error.equals("")}">
			    	<div id="divError" class="alert alert-danger" role="alert"><i class="fa fa-remove fa-fw"></i> ${error}</div>
		    	</g:if>
            	<div class="col-lg-12">
                  	<table class="table table-striped table-bordered table-hover" id="dataTables-mycriterions">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Created:</th>
                                <th>Description</th>
                                <th>References assigned</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${criterionListInstance}" var="criterionInstance">
                            	<g:set var="contReference" value="0" />
                            	<tr class="gradeX">
                            		<td>${criterionInstance.name}</td>
                            		<td>${formatDate(format: 'dd/MMM/yyyy HH:mm', date: criterionInstance.submitDate)}</td>
                            		<td>${criterionInstance.description}</td>
                            		<td>
                            			<g:if test="${null == totalReferences.get(criterionInstance.name)}">
                            				0
                            			</g:if>
                            			<g:else>
                            				${totalReferences.get(criterionInstance.name).value}
                            			</g:else>
                            		</td>
                            		<td>
                            			<g:if test="${slrInstance.noDrop == false && criterionInstance.nomenclatura != "cr_included"}">
											<button title="Edit Criterion" type="button" class="btn btn-default btn-circle" data-toggle="modal" data-target="#myModalEditCriterion" onclick="getCriterionForEdit('${criterionInstance.id.toString()}','${criterionInstance.name.toString()}','${criterionInstance.description.toString()}')"><i class="fa fa-edit"></i></button>
                            				<button title="Eliminar criterio" type="button" class="btn btn-default btn-circle" data-toggle="modal" data-target="#myModalDrop" onclick="getIdCriterion('${criterionInstance.id.toString()}')"><i class="fa fa-times"></i></button>
										</g:if>
										<g:else>
											<button title="Edit Criterion" type="button" class="btn btn-default btn-circle disabled" data-toggle="modal" data-target="#myModalEditCriterion"><i class="fa fa-edit"></i></button>
                            				<button title="Eliminar criterio" type="button" class="btn btn-default btn-circle disabled" data-toggle="modal" data-target="#myModalDrop"><i class="fa fa-times"></i></button>
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
        <g:render template="foot" contextPath="/"/>

    </div>
    <!-- /#wrapper -->

    <%-- JavaScript --%>
    <g:render template="javascript" contextPath="/"/>
    
    <script src="${resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js')}"></script>
	<script src="${resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js')}"></script>
	
	<script type="text/javascript">
	    $(document).ready(function() {
	        $('#dataTables-mycriterions').DataTable({
	                responsive: true
	        });
	    });
    </script>

</body>

</html>
