import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.Criterion
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_wizardSlrcreateCriterions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/wizardSlr/createCriterions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('render','g',10,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
invokeTag('render','g',16,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
expressionOut.print(null != errorCriterion && errorCriterion != "")
printHtmlPart(7)
expressionOut.print(successCriterion)
printHtmlPart(8)
expressionOut.print(null != errorEditCriterion && errorEditCriterion != "")
printHtmlPart(9)
expressionOut.print(successEditCriterion)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',61,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',76,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(14)
if(true && (null != errorCriterion && !errorCriterion.equals(""))) {
printHtmlPart(15)
expressionOut.print(errorCriterion)
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(nombreCriterion)
printHtmlPart(18)
expressionOut.print(descripcionCriterion)
printHtmlPart(19)
invokeTag('submitButton','g',97,['name':("create"),'class':("btn btn-primary"),'value':("Create Criterion")],-1)
printHtmlPart(20)
})
invokeTag('form','g',97,['controller':("wizardSlr"),'action':("saveCriterions"),'method':("POST"),'name':("myFormCriterion"),'id':("myFormCriterion")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',112,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',113,['name':("idEditCriterion"),'value':(idEditCriterion)],-1)
printHtmlPart(14)
if(true && (null != errorEditCriterion && !errorEditCriterion.equals(""))) {
printHtmlPart(22)
expressionOut.print(errorEditCriterion)
printHtmlPart(16)
}
printHtmlPart(23)
expressionOut.print(nombreEditCriterion)
printHtmlPart(24)
expressionOut.print(descripcionEditCriterion)
printHtmlPart(19)
invokeTag('submitButton','g',133,['name':("create"),'class':("btn btn-primary"),'value':("Edit Criterion")],-1)
printHtmlPart(20)
})
invokeTag('form','g',134,['controller':("wizardSlr"),'action':("editCriterions"),'method':("POST"),'name':("myFormEditCriterion"),'id':("myFormEditCriterion")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('hiddenField','g',149,['name':("idCriterion"),'value':("0")],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',150,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(27)
invokeTag('submitButton','g',157,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(20)
})
invokeTag('form','g',158,['controller':("wizardSlr"),'action':("deleteCriterions"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(28)
invokeTag('render','g',160,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(29)
expressionOut.print(slrInstance.title)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',174,['controller':("index"),'action':("menu")],2)
printHtmlPart(32)
createClosureForHtmlPart(33, 2)
invokeTag('link','g',175,['controller':("slr"),'action':("myList")],2)
printHtmlPart(34)
createClosureForHtmlPart(35, 2)
invokeTag('link','g',205,['class':("btn btn-primary"),'controller':("wizardSlr"),'action':("createSpecAttributes"),'onclick':("closeModalWithMessage('myModal','Creating Criterions...');"),'params':([guid: "${slrInstance.guid}"])],2)
printHtmlPart(36)
if(true && (null != error && !error.equals(""))) {
printHtmlPart(37)
expressionOut.print(error)
printHtmlPart(38)
}
printHtmlPart(39)
for( criterionInstance in (criterionListInstance) ) {
printHtmlPart(40)
invokeTag('set','g',222,['var':("contReference"),'value':("0")],-1)
printHtmlPart(41)
expressionOut.print(criterionInstance.name)
printHtmlPart(42)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: criterionInstance.submitDate))
printHtmlPart(42)
expressionOut.print(criterionInstance.description)
printHtmlPart(43)
if(true && (null == totalReferences.get(criterionInstance.name))) {
printHtmlPart(44)
}
else {
printHtmlPart(45)
expressionOut.print(totalReferences.get(criterionInstance.name).value)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (slrInstance.noDrop == false && criterionInstance.nomenclatura != "cr_included")) {
printHtmlPart(48)
expressionOut.print(criterionInstance.id.toString())
printHtmlPart(49)
expressionOut.print(criterionInstance.name.toString())
printHtmlPart(49)
expressionOut.print(criterionInstance.description.toString())
printHtmlPart(50)
expressionOut.print(criterionInstance.id.toString())
printHtmlPart(51)
}
else {
printHtmlPart(52)
}
printHtmlPart(53)
}
printHtmlPart(54)
invokeTag('render','g',249,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(55)
invokeTag('render','g',255,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(56)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(57)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',269,['onload':("loadModal();")],1)
printHtmlPart(59)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464476000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
