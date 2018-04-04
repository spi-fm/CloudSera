<div class="row" style="margin-bottom: 20px;">
	<div class="col-lg-12">
		<h1 class="page-header">Details of progress</h1>
		
		<ol class="breadcrumb">
		  <li><g:link controller="index" action="menu">Home</g:link></li>
		  <li><g:link controller="index" action="taskSearchs">Searchs in progress</g:link></li>
		  <li class="active">Details of progress</li>
		</ol>
		
	</div>
</div>

<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading">Info</div>
			<div class="panel-body">
				<label>SLR:</label> <g:link controller="slr" action="searchs" params="[guid: "${taskSearchInstance.guidSlr}"]">${taskSearchInstance.titleSlr}</g:link> <br/>
				<g:if test="${taskSearchInstance.hasErrors}">
					<label>Status search: </label> ERROR
				</g:if>
				<g:else>
					<label>Status search: </label> SUCCESS
				</g:else>
			</div>
		</div>
	</div>
	<div class="col-lg-6"></div>
</div>

<div class="row">
	<div class="col-lg-12">
<pre>
${taskSearchInstance.details}
</pre>
	</div>
</div>