<div id="searchloggers" class="chat-panel panel panel-default">
	<div class="panel-heading">
		<i class="fa fa-comments fa-fw"></i>
		<g:message code="pfc.logger.title" locale="${languageDefault}" />
		<div class="btn-group pull-right">
			<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
				<i class="fa fa-chevron-down"></i>
			</button>
			<!-- <ul class="dropdown-menu slidedown">
				<li>
					<a href="#">
						<i class="fa fa-refresh fa-fw"></i> Refresh
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-users fa-fw"></i> Todos
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-user fa-fw"></i> Mis Loggers
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-users fa-fw"></i> Loggers de amigos
					</a>
				</li>
			</ul> -->
		</div>
	</div>
	<!-- /.panel-heading -->
	<div class="panel-body" style="min-height: 500px;">
		<ul class="chat">
			<g:each in="${loggerListInstance}" var="loggerInstance">
				<li class="left clearfix">
					<span class="chat-img pull-left">
						<g:if test="${loggerInstance.tipo.contains('fr-')}">
							<g:if test="${loggerInstance.friendProfile.url_foto.toString().contains('unknown_user.png')}">
								<img src="${resource(dir:'images/user', file: 'unknown_user.png')}" alt="User Avatar" class="img-circle" style="width: 50px; height: 50px;" />
		                	</g:if>
		                	<g:else>
		                		<img src="${loggerInstance.friendProfile.url_foto}" alt="User Avatar" class="img-circle" style="width: 50px; height: 50px;" />
		                	</g:else>
						</g:if>
						<g:else>
							<g:if test="${loggerInstance.profile.url_foto.toString().contains('unknown_user.png')}">
								<img src="${resource(dir:'images/user', file: 'unknown_user.png')}" alt="User Avatar" class="img-circle" style="width: 50px; height: 50px;" />
		                	</g:if>
		                	<g:else>
		                		<img src="${loggerInstance.profile.url_foto}" alt="User Avatar" class="img-circle" style="width: 50px; height: 50px;" />
		                	</g:else>
						</g:else>
					</span>
					<div class="chat-body clearfix">
						<div class="header">
							<%--<g:if test="${userProfileInstance.id != loggerInstance.profile.id}"> --%>
							<g:if test="${loggerInstance.tipo.contains('fr-')}">
								<strong class="primary-font">${loggerInstance.friendProfile.display_name}</strong>
							</g:if>
							<g:else>
								<strong class="primary-font"><g:message code="pfc.logger.user.me" locale="${languageDefault}" /></strong>
							</g:else>
							<small class="pull-right text-muted">
								<i class="fa fa-clock-o fa-fw"></i> ${loggerInstance.timeString}
							</small>
						</div>
						<p>
							<g:if test="${loggerInstance.tipo == 'bienvenida'}">
								<img src="${resource(dir:'images/logger',file:'start.png')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.welcome" locale="${languageDefault}" />
							</g:if>
							<g:elseif test="${loggerInstance.tipo == 'fr-bienvenida'}">
								<img src="${resource(dir:'images/logger',file:'start.png')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.registered" locale="${languageDefault}" />
							</g:elseif>
							<g:elseif test="${loggerInstance.tipo == 'crear'}">
								<img src="${resource(dir:'images/logger',file:'libro.jpg')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.me.slr.created" locale="${languageDefault}" /> <g:link controller="slr" action="myList">${loggerInstance.slr.title}</g:link>
							</g:elseif>
							<g:elseif test="${loggerInstance.tipo == 'fr-crear'}">
								<img src="${resource(dir:'images/logger',file:'libro.jpg')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.me.slr.created" locale="${languageDefault}" /> ${loggerInstance.slr.title}
							</g:elseif>
							<g:elseif test="${loggerInstance.tipo == 'buscar'}">
								<img src="${resource(dir:'images/logger',file:'lupa.jpg')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.me.search.created" locale="${languageDefault}" /> <g:link controller="slr" action="searchs" params="[guid: "${loggerInstance.slr.guid}"]">${loggerInstance.slr.title}</g:link>
							</g:elseif>
							<g:elseif test="${loggerInstance.tipo == 'fr-buscar'}">
								<img src="${resource(dir:'images/logger',file:'lupa.jpg')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.friend.search.created" locale="${languageDefault}" /> ${loggerInstance.slr.title}
							</g:elseif>
							<g:elseif test="${loggerInstance.tipo == 'seguir'}">
								<img src="${resource(dir:'images/logger',file:'friend.png')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.me.friend" locale="${languageDefault}" /> <g:link controller="user" action="show" params="[guid: "${loggerInstance.friendProfile.guid}"]">${loggerInstance.friendProfile.display_name}</g:link>
							</g:elseif>
							<g:elseif test="${loggerInstance.tipo == 'fr-seguir'}">
								<img src="${resource(dir:'images/logger',file:'friend.png')}" alt="" width="20" height="20" /> <g:message code="pfc.logger.friend.friend" locale="${languageDefault}" /> ${loggerInstance.friendFriendProfile.display_name}
							</g:elseif>
							<g:else>
								No definido
							</g:else>
						</p>
					</div>
				</li>
			</g:each>
		</ul>
	</div>
</div>