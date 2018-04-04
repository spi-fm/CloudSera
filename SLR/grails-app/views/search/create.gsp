<%@ page import="es.uca.pfc.User" %>
<%@ page import="es.uca.pfc.Search" %>
<%@ page import="es.uca.pfc.Slr" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>SLR | Create Search</title>

	<%-- CSS --%>
    <g:render template="css" contextPath="/"/>
    
    <script type="text/javascript">
	    function loadError()
		{
			if(${null != error && error != ""})
			{
				document.getElementById('divError').style.display = "";
			}
		}
		function selectOrUnselectAll()
		{
			if(document.getElementById("engineAll").checked == true)
			{
				document.getElementById("engineAll").checked = true;
				document.getElementById("engineACM").checked = true;
				document.getElementById("engineIEEE").checked = true;
				document.getElementById("engineSCIENCE").checked = true;
				document.getElementById("engineSPRINGER").checked = true;
			}
			else
			{
				document.getElementById("engineAll").checked = false;
				document.getElementById("engineACM").checked = false;
				document.getElementById("engineIEEE").checked = false;
				document.getElementById("engineSCIENCE").checked = false;
				document.getElementById("engineSPRINGER").checked = false;
			}
		}
		function isAllSelected()
		{
			return document.getElementById("engineACM").checked && document.getElementById("engineIEEE").checked &&
			document.getElementById("engineSCIENCE").checked && document.getElementById("engineSPRINGER").checked;
		}
		function selectOrUnselectOptionAll()
		{
			if(isAllSelected() && !document.getElementById("engineAll").checked)
			{
				document.getElementById("engineAll").checked = true;
			}
			else if (!isAllSelected() && document.getElementById("engineAll").checked) 
			{
				document.getElementById("engineAll").checked = false;
			}
		}
	</script>

</head>

