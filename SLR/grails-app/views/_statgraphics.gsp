<div class="panel panel-default">
	<div class="panel-heading">
		<i class="fa fa-bell fa-fw"></i> <g:message code="pfc.main.statistics.label" locale="${languageDefault}" />
	</div>
	
	<div class="panel-body">
		<div class="list-group">
			<p class="list-group-item">
				<i class="fa fa-book fa-fw"></i> ${totalSLR} <g:message code="pfc.main.statistics.slr" locale="${languageDefault}" />
			</p>
			<p class="list-group-item">
				<i class="fa fa-user fa-fw"></i> ${totalUsers} <g:message code="pfc.main.statistics.user" locale="${languageDefault}" />
			</p>
			<%--<a href="#" class="list-group-item">
				<i class="fa fa-user fa-fw" style="color: green;"></i> ${totalUsersOnline} Usuarios conectados.
			</a> --%>
		</div>
	</div>
	
</div>