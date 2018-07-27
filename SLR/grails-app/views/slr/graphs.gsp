<%@ page import="es.uca.pfc.User" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>CloudSERA | Graphs</title>
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
                    <h1 class="page-header">Graphs ${slrInstance.title}</h1>

                    <ol class="breadcrumb">
					  <li><g:link controller="index" action="menu">Home</g:link></li>
					  <li><g:link controller="slr" action="myList">Review List</g:link></li>
					  <li><g:link controller="slr" action="show" params="[guidSlr: "${slrInstance.guid}"]">${slrBreadCrumb}</g:link></li>
					  <li class="active">Graphs</li>
					</ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <div class="row">

            	<div style="width: 100%;">
            		<ul id="myTab" class="nav nav-tabs">
            			<li class="active"><a href="#criterion" data-toggle="tab">Criterion</a></li>
            			<li><a href="#engine" data-toggle="tab">Engines</a></li>
            			<li><a href="#type" data-toggle="tab">Type Document</a></li>
            			<li><a href="#language" data-toggle="tab">Language</a></li>
            		</ul>

	            	<div id="myTabContent" class="tab-content" align="left">

	            		<div class="tab-pane fade in active" id="criterion" style="padding-top: 25px;">
	            			<div class="row">
	            				<div class="col-lg-3"></div>
	            				<div class="col-lg-6">
		            				<div class="alert alert-info" role="alert">
		            					<i class="fa fa-info"></i> Included References group by criterions.
		            				</div>
	            				</div>
	            				<div class="col-lg-3"></div>
	            			</div>
		            		<div class="row">
		            			<div class="col-lg-1"></div>
		            			<div class="col-lg-10">
		            				<div class="panel panel-default">
				                        <div class="panel-heading">
				                            Total References group by criterions
				                        </div>
				                        <div class="panel-body" style="overflow: hidden;">
				                            <div id="chart_div" align="center"></div>
				                        </div>
				                    </div>
		            			</div>
		                		<div class="col-lg-1"></div>
							</div>
							<div class="row">
		            			<div class="col-lg-1"></div>
		            			<div class="col-lg-10">
		            				<div class="panel panel-default">
				                        <div class="panel-heading">
				                            Total references group by criterions
				                        </div>
				                        <div class="panel-body" style="overflow: hidden;">
				                            <div id="chart_div_2" align="center"></div>
				                        </div>
				                    </div>
		            			</div>
		                		<div class="col-lg-1"></div>
							</div>
							<div class="row">
		            			<div class="col-lg-1"></div>
		            			<div class="col-lg-10">
		            				<div class="panel panel-default">
				                        <div class="panel-heading">
				                            Total references group by criterions
				                        </div>
				                        <div class="panel-body" style="overflow: hidden;">
				                            <div id="chart_div_4" align="center" style="float:left; clear: both;"></div>
				                        </div>
				                    </div>
		            			</div>
		                		<div class="col-lg-1"></div>
							</div>
	            		</div>

	            		<div class="tab-pane fade" id="engine" style="padding-top: 25px;">
							<div class="row">
	            				<div class="col-lg-3"></div>
	            				<div class="col-lg-6">
		            				<div class="alert alert-info" role="alert">
		            					<i class="fa fa-info"></i> Included References group by engines
		            				</div>
	            				</div>
	            				<div class="col-lg-3"></div>
	            			</div>
		            		<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											Total references group by engine
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_6" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											Total references group by engine
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_7" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											Total references group by engine
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_9" align="center" style="float:left; clear: both;"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
	            		</div>

	            		<div class="tab-pane fade" id="type" style="padding-top: 25px;">
	            			<div class="row">
	            				<div class="col-lg-3"></div>
	            				<div class="col-lg-6">
		            				<div class="alert alert-info" role="alert">
		            					<i class="fa fa-info"></i> Included References group by type document.
		            				</div>
	            				</div>
	            				<div class="col-lg-3"></div>
	            			</div>
		            		<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											Total references group by type document.
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_16" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											Total references group by type document.
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_17" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											Total references group by type document.
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_19" align="center" style="float:left; clear: both;"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
	            		</div>
	            		<div class="tab-pane fade" id="language" style="padding-top: 25px;">
	           				<div class="row">
	            				<div class="col-lg-3"></div>
	            				<div class="col-lg-6">
		            				<div class="alert alert-info" role="alert">
		            					<i class="fa fa-info"></i> Included References group by language
		            				</div>
	            				</div>
	            				<div class="col-lg-3"></div>
	            			</div>
		            		<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											References group by language
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_21" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											References group by language
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_22" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											References group by language
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_24" align="center" style="float:left; clear: both;"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
	            		</div>

	            		<div class="tab-pane fade" id="department" style="padding-top: 25px;">

	            			<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											References group by department
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_11" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>

							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											References group by department
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_12" align="center"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<div class="panel panel-default">
										<div class="panel-heading">
											References group by department
										</div>
										<div class="panel-body" style="overflow: hidden;">
											<div id="chart_div_14" align="center" style="float:left; clear: both;"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
							</div>
	            		</div>

	            	</div>
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
    <g:render template="graphsGoogle" contextPath="/graphs"/>
</body>

</html>
