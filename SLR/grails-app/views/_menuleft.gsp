<%@ page import="es.uca.pfc.User" %>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
	
	<g:if test="${!request.forwardURI.contains("references")}">
		<ul class="nav" id="side-menu">
			<%--<li class="sidebar-search">
				<g:form class="form-horizontal" controller="searcher" action="search" method="POST" name="myForm" id="myForm">
					<div class="input-group custom-search-form">
						<input id="query" name="query" type="text" class="form-control" placeholder="<g:message code='pfc.searcher.placeholder' locale='${languageDefault}' />">
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
					<!-- /input-group -->
				</g:form>
			</li> --%>
			<li>
				<g:link controller="index" action="menu"><i class="fa fa-dashboard fa-fw"></i> <g:message code="pfc.main.left.main.menu" locale="${languageDefault}" /></g:link>
			</li>
			<li>
			    <g:link controller="user" action="show" params="[guid: "${User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.guid.toString()}"]"><i class="fa fa-user fa-fw"></i> <g:message code="pfc.main.left.profile" locale="${languageDefault}" /></g:link>
			</li>
			<g:if test="${!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER")}">
				<li>
			    	<g:link controller="user" action="list"><i class="fa fa-group fa-fw"></i> <g:message code="pfc.main.left.users" locale="${languageDefault}" /></g:link>
				</li>
			</g:if>
			<li>
				<g:link controller="slr" action="myList"><i class="fa fa-folder-open"></i> <g:message code="pfc.main.left.slr" locale="${languageDefault}" /></g:link>
			</li>
			<li>
			    <g:link controller="index" action="loggers"><i class="fa fa-history fa-fw"></i> <g:message code="pfc.main.left.logger" locale="${languageDefault}" /></g:link>
			</li>
			<li>
			    <g:link controller="index" action="faqs"><i class="fa fa-question fa-fw"></i> <g:message code="pfc.main.left.faqs" locale="${languageDefault}" /></g:link>
			</li>
			<g:if test="${!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER")}">
				<li>
					<g:link controller="engineSearch" action="index"><i class="fa fa-university fa-fw"></i> <g:message code="pfc.main.left.engines" locale="${languageDefault}" /></g:link>
				</li>
			</g:if>
			<!--<g:if test="${!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER")}">
				<li>
					<g:link controller="mendeleyApi" action="index"><i class="fa fa-key  fa-fw"></i> Mendeley API</g:link>
				</li>
			</g:if>-->
			<g:if test="${!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER")}">
				<li>
					<g:link controller="search" action="errorsSearchs"><i class="fa fa-times fa-fw"></i> <g:message code="pfc.main.left.error.search" locale="${languageDefault}" /></g:link>
				</li>
			</g:if>
			<li>
				<g:link controller="index" action="about"><i class="fa fa-info fa-fw"></i> About us</g:link>
			</li>
	    </ul>
    </g:if>
    <g:else>
    	<g:render template="menuLeftSearch" contextPath="/slr"/>
    </g:else>
	</div>
<!-- /.sidebar-collapse -->
</div>