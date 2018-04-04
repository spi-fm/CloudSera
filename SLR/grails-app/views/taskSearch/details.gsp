<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
    <g:render template="headMeta" contextPath="/"/>

    <title>SLR | Details of progress</title>
    
    <%-- CSS --%>
    <g:render template="css" contextPath="/"/>

</head>

<body>

	<div id="wrapper">
		<%-- Head --%>
        <g:render template="head" contextPath="/"/>
        	
		<div id="page-wrapper">
		
			<g:include controller='taskSearch' action='loadDetailsTaskSearch' params="[guid: "${taskSearchInstance.guid}"]" />
		
        </div>
        
        <%-- Foot --%>
        <g:render template="foot" contextPath="/"/>
        
	</div>

<%-- JavaScript --%>
<g:render template="javascript" contextPath="/"/>

<script type="text/javascript">
//	$(document).ready(
//	           function() {
//	               setInterval(function() { 

//	               }, 5000);
//	           });
</script>

</body>

</html>