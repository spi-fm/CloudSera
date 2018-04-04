<%@ page import="es.uca.pfc.User" %>
<%@ page import="es.uca.pfc.Slr" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>SLR | My List</title>

	<%-- CSS --%>
    <g:render template="css" contextPath="/"/>

	<script type="text/javascript">
		function loadModal()
		{
			if(${null != error && error != ""})
			{
				$('#myModal').modal('show');
			}
			else if(${null != errorCriterion && errorCriterion != ""})
			{
				$('#myModalCriterion').modal('show');
			}
			else if(${null != errorAttribute && errorAttribute != ""})
			{
				$('#myModalAttribute').modal('show');
				if (${tipoAttribute == 'list'})
				{
					document.getElementById("opciones").disabled = false;
				}
			}
			else if(${null != errorQuestion && errorQuestion != ""})
			{
				$('#myModalQuestion').modal('show');
			}
			else if (${success})
			{
				document.getElementById('divSuccess').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccess').style.display = "none";
				}, 5000);
			}
			else if (${successCriterion})
			{
				document.getElementById('divSuccessCriterion').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccessCriterion').style.display = "none";
				}, 5000);
			}
			else if (${successAttribute})
			{
				document.getElementById('divSuccessAttribute').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccessAttribute').style.display = "none";
				}, 5000);
			}
			else if (${successQuestion})
			{
				document.getElementById('divSuccessQuestion').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divSuccessQuestion').style.display = "none";
				}, 5000);
			}
			else if (${null != errorSynchro && errorSynchro != ""})
			{
				document.getElementById('divErrorSynchro').style.display = "";
				//setTimeout(hideSuccess, 5000);
				setTimeout(function(){
					document.getElementById('divErrorSynchro').style.display = "none";
				}, 5000);
			}
		}
		function getIdSlr(id)
		{
			document.getElementById("guidSlr").value = id.toString();
			document.getElementById("guidSlrCriterion").value = id.toString();
			document.getElementById("guidSlrAttribute").value = id.toString();
			document.getElementById("guidSlrQuestion").value = id.toString();
			document.getElementById('divError').style.display = "none";
		}
		function typeChange()
		{
			if(document.getElementById("tipo").value == "list")
			{
				document.getElementById("opciones").disabled = false;
			}
			else
			{
				document.getElementById("opciones").disabled = true;
			}
		}
	</script>
	
</head>

