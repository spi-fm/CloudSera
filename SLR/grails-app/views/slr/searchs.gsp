<%@ page import="es.uca.pfc.User" %>
<%@ page import="es.uca.pfc.Slr" %>
<%@ page import="es.uca.pfc.Search" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>CloudSERA | Searchs</title>
    <link rel="icon" href="https://github.com/spi-fm/CloudSERA/raw/master/images/CloudSERA-sm.jpeg">

	<%-- CSS --%>
    <g:render template="css" contextPath="/"/>

	<script type="text/javascript">
	function getIdSearch(id)
	{
		document.getElementById("guidSearch").value = id.toString();
		document.getElementById('divError').style.display = "none";
	}
	function showMessages()
	{
		if (${isCreating})
		{
			document.getElementById('divSearchCreating').style.display = "";
			setTimeout(function(){
				document.getElementById('divSearchCreating').style.display = "none";
			}, 20000);
		}
	}
	</script>
</head>

<body onload="showMessages();">

	<%-- Ventana modal para eliminar slr --%>
    <div class="modal fade" id="myModalDrop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Delete Search</h4>
				</div>
				<%--<g:form url="[action:'delete']" method="DELETE"> --%>
				<g:form controller="search" action="delete" id="myFormDelete" name="myFormDelete" method="DELETE">
					<g:hiddenField name="guidSearch" value="0" />
					<div class="modal-body">
						The delete of this search will remove all references assigneds to the SLR and the own search.
						<p> </p>
						<p>Do you want to delete this search ?</p>
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
                    <h1 class="page-header">Searchs in ${slrInstance.title}</h1>

                    <ol class="breadcrumb">
					  <li><g:link controller="index" action="menu">Home</g:link></li>
					  <li><g:link controller="slr" action="myList">Review List</g:link></li>
					  <li><g:link controller="slr" action="show" params="[guidSlr: "${slrInstance.guid}"]">${slrBreadCrumb}</g:link></li>
					  <li class="active">Searchs</li>
					</ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <div class="row">
            	<div id="divSearchCreating" class="alert alert-info alert-dismissible" role="alert" style="display: none;">
            		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            		<strong><i class="fa fa-search fa-fw"></i> Creating Search</strong> You can see the search's progress <g:link controller="index" action="taskSearchs">here</g:link>.
            	</div>
                <div class="col-lg-12">
                  	<div style="margin-top: 5px; margin-bottom: 20px;">
                  		<g:link controller="search" action="create" class="btn btn-success" params="[guidSlr:"${slrInstance.guid}"]">Create search</g:link>
	            	</div>
					<table class="table table-striped table-bordered table-hover" id="dataTables-mysearchs">
                        <thead>
                            <tr>
                                <th>Created<br/>in:</th>
                                <th>Start<br/>year</th>
                                <th>End<br/>year</th>
                                <th>Total<br/>Max</th>
                                <th>founds:</th>
                                <th>Engines</th>
                                <th>Terms</th>
                                <!-- <th>Acciones</th> -->
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${searchListInstance}" var="searchInstance">
                            	<tr class="gradeX">
                            		<td>${formatDate(format: 'dd/MMM/yyyy HH:mm:ss', date: searchInstance.fecha)}</td>
                            		<td>${searchInstance.startYear}</td>
                            		<td>${searchInstance.endYear}</td>
                            		<td>${searchInstance.maxTotal}</td>
                            		<td><g:link controller="slr" action="references" params="[guid: "${searchInstance.slr.guid}"]">${searchInstance.references.size()} Referencias</g:link></td>
                            		<td>
                            			<ul>
                            				<g:each in="${searchInstance.engines}" var="engine">
                            					<li>${engine.name}</li>
                            				</g:each>
                            			</ul>
                            		</td>
                            		<td>
                            			<ul>
	                            			<g:each in="${searchInstance.termParams}" var="searchTermParam">
	                            				<li>${searchTermParam.operator.name} "${searchTermParam.terminos}" <b>en</b> <em>${searchTermParam.component.name}</em></li>
	                            			</g:each>
	                            		</ul>
                            		</td>
                            		<!-- <td>
                            			<g:if test="${slrInstance.noDrop == false}">
											<button title="ELiminar búsqueda" type="button" class="btn btn-default btn-circle" data-toggle="modal" data-target="#myModalDrop" onclick="getIdSearch('${searchInstance.guid}')"><i class="fa fa-times"></i></button>
										</g:if>
										<g:else>
											<button title="ELiminar búsqueda" type="button" class="btn btn-default btn-circle disabled" data-toggle="modal" data-target="#myModalDrop"><i class="fa fa-times"></i></button>
										</g:else>
                            		</td> -->
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
	        $('#dataTables-mysearchs').DataTable({
	                responsive: true
	        });
	    });
    </script>

</body>

</html>