<body onload="loadError();">

    <div id="wrapper">

        <%-- Head --%>
        <g:render template="head" contextPath="/"/>
        
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create search <small>${slrInstance.title}</small></h1>
                    <ol class="breadcrumb">
					  <li><g:link controller="index" action="menu">Home</g:link></li>
					  <li><g:link controller="slr" action="myList">SLR List</g:link></li>
					  <li><g:link controller="slr" action="show" params="[guidSlr: "${slrInstance.guid}"]">${slrBreadCrumb}</g:link></li>
					  <li><g:link controller="slr" action="searchs" params="[guid: "${slrInstance.guid}"]">Searchs</g:link></li>
					  <li class="active">Create Search</li>
					</ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row">
				<div id="divError" class="alert alert-danger" role="alert" style="display: none;"><i class="fa fa-remove fa-fw"></i> ${error}</div>
			</div>
		
			<g:form class="form-horizontal" controller="search" action="save" method="POST" name="myForm" id="myForm">
			
				<g:hiddenField name="guidSlr" value="${slrInstance.guid}" />

				<%-- Engines --%>
				<div class="row">
					<div class="col-lg-12" style="margin-bottom: 20px;">
						<div class="form-group">
							<label class="col-sm-2 control-label" style="margin-right: 15px;">Engine:</label>
							<g:set var="listEngines" value="" />
							<label class="checkbox-inline">
								<input type="checkbox" id="engineAll" name="engineAll" value="engineALl" onclick="selectOrUnselectAll();"> <img src="${resource(dir:'images/logos_engines', file: 'all.png')}" width="40" height="40" />
							</label>
							<g:each in="${engineListInstance}" var="engineInstance">
								<label class="checkbox-inline">
									<g:if test="${engineInstance.name.toLowerCase().equals("acm") && opACMSearch.toString().equals('true')}">
										<input type="checkbox" id="engine${engineInstance.name}" name="engine${engineInstance.name}" value="${engineInstance.name}" onclick="selectOrUnselectOptionAll();"> <img src="${resource(dir:'images/logos_engines', file: engineInstance.image)}" width="40" height="40" />
									</g:if>
									<g:elseif test="${engineInstance.name.toLowerCase().equals("ieee") && opIEEESearch.toString().equals('true')}">
										<input type="checkbox" id="engine${engineInstance.name}" name="engine${engineInstance.name}" value="${engineInstance.name}" onclick="selectOrUnselectOptionAll();"> <img src="${resource(dir:'images/logos_engines', file: engineInstance.image)}" width="40" height="40" />
									</g:elseif>
									<g:elseif test="${engineInstance.name.toLowerCase().equals("science") && opSCIENCESearch.toString().equals('true')}">
										<input type="checkbox" id="engine${engineInstance.name}" name="engine${engineInstance.name}" value="${engineInstance.name}" onclick="selectOrUnselectOptionAll();"> <img src="${resource(dir:'images/logos_engines', file: engineInstance.image)}" width="40" height="40" />
									</g:elseif>
									<g:elseif test="${engineInstance.name.toLowerCase().equals("springer") && opSPRINGERSearch.toString().equals('true')}">
										<input type="checkbox" id="engine${engineInstance.name}" name="engine${engineInstance.name}" value="${engineInstance.name}" onclick="selectOrUnselectOptionAll();"> <img src="${resource(dir:'images/logos_engines', file: engineInstance.image)}" width="40" height="40" />
									</g:elseif>
									<g:else>
										<input type="checkbox" id="engine${engineInstance.name}" name="engine${engineInstance.name}" value="${engineInstance.name}" onclick="selectOrUnselectOptionAll();"> <img src="${resource(dir:'images/logos_engines', file: engineInstance.image)}" width="40" height="40" />
									</g:else>
									<% listEngines += 'engine' + engineInstance.name + ';' %>
								</label>
							</g:each>
						 </div>
					</div>
				</div>
				
				<%-- Total busquedas y Rango años --%>
				<div class="row">
					<div class="col-lg-12">
						<div class="form-group">
					    	<label for="inputTotalMax" class="col-sm-2 control-label">Total Máx: </label>
						    <div class="col-sm-2">
						    	<select class="form-control" id="inputTotalMax" name="inputTotalMax">
						    		<option value="5">5</option>
						    		<option value="10">10</option>
						    		<option value="25">25</option>
						    		<option value="50">50</option>
						    		<option value="75">75</option>
						    		<option value="100">100</option>
						    	</select>
							</div>
							<label for="inputTotalMax" class="col-sm-2 control-label">Years: </label>
						    <div class="col-sm-2" style="margin-top: 15px;">
						    	<input id="inputYears" name="inputYears" type="hidden" class="range-slider" value="${minYearSearch},${maxYearSearch}" />
							</div>
							
						  </div>
					</div>
					<div class="col-lg-6">
					</div>
				</div>
				
				<%-- Terminos --%>
				<div class="row input_fields_wrap">
					<button class="btn btn-primary add_field_button" style="margin-bottom: 20px; margin-left: 15px;">Insert more terms</button>	
					<div class="form-inline">
						<div class="col-lg-10">
							<label for="selectComponent" style="margin-right: 10px;">Find</label>
							<select class="form-control" id="selectComponent" name="selectComponent">
								<g:each in="${componentListInstance}" var="componentInstance">
									<option value="${componentInstance.value}">${componentInstance.name}</option>
								</g:each>
							</select>
							<select class="form-control" id="selectOperator" name="selectOperator">
								<g:each in="${operatorListInstance}" var="operatorInstance">
									<option value="${operatorInstance.value}">${operatorInstance.name}</option>
								</g:each>
							</select>
							these terms: 
							<input type="text" class="form-control" name="inputTerminos" value="" style="width: 250px;" />
						</div>
						<div class="col-lg-2">
						</div>
					</div>
				</div>
				
				<%-- Submit --%>
				<div class="row" style="margin-top: 50px;">
					<div class="col-lg-12">
						<g:submitButton id="boton" name="boton" class="btn btn-success" value="Create Search" />
					</div>
				</div>
				
			</g:form>

        </div>
        <!-- /#page-wrapper -->

		<%-- Foot --%>
        <g:render template="foot" contextPath="/"/>

    </div>
    <!-- /#wrapper -->

    <%-- JavaScript --%>
    <g:render template="javascript" contextPath="/"/>

	<script type="text/javascript">
		$(document).ready(function(){
	        $('.range-slider').jRange({
	            from: ${minYear},
	            to: ${maxYear},
	            step: 1,
	            scale: [${minYear},${maxYear}],
	            format: '%s',
	            width: 300,
	            showLabels: true,
	            isRange : true
	        });
	    });
	    $(document).ready(function() {
	        var max_fields      = 10; //maximum input boxes allowed
	        var wrapper         = $(".input_fields_wrap"); //Fields wrapper
	        var add_button      = $(".add_field_button"); //Add button ID
	        	        
	        var x = 1; //initlal text box count
	        $(add_button).click(function(e){ //on add input button click
	            e.preventDefault();
	            if(x < max_fields){ //max input box allowed
	                x++; //text box increment
	                //$(wrapper).append('<div><input type="text" name="mytext[]"/><a href="#" class="remove_field">Remove</a></div>'); //add input box
	                $(wrapper).append("<div class=\"form-inline\"><div class=\"col-lg-10\"><label for=\"exampleInputName2\">Find</label><select class=\"form-control\" style=\"margin-left: 15px;\" id=\"selectComponent\" name=\"selectComponent\">${strOptionsComponents.encodeAsJavaScript()}</select><select class=\"form-control\" style=\"margin-left: 5px; margin-right: 5px;\" id=\"selectOperator\" name=\"selectOperator\">${strOptionsOperators.encodeAsJavaScript()}</select>these terms:<input type=\"text\" class=\"form-control\" style=\"margin-left: 4px; width: 250px;\" id=\"inputTerminos\" name=\"inputTerminos\" value=\"\" style=\"width: 250px;\" /><a href=\"#\" class=\"remove_field btn btn-default btn-circle\" style=\"margin-left: 15px;\"><i class=\"fa fa-times\"></i></a></div><div class=\"col-lg-2\"></div></div>");
	            }
	        });
	        
	        $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
	            e.preventDefault(); $(this).parent('div').remove(); x--;
	        })
	    });
	</script>

</body>

</html>
