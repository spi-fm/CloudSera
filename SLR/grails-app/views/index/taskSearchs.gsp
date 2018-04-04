<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
    <g:render template="headMeta" contextPath="/"/>

    <title>SLR | Searchs in progress</title>
    
    <%-- CSS --%>
    <g:render template="css" contextPath="/"/>

</head>

<body>

	<div id="wrapper">
	
		<%-- Head --%>
        <g:render template="head" contextPath="/"/>
        	
		<div id="page-wrapper">
		
			<g:include controller='index' action='loadTaskSearchs' />
		
        </div>
        
        <%-- Foot --%>
        <g:render template="foot" contextPath="/"/>
        
	</div>

<%-- JavaScript --%>
<g:render template="javascript" contextPath="/"/>

<script type="text/javascript">
	$(document).ready(
	           function() {
	               setInterval(function() { 
	               $('#page-wrapper').load("${createLink(controller: 'index', action: 'loadTaskSearchs')}"); //'/SLR/index/loadTaskSearchs'
	               }, 10000);
	           });
</script>

</body>

</html>