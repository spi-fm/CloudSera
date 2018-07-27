<%@ page import="es.uca.pfc.User" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>CloudSERA | Friends</title>
    <link rel="icon" href="https://github.com/spi-fm/CloudSERA/raw/master/images/CloudSERA-sm.jpeg">

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
                    <h1 class="page-header">Friends</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <div class="row">
                <div class="col-lg-12">

					<table class="table table-striped table-bordered table-hover" id="dataTables-users">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Usename</th>
                                <th>Email</th>
                                 <th>Login date</th>
                                <th>Last visited</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${userProfileListInstance}" var="userProfileInstance" status="i">
                            	<tr class="gradeX">
                            		<td>${i+1}</td>
                            		<td>
                            			<g:if test="${userProfileInstance.isOnline}">
	                            			<i class="fa fa-user fa-fw" style="color: green;"></i> ${userProfileInstance.display_name}
                            			</g:if>
                            			<g:else>
                            				<i class="fa fa-user fa-fw" style="color: blue;"></i> ${userProfileInstance.display_name}
                            			</g:else>
                            		</td>
                            		<td><g:link controller="user" action="show" params="[guid: "${userProfileInstance.guid}"]">${userProfileInstance.user.username}</g:link></td>
                             		<td>${formatDate(format: 'dd/MMM/yyyy', date: userProfileInstance.fechaRegistro)}</td>
                            		<td>${formatDate(format: 'dd/MMM/yyyy', date: userProfileInstance.ultimaConexion)}</td>
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
	        $('#dataTables-users').DataTable({
	                responsive: true
	        });
	    });
    </script>

</body>

</html>
