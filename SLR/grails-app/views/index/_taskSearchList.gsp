<div class="row" style="margin-bottom: 20px;">
	<div class="col-lg-12">
		<h1 class="page-header">Searchs in progress</h1>
		
		<ol class="breadcrumb">
		  <li><g:link controller="index" action="menu">Home</g:link></li>
		  <li class="active">Task Searchs</li>
		</ol>
		
	</div>
</div>

<g:each var="taskSearch" in="${taskSearchList}">
	<div class="row">
		<div class="col-lg-4" align="right">
			<label><g:link controller="slr" action="searchs" params="[guid: "${taskSearch.guidSlr}"]">${taskSearch.titleSlr}</g:link></label>
			<p>Start: ${formatDate(format: 'dd/MMM/yyyy HH:mm', date: taskSearch.submitDate)}</p>
			<g:if test="${taskSearch.percentage == 100}">
			End: ${formatDate(format: 'dd/MMM/yyyy HH:mm', date: taskSearch.endDate)}
			</g:if>
			<g:elseif test="${taskSearch.hasErrors}">
				Code: ${'#'+ taskSearch.id}
			</g:elseif>
		</div>
		<div class="col-lg-6">
			State: ${taskSearch.state}
			<div class="progress">
				<g:set var="cssBar" value="progress-bar progress-bar-striped progress-bar-primary" />
				<g:if test="${taskSearch.percentage == 0 && taskSearch.hasErrors}">
					<g:set var="cssBar" value="progress-bar progress-bar-danger" />
				</g:if>
				<g:elseif test="${taskSearch.percentage != 100}">
					<g:set var="cssBar" value="progress-bar progress-bar-striped progress-bar-primary active" />
				</g:elseif>

			    <g:if test="${taskSearch.hasErrors}">
			    	<div class="${cssBar}" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
			    		<span class="sr-only">${taskSearch.percentage}% Complete</span>
			    		Cancelled
			    	</div>
			    </g:if>
			    <g:else>
   			    	<div class="${cssBar}" role="progressbar" aria-valuenow="${taskSearch.percentage}" aria-valuemin="0" aria-valuemax="100" style="width: ${taskSearch.percentage}%">
			    		<span class="sr-only">${taskSearch.percentage}% Complete</span>
				    	${taskSearch.percentage}%
				    </div>
			    </g:else>
			</div>
			
		</div>
		<div class="col-lg-2" style="padding-top: 15px;">
			<g:if test="${taskSearch.percentage == 100 || (taskSearch.percentage == 0 && taskSearch.hasErrors)}">
				<g:link class="btn btn-default" type="submit" controller="taskSearch" action="details" params="[guid: "${taskSearch.guid}"]">See details</g:link>
			</g:if>
		</div>
	</div>
</g:each>
