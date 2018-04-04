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

</head>

<body>	
    <div id="wrapper">

        <%-- Head --%>
        <g:render template="head" contextPath="/"/>
        
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create SLR (Wizard)</h1>
                    
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
						<li><a href="#">2. Researchs Questions</a></li>
						<li><a href="#">3. Criterions</a></li>
						<li><a href="#">4. Specific Attributes</a></li>
						<li><a href="#">Finish!!</a></li>
					</ul>
            	</div>
            </div>
            
            <div class="row" style="padding-top: 20px;">
                <g:if test="${null != error && !error.equals("")}">
			    	<div id="divError" class="alert alert-danger" role="alert"><i class="fa fa-remove fa-fw"></i> ${error}</div>
		    	</g:if>
				<g:form class="form-horizontal" controller="wizardSlr" action="saveSLR" method="POST" name="myForm" id="myForm">
	            	<div class="col-lg-12">
	            		<h3>1. Need of SLR</h3>
	            	</div>
	            	<div class="col-lg-12">    
	            		<div class="form-group">
							<label for="inputTitle" class="col-sm-2 control-label">Title</label>
							<div class="col-sm-6 input-group" id="in-tit-slr">
								<span class="input-group-addon" id="basic-addon1">SLR</span>
								<input aria-describedby="in-tit-slr" type="text" class="form-control" id="titulo" name="titulo" placeholder="Title" value="${tituloSlr}">
							</div>
							<div class="col-sm-4"></div>
						</div>
						<div class="form-group">
							<label for="inputJustification" class="col-sm-2 control-label">Justification</label>
							<div class="col-sm-6 input-group"><textarea id="justificacion" class="form-control" name="justificacion" style="resize: none; height: 200px;">${justificacionSlr}</textarea></div>
							<div class="col-sm-4"></div>
						</div>
	            	</div>
	            	<div class="col-lg-12">
            			<div class="col-sm-6"></div>
	            		<div class="col-sm-6">
		            		<g:submitButton name="create" class="btn btn-primary" value="Create Research Questions" onclick="closeModalWithMessage('myModal','Creating SLR...');" />
	            		</div>
	            	</div>
	            </g:form>
            </div>

        </div>
        <!-- /#page-wrapper -->

		<%-- Foot --%>
        <g:render template="foot" contextPath="/"/>

    </div>
    <!-- /#wrapper -->

    <%-- JavaScript --%>
    <g:render template="javascript" contextPath="/"/>

</body>

</html>