<body onload="loadModal();">

	<%--Ventana modal crear slr --%>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
	    	<div class="modal-content">
	    		<div class="modal-header">
      				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      				<h4 class="modal-title" id="myModalLabel">Create SLR</h4>
			    </div>
		    	<g:form controller="slr" action="save" method="POST" name="myForm" id="myForm">
		    		<div class="modal-body">
				    	<g:if test="${null != error && !error.equals("")}">
					    	<div id="divError" class="alert alert-danger" role="alert"><i class="fa fa-remove fa-fw"></i> ${error}</div>
				    	</g:if>
				    	<div class="form-inline">
				    		<table>
				    			<tr style="padding-bottom: 20px;">
				    				<td><b>Title:</b></td>
				    				<td><div id="in-tit-slr" class="input-group"><span class="input-group-addon" id="basic-addon1">SLR</span><input id="titulo" type="text" name="titulo" class="form-control" value="${tituloSlr}" aria-describedby="in-tit-slr" style="width: 350px;" /></div></td>
				    			</tr>
				    			<tr>
				    				<td><b>Justification:</b></td>
				    				<td><textarea id="justificacion" class="form-control" name="justificacion" style="resize: none; width: 400px; height: 80px;">${justificacionSlr}</textarea></td>
				    			</tr>
				    		</table>
				    	</div>
				    </div>
				    <div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
						<g:submitButton name="create" class="btn btn-primary" value="Crear Slr" onclick="closeModalWithMessage('myModal','Creating SLR...');" />
					</div>
				</g:form>
		    </div>
		</div>
    </div>
    
    <%-- Ventana modal para eliminar slr --%>
    <div class="modal fade" id="myModalDrop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Delete SLR</h4>
				</div>
				<%--<g:form url="[action:'delete']" method="DELETE"> --%>
				<g:form controller="slr" action="delete" id="myFormDelete" name="myFormDelete" method="DELETE">
					<g:hiddenField name="guidSlr" value="0" />
					<div class="modal-body">
						Do you delete this SLR ?
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" type="button">No</button>
						<!--<g:submitButton id="boton" name="boton" class="btn btn-primary" value="Sí"/>-->
						<g:submitButton id="boton" name="boton" class="btn btn-primary" value="Yes" onclick="closeModalWithMessage('myModalDrop','Deleting SLR...');" />
					</div>
				</g:form>
			</div>
		</div>
	</div>
	
	<%-- Ventana modal para sincronizar slr's --%>
    <div class="modal fade" id="myModalSynchro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Synchronize SLR</h4>
				</div>
				<div class="modal-body">
					<b>Warning:</b> If you do the synchro all information will be replaced with Mendeley's info.
					If the web has any information of any SLR or reference that are deletes in Mendeley, will be deletes.
					<p>Do you want to continue with the synchronization ?</p>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal" type="button">No</button>
					<g:link type="button" class="btn btn-primary" controller="slr" action="syncronizeListSlrMendeley" onclick="closeModalWithMessage('myModalSynchro','Sinchronize with Mendeley...');">Yes</g:link>
				</div>
			</div>
		</div>
	</div>

    <div id="wrapper">
        <%-- Head --%>
        <g:render template="head" contextPath="/"/>
                
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">My SLR List</h1>
                    
           			<ol class="breadcrumb">
					  <li><g:link controller="index" action="menu">Home</g:link></li>
					  <li class="active">Slr List</li>
					</ol>
					
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <div class="row">
		    	<div id="divSuccess" class="alert alert-success" role="alert" style="display: none;"><i class="fa fa-check fa-fw"></i> SLR creaded correctly.</div>
            	<div id="divSuccessCriterion" class="alert alert-success" role="alert" style="display: none;"><i class="fa fa-check fa-fw"></i> Criterion created correctly.</div>
            	<div id="divSuccessAttribute" class="alert alert-success" role="alert" style="display: none;"><i class="fa fa-check fa-fw"></i> Attribute created correctly</div>
            	<div id="divSuccessQuestion" class="alert alert-success" role="alert" style="display: none;"><i class="fa fa-check fa-fw"></i> Research question created correctly.</div>
            	<div id="divErrorSynchro" class="alert alert-danger" role="alert" style="display: none;"><i class="fa fa-remove fa-fw"></i> Synchro problems. Try later.</div>
            	<div class="col-lg-12">
                	<div style="margin-top: 5px; margin-bottom: 20px;">
	                	<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Create SLR</button>
	                	<g:link type="button" class="btn btn-success" controller="wizardSlr" action="createSLR">Create SLR (with wizard)</g:link>
	                	<!--<g:link type="button" class="btn btn-primary" controller="slr" action="syncronizeListSlrMendeley" onclick="loading('Sincronizando con Mendeley...');">Sincronizar (Mendeley)</g:link>-->
	                	<button title="Sincronizar (Mendeley)" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalSynchro">Sinchronize (Mendeley)</button>
	                	<button type="button" class="btn btn-info" data-html="true" data-toggle="popover" title="Información"><i class="fa fa-info"></i> Info</button>
	            	</div>
					<table class="table table-striped table-bordered table-hover" id="dataTables-myslrs">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>State</th>
                                <th>Created</th>
                                <th>Nº Searches</th>
                                <th>Nº References</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${slrListInstance}" var="slrInstance">
                            	<tr class="gradeX">
                            		<td><g:link controller="slr" action="show" params="[guidSlr: "${slrInstance.guid}"]">${slrInstance.title}</g:link></td>
                            		<td>
                            			<g:if test="${slrInstance.state.equals("fase1")}">
                            				Review Planning
                            			</g:if>
                            			<g:if test="${slrInstance.state.equals("fase2")}">
                            				Review Execution
                            			</g:if>
                            			<g:if test="${slrInstance.state.equals("fase3")}">
                            				Export Results
                            			</g:if>
                            		</td>
                            		<td>${formatDate(format: 'dd/MMM/yyyy', date: slrInstance.submitDate)}</td>
                            		<td>
                            			<g:if test="${slrInstance.searchs.size() > 0}">
                            				<g:link controller="slr" action="searchs" params="[guid: "${slrInstance.guid}"]">${slrInstance.searchs.size()} Searches</g:link>
                            			</g:if>
                            			<g:else>
                            				${slrInstance.searchs.size()} Searches
                            			</g:else>
                            		</td>
                            		<td>
                            			<g:if test="${slrInstance.totalReferences > 0}">
                            				<g:link controller="slr" action="references" params="[guid: "${slrInstance.guid}"]">${slrInstance.totalReferences} References</g:link>
                            			</g:if>
                            			<g:else>
                            				${slrInstance.totalReferences} References
                            			</g:else>
                            		</td>
                            		<td>
										<g:link title="Research Questions" type="button" class="btn btn-outline btn-primary btn-circle" controller="slr" action="researchQuestions" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-question"></i></g:link>
										<g:link title="Criterions" class="btn btn-outline btn-primary btn-circle" controller="slr" action="criterions" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-bookmark"></i></g:link>
										<g:link title="Specific Attributes" class="btn btn-outline btn-primary btn-circle" controller="slr" action="specAttributes" params="[guid: "${slrInstance.guid}"]"><i class="glyphicon glyphicon-tags"></i></g:link>
										<g:link title="Searchs" type="button" class="btn btn-outline btn-primary btn-circle" controller="slr" action="searchs" params="[guid: "${slrInstance.guid}"]"><i class="glyphicon glyphicon-search"></i></g:link>
										<g:if test="${slrInstance.noDrop == false}">
											<button title="Delete SLR" type="button" class="btn btn-outline btn-danger btn-circle" data-toggle="modal" data-target="#myModalDrop" onclick="getIdSlr('${slrInstance.guid}')"><i class="fa fa-times"></i></button>
										</g:if>
										<p> </p>
										<g:link title="Export Excel" type="button" class="btn btn-outline btn-success btn-circle" controller="slr" action="exportToExcel" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-file-excel-o"></i></g:link>
										<!--<g:link title="Exportar a PDF" type="button" class="btn btn-outline btn-success btn-circle" controller="slr" action="exportToPdf" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-file-pdf-o"></i></g:link>-->
										<g:link title="Export Word" type="button" class="btn btn-outline btn-success btn-circle" controller="slr" action="exportToWord" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-file-word-o"></i></g:link>
										<g:link title="Export Bibtex" type="button" class="btn btn-outline btn-success btn-circle" controller="slr" action="exportToBibTex" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-file-code-o"></i></g:link>
										<g:link title="Graphs" type="button" class="btn btn-outline btn-success btn-circle" controller="slr" action="graphs" params="[guid: "${slrInstance.guid}"]"><i class="glyphicon glyphicon-stats"></i></g:link>
                            		</td>
                            	</tr>
                            </g:each>
                        </tbody>
                    </table>	
                    
                </div>

            </div>
            <!-- /.row -->
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
	        $('#dataTables-myslrs').DataTable({
	                responsive: true
	        });
	        $('[data-toggle="popover"]').popover({
	        	content: '<g:render template="slrInfo" contextPath="/slr"/>'
	        }); 
	    });
    </script>

</body>

</html>
