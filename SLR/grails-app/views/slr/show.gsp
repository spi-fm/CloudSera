<%@ page import="es.uca.pfc.User" %>
<%@ page import="es.uca.pfc.Slr" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>CloudSERA | ${slrInstance.title}</title>
    <link rel="icon" href="https://github.com/spi-fm/CloudSERA/raw/master/images/CloudSERA-sm.jpeg">

	<%-- CSS --%>
    <g:render template="css" contextPath="/"/>

	<script type="text/javascript">
	function getIdSlr(id)
	{
		document.getElementById("guidSlr").value = id.toString();
		document.getElementById("guidSlrCriterion").value = id.toString();
		document.getElementById("guidSlrAttribute").value = id.toString();
		document.getElementById("guidSlrQuestion").value = id.toString();
		document.getElementById('divError').style.display = "none";
	}
	</script>

</head>

<body>
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
						Do you really want to delete this SLR ?
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

  <div class="modal fade" id="myEditDrop" tabindex="-1" role="dialog" aria-labelledby="myEditLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
  				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  				<h4 class="modal-title">Edit SLR</h4>
  			</div>
  			<g:form controller="slr" action="edit">
  				<g:hiddenField name="id" value="${slrInstance.id}" />
          <div>
            Justificacion: <g:textField name="justification" value="${slrInstance.justification}" /><BR>
            Objectives: <g:textField name="objectives" value="Objetivos del review" /><BR>
            Threats to validity: <g:textField name="threats_to_validity" value="Aplicación, interés, errores sistematicos..." /><BR>
            Conclusion: <g:textField name="conclusions" value="Conclusiones del review" /><BR>
          </div>
  				<div class="modal-footer">
  					<button class="btn btn-default" data-dismiss="modal" type="button">No</button>
  					<!--<g:submitButton id="boton" name="boton" class="btn btn-primary" value="Sí"/>-->
            <g:submitButton name="boton" class="btn btn-primary" value="Yes" onclick="closeModalWithMessage('myModalDrop','Editing SLR...');" />
  				</div>
  			</g:form>
  		</div>
  	</div>
  </div>

  <div class="modal fade" id="friendShare" tabindex="-1" role="dialog" aria-labelledby="shareLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
  				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  				<h4 class="modal-title">Share SLR</h4>
  			</div>
  			<g:form controller="slr" action="shareWithFriend">
  				<g:hiddenField name="id" value="${slrInstance.id}" />
          <div>
            <g:each in="${friendListInstance}" var="user">
              <p> ${user.username} </p>
            </g:each>
          </div>
  				<div class="modal-footer">
  					<button class="btn btn-default" data-dismiss="modal" type="button">No</button>
  					<!--<g:submitButton id="boton" name="boton" class="btn btn-primary" value="Sí"/>-->
            <g:submitButton name="boton" class="btn btn-primary" value="Yes" onclick="closeModalWithMessage('friendShare','Editing SLR...');" />
  				</div>
  			</g:form>
  		</div>
  	</div>
  </div>

	<g:form>

	    <div id="wrapper">

	        <%-- Head --%>
	        <g:render template="head" contextPath="/"/>

	        <div id="page-wrapper">
				<div class="row" style="margin-bottom: 20px;">
					<div class="col-lg-12">
						<h1 class="page-header">${slrInstance.title}</h1>

						<ol class="breadcrumb">
						  <li><g:link controller="index" action="menu">Home</g:link></li>
						  <li><g:link controller="slr" action="myList">Review List</g:link></li>
						  <li><g:link controller="slr" action="show" params="[guidSlr: "${slrInstance.guid}"]">${slrBreadCrumb}</g:link>
						  <li class="active">Graphs</li>
						</ol>

						<!-- <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModalDrop">Eliminar SLR</button> -->
					</div>
					<div class="col-lg-12">
						<button type="button" class="btn btn-info" data-html="true" data-toggle="popover" title="Información"><i class="fa fa-info"></i> Info</button>
						<g:link title="Research Questions" type="button" class="btn btn-primary" controller="slr" action="researchQuestions" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-question"></i> Researchs Questions</g:link>
						<g:link title="Criterions" class="btn btn-primary" controller="slr" action="criterions" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-bookmark"></i> Criterions</g:link>
						<g:link title="Specific Attributes" class="btn btn-primary" controller="slr" action="specAttributes" params="[guid: "${slrInstance.guid}"]"><i class="glyphicon glyphicon-tags"></i> Specific Attributes</g:link>
						<g:link title="Searchs" type="button" class="btn btn-primary" controller="slr" action="searchs" params="[guid: "${slrInstance.guid}"]"><i class="glyphicon glyphicon-search"></i> Searchs</g:link>
            <button title="Edit SLR" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myEditDrop" onclick="getIdSlr('${slrInstance.guid}')">Edit</button>
            <button title="Share SLR" type="button" class="btn btn-primary" data-toggle="modal" data-target="#friendShare" onclick="getIdSlr('${slrInstance.guid}')">Share</button>
            <button title="Delete SLR" type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModalDrop" onclick="getIdSlr('${slrInstance.guid}')"><i class="fa fa-times"></i> Delete</button>
					</div>
					<div class="col-lg-12" style="padding-top: 5px;">
						<g:link title="Export Excel" type="button" class="btn btn-success" controller="slr" action="exportToExcel" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-file-excel-o"></i> Excel</g:link>
						<g:link title="Export Word" type="button" class="btn btn-success" controller="slr" action="exportToWord" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-file-word-o"></i> Word</g:link>
						<g:link title="Export Bibtex" type="button" class="btn btn-success" controller="slr" action="exportToBibTex" params="[guid: "${slrInstance.guid}"]"><i class="fa fa-file-code-o"></i> Bibtex</g:link>
						<g:link title="Graphs" type="button" class="btn btn-success" controller="slr" action="graphs" params="[guid: "${slrInstance.guid}"]"><i class="glyphicon glyphicon-stats"></i> Graphs</g:link>
					</div>
				</div>

				<h4><u>Information</u></h4>
				<div class="row">
					<div class="col-lg-1">

					</div>
					<div class="col-lg-5">
						<p><b>Title: </b>${slrInstance.title}</p>
						<p><b>Created by: </b><g:link controller="user" action="show" params="[guid: "${slrInstance.userProfile.guid}"]">${slrInstance.userProfile.display_name}</g:link></p>
						<p><b>Total Searchs: </b>
						<g:if test="${slrInstance.searchs.size() > 0}">
							<g:link controller="slr" action="searchs" params="[guid: "${slrInstance.guid}"]">${slrInstance.searchs.size()} searchs</g:link>
						</g:if>
						<g:else>
							${slrInstance.searchs.size()} searchs
						</g:else>
						</p>
						<p><b>Total References: </b>
						<g:if test="${slrInstance.totalReferences > 0}">
							<g:link controller="slr" action="references" params="[guid: "${slrInstance.guid}"]">${slrInstance.totalReferences} references</g:link>
						</g:if>
						<g:else>
							${slrInstance.totalReferences} references
						</g:else>
						</p>
						<p><b>Justification:</b></p>${slrInstance.justification}
					</div>
					<div class="col-lg-5">
						<g:if test="${slrInstance.questions.size() > 0}">
						<p><b>Research Questions</b></p>
						<ul>
							<g:each in="${slrInstance.questions}" var="questionInstance">
								<li>${questionInstance.enunciado}</li>
							</g:each>
						</ul>
						</g:if>
						<%--<p><b>Actions</b></p>
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
						 --%>
					</div>
				</div>

				<div class="row" style="margin-top: 20px;">
					<div class="col-lg-6">
						<div class="panel panel-default">
	                        <div class="panel-heading">
	                            <b>Criterions</b>
	                        </div>
	                        <div class="panel-body" style="overflow: hidden;">
	                            <div id="chart_div" align="center"></div>
	                        </div>
	                    </div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
	                        <div class="panel-heading">
	                            <b>Criterions</b>
	                        </div>
	                        <div class="panel-body" style="overflow: hidden;">
	                            <div id="chart_div_4" align="center"></div>
	                        </div>
	                    </div>
					</div>
				</div>
			</div>
			<!-- /#page-wrapper -->

			<%-- Foot --%>
    	    <g:render template="foot" contextPath="/"/>

	    </div>
	    <!-- /#wrapper -->
    </g:form>

    <%-- JavaScript --%>
    <g:render template="javascript" contextPath="/"/>
	<g:render template="graphsGoogleSlrView" contextPath="/graphs"/>

	<script type="text/javascript">
	    $(document).ready(function() {
	        $('[data-toggle="popover"]').popover({
	        	content: '<g:render template="slrInfo" contextPath="/slr"/>'
	        });
	    });
	</script>
</body>

</html>
