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
						<li><a href="#">1. Need of SLR</a></li>
						<li><a href="#">2. Researchs Questions</a></li>
						<li><a href="#">3. Criterions</a></li>
						<li><a href="#">4. Specific Attributes</a></li>
						<li class="active"><a href="#">Finish !!</a></li>
					</ul>
            	</div>
            </div>
            
           	<div class="row" style="padding-top: 40px;">
           		<div class="col-lg-2"></div>
           		<div class="col-lg-8">
           			<div class="panel panel-primary">
           				<div class="panel-heading"><b>Congratulations!</b></div>
							<div class="panel-body">
								<p>You have created <b>${slrInstance.title}</b>!</p>
								Now, you can begin to find references in ours engines of searchs!! Click <g:link controller="search" action="create" params="[guidSlr:"${slrInstance.guid}"]"><b>here</b></g:link>!
							</div>
						</div>
					</div>
           		<div class="col-lg-2"></div>
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
	        $('#dataTables-myattributes').DataTable({
	                responsive: true
	        });
	    });
    </script>

</body>

</html>
