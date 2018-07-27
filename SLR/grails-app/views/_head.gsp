<%@ page import="es.uca.pfc.User" %>
<!-- Navigation -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header" style="width: 500px;">
        <g:link class="navbar-brand" controller="index" action="index" style="font-size: 25px;">
        	${(request.forwardURI.contains("references") ? 'SLR' : 'CloudSERA')}
        </g:link>

        <%-- Aqui incluimos las opciones en caso de estar en references --%>


    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

        <li id="liTemplate" class="dropdown">
	        <g:include controller='index' action='loadNotifications' />
        </li>

        <li id="liSearchTask" class="dropdown">
	        <g:include controller='index' action='loadTaskSearchsHead' />
        </li>

        <!-- <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-comment fa-fw"></i> New Comment
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                            <span class="pull-right text-muted small">12 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-envelope fa-fw"></i> Message Sent
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-tasks fa-fw"></i> New Task
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>See All Alerts</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
        </li>-->
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> ${User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.display_name} <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li>
                	<g:link controller="user" action="show" params="[guid: "${User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.guid}"]"><i class="fa fa-user fa-fw"></i> <g:message code="pfc.main.top.profile" locale="${languageDefault}" /></g:link>
                </li>
                <!-- <li><a href="#"><i class="fa fa-gear fa-fw"></i> <g:message code="pfc.main.top.setting" locale="${languageDefault}" /></a> -->
                </li>
                <li class="divider"></li>
                <li><g:link controller="logout"><i class="fa fa-sign-out fa-fw"></i> <g:message code="pfc.main.top.logout" locale="${languageDefault}" /></g:link></li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-form navbar-right">
	   	<g:form class="form-horizontal" controller="searcher" action="search" method="POST" name="myForm" id="myForm">
	       <div class="input-group custom-search-form">
	       		<span class="input-group-btn">
	       			<button class="btn btn-default" type="submit">
						<i class="fa fa-search"></i>
					</button>
				</span>
	       		<input id="query" name="query" type="text" class="form-control" style="width: 300px;" placeholder="<g:message code='pfc.searcher.placeholder' locale='${languageDefault}' />">
		   </div>
	     </g:form>
    </div>


	<%-- Head --%>
    <g:render template="menuleft" contextPath="/"/>

    <!-- /.navbar-static-side -->
</nav>

<script type="text/javascript">
	$(document).ready(
	           function() {
	               setInterval(function() {
	               $('#liTemplate').load('/SLR/index/loadNotifications');
	               $('#liSearchTask').load('/SLR/index/loadTaskSearchsHead');
	               }, 10000);
	           });
</script>
