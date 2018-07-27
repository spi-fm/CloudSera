import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.Criterion
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slrcriterions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/criterions.gsp" }
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
invokeTag('captureHead','sitemesh',62,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',77,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
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
invokeTag('submitButton','g',98,['name':("create"),'class':("btn btn-primary"),'value':("Create Criterion")],-1)
printHtmlPart(20)
})
invokeTag('form','g',98,['controller':("criterion"),'action':("save"),'method':("POST"),'name':("myFormCriterion"),'id':("myFormCriterion")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',113,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',114,['name':("idEditCriterion"),'value':(idEditCriterion)],-1)
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
invokeTag('submitButton','g',134,['name':("create"),'class':("btn btn-primary"),'value':("Edit Criterion")],-1)
printHtmlPart(20)
})
invokeTag('form','g',135,['controller':("criterion"),'action':("edit"),'method':("POST"),'name':("myFormEditCriterion"),'id':("myFormEditCriterion")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('hiddenField','g',150,['name':("idCriterion"),'value':("0")],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',151,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(27)
invokeTag('submitButton','g',158,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(20)
})
invokeTag('form','g',159,['controller':("criterion"),'action':("delete"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(28)
invokeTag('render','g',161,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(29)
expressionOut.print(slrInstance.title)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',175,['controller':("index"),'action':("menu")],2)
printHtmlPart(32)
createClosureForHtmlPart(33, 2)
invokeTag('link','g',176,['controller':("slr"),'action':("myList")],2)
printHtmlPart(32)
createTagBody(2, {->
expressionOut.print(slrBreadCrumb)
})
invokeTag('link','g',179,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],2)
printHtmlPart(34)
for( criterionInstance in (criterionListInstance) ) {
printHtmlPart(35)
invokeTag('set','g',204,['var':("contReference"),'value':("0")],-1)
printHtmlPart(36)
expressionOut.print(criterionInstance.name)
printHtmlPart(37)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: criterionInstance.submitDate))
printHtmlPart(37)
expressionOut.print(criterionInstance.description)
printHtmlPart(38)
if(true && (null == totalReferences.get(criterionInstance.name))) {
printHtmlPart(39)
}
else {
printHtmlPart(40)
expressionOut.print(totalReferences.get(criterionInstance.name).value)
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (slrInstance.noDrop == false && criterionInstance.nomenclatura != "cr_included")) {
printHtmlPart(43)
expressionOut.print(criterionInstance.id.toString())
printHtmlPart(44)
expressionOut.print(criterionInstance.name.toString())
printHtmlPart(44)
expressionOut.print(criterionInstance.description.toString())
printHtmlPart(45)
expressionOut.print(criterionInstance.id.toString())
printHtmlPart(46)
}
else {
printHtmlPart(47)
}
printHtmlPart(48)
}
printHtmlPart(49)
invokeTag('render','g',233,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(50)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(51)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(52)
})
invokeTag('captureBody','sitemesh',249,['onload':("loadModal();")],1)
printHtmlPart(53)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464413000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
