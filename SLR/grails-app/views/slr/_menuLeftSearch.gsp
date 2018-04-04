<script type="text/javascript">
	function changeTextLinkCollapseMenuSearch(name, text)
	{
		var icon = "<i class='fa fa-angle-double-up'></i> ";
		if(document.getElementById(name).innerHTML.includes('fa-angle-double-up'))
		{
			icon = "<i class='fa fa-angle-double-down'></i> ";
		}
		document.getElementById(name).innerHTML= icon.concat(text);
	}
	function goToUp()
	{
		$(window).scrollTop(0);
	}
</script>
<g:set var="guidSlr" value="${guidSlr}" />
<ul class="nav" id="side-menu">
	
	<li style="padding: 20px;">
		<b>Refine results by</b>
	</li>
	
	<%-- CRITERIOS --%>
	<g:if test="${criterionsListInstance.size() > 0}">
		<li>
			<a id="rowCriterion" data-toggle="collapse" href="#rowCriterionCollapse" aria-expanded="false" aria-controls="rowCriterionCollapse"  onclick="changeTextLinkCollapseMenuSearch('rowCriterion','Criterions');" style="font-weight: bold;"><i class="fa fa-angle-double-down"></i> Criterions</a>
			<div class="collapse" id="rowCriterionCollapse">
				<g:each in="${criterionsListInstance}" var="criterion">
					<div class="checkbox" style="margin-left: 20px;">
					  <label>
					    <input type="checkbox" value="${criterion}" onclick="goToUp();"
					    	onchange="${remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "criterion="+criterion])}"
					    />
				    	${criterion}
					  </label>
					</div>
				</g:each>
			</div>
		</li>
	</g:if>
	
	<%-- ATRIBUTOS ESPECIFICOS --%>
	<g:if test="${specificAttributesMapInstance.size() > 0}">
		<g:each in="${specificAttributesMapInstance}" var="specificAttribute">
			<li>
				<a id="rowAttribute${specificAttribute.key.replaceAll(" ","")}" data-toggle="collapse" href="#rowAttribute${specificAttribute.key.replaceAll(" ","")}Collapse" aria-expanded="false" aria-controls="rowAttribute${specificAttribute.key.replaceAll(" ","")}Collapse"  onclick="changeTextLinkCollapseMenuSearch('rowAttribute${specificAttribute.key.replaceAll(" ","")}','${specificAttribute.key}');" style="font-weight: bold;"><i class="fa fa-angle-double-down"></i> ${specificAttribute.key}</a>
				<div class="collapse" id="rowAttribute${specificAttribute.key.replaceAll(" ","")}Collapse">
					<g:each in="${specificAttribute.value}" var="valueAttribute">
						<div class="checkbox" style="margin-left: 20px;">
						  <label>
							<input type="checkbox" value="${valueAttribute}" onclick="goToUp();"
						    	onchange="${remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "@as@" + specificAttribute.key + "="+valueAttribute])}"
						    />
					    	${valueAttribute}
						</label>
						</div>
					</g:each>
				</div>
			</li>
		</g:each>
	</g:if>
	
	<%-- ENGINES --%>
	<g:if test="${enginesListInstance.size() > 0}">
		<li>
			<a id="rowEngine" data-toggle="collapse" href="#rowEngineCollapse" aria-expanded="false" aria-controls="rowEngineCollapse"  onclick="changeTextLinkCollapseMenuSearch('rowEngine','Engines');" style="font-weight: bold;"><i class="fa fa-angle-double-down"></i> Engines</a>
			<div class="collapse" id="rowEngineCollapse">
				<g:each in="${enginesListInstance}" var="engine">
					<div class="checkbox" style="margin-left: 20px;">
					  <label>
					    <input name="check${engine}" type="checkbox" value="${engine}" onclick="goToUp();"
				    		onchange="${remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "engine="+engine])}"
			    		/>
					    ${engine}
					  </label>
					</div>
				</g:each>
			</div>
		</li>
	</g:if>
	
	<%-- LANGUAGE --%>
	<g:if test="${languagesListInstance.size() > 0}">
		<li>
			<a id="rowLanguage" data-toggle="collapse" href="#rowLanguageCollapse" aria-expanded="false" aria-controls="rowLanguageCollapse"  onclick="changeTextLinkCollapseMenuSearch('rowLanguage','Languages');" style="font-weight: bold;"><i class="fa fa-angle-double-down"></i> Languages</a>
			<div class="collapse" id="rowLanguageCollapse">
				<g:each in="${languagesListInstance}" var="language">
					<div class="checkbox" style="margin-left: 20px;">
					  <label>
					    <input type="checkbox" value="${language}" onclick="goToUp();"
					    	onchange="${remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "language="+language])}"
					    />
					    ${language}
					  </label>
					</div>
				</g:each>
			</div>
		</li>
	</g:if>
	
	<%-- DEPARTMENTS --%>
	<g:if test="${departmentsListInstance.size() > 0}">
		<li>
			<a id="rowDepartment" data-toggle="collapse" href="#rowDepartmentCollapse" aria-expanded="false" aria-controls="rowDepartmentCollapse"  onclick="changeTextLinkCollapseMenuSearch('rowDepartment','Departments');" style="font-weight: bold;"><i class="fa fa-angle-double-down"></i> Departments</a>
			<div class="collapse" id="rowDepartmentCollapse">
				<g:each in="${departmentsListInstance}" var="department">
					<div class="checkbox" style="margin-left: 20px;">
					  <label>
					    <input type="checkbox" value="${department}" onclick="goToUp();"
					       	onchange="${remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "department="+department])}" 
					    />
					    ${department}
					  </label>
					</div>
				</g:each>
			</div>
		</li>
	</g:if>
	
	<%-- TYPE --%>
	<g:if test="${typesListInstance.size() > 0}">
		<li>
			<a id="rowType" data-toggle="collapse" href="#rowTypeCollapse" aria-expanded="false" aria-controls="rowTypeCollapse"  onclick="changeTextLinkCollapseMenuSearch('rowType','Types');" style="font-weight: bold;"><i class="fa fa-angle-double-down"></i> Types Documents</a>
			<div class="collapse" id="rowTypeCollapse">
				<g:each in="${typesListInstance}" var="type">
					<div class="checkbox" style="margin-left: 20px;">
					  <label>
					    <input type="checkbox" value="${type}" onclick="goToUp();"
					    	onchange="${remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "type="+type])}" 
					    />
					    ${type}
					  </label>
					</div>
				</g:each>
			</div>
		</li>
	</g:if>
	
	<%-- AUTHORS --%>
	<g:if test="${authorsListInstance.size() > 0}">
		<li>
			<a id="rowAuthor" data-toggle="collapse" href="#rowAuthorCollapse" aria-expanded="false" aria-controls="rowAuthorCollapse"  onclick="changeTextLinkCollapseMenuSearch('rowAuthor','Authors');" style="font-weight: bold;"><i class="fa fa-angle-double-down"></i> Authors</a>
			<div class="collapse" id="rowAuthorCollapse">
				<g:each in="${authorsListInstance}" var="author">
					<div class="checkbox" style="margin-left: 20px;">
					  <label>
					    <input type="checkbox" value="${author}" onclick="goToUp();"
					    	onchange="${remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "author="+author])}" 
					    />
					    ${author}
					  </label>
					</div>
				</g:each>
			</div>
		</li>
	</g:if>
	
</ul>