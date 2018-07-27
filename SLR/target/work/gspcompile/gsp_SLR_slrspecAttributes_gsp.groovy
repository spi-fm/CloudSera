import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.SpecificAttribute
import es.uca.pfc.SpecificAttributeMultipleValue
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slrspecAttributes_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/specAttributes.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('render','g',11,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(5)
invokeTag('render','g',17,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
expressionOut.print(null != errorAttribute && errorAttribute != "")
printHtmlPart(7)
expressionOut.print(tipoAttribute == "list")
printHtmlPart(8)
expressionOut.print(successAttribute)
printHtmlPart(9)
expressionOut.print(null != errorEditAttribute && errorEditAttribute != "")
printHtmlPart(10)
expressionOut.print(tipoEditAttribute == "list")
printHtmlPart(11)
expressionOut.print(successEditAttribute)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',102,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('hiddenField','g',117,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(16)
if(true && (null != errorAttribute && !errorAttribute.equals(""))) {
printHtmlPart(17)
expressionOut.print(errorAttribute)
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(nombreAttribute)
printHtmlPart(20)
if(true && (tipoAttribute == 'string')) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (tipoAttribute == 'number')) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(23)
if(true && (tipoAttribute == 'list')) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (opcionesAttribute == null || opcionesAttribute == 'null')) {
printHtmlPart(29)
}
else {
printHtmlPart(30)
expressionOut.print(opcionesAttribute)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('submitButton','g',170,['name':("create"),'class':("btn btn-primary"),'value':("Create attribute")],-1)
printHtmlPart(33)
})
invokeTag('form','g',170,['controller':("specificAttribute"),'action':("save"),'method':("POST"),'name':("myFormAttribute"),'id':("myFormAttribute")],2)
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('hiddenField','g',185,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',186,['name':("idEditAttribute"),'value':(idEditAttribute)],-1)
printHtmlPart(16)
if(true && (null != errorEditAttribute && !errorEditAttribute.equals(""))) {
printHtmlPart(35)
expressionOut.print(errorEditAttribute)
printHtmlPart(18)
}
printHtmlPart(36)
expressionOut.print(nombreEditAttribute)
printHtmlPart(37)
if(true && (tipoEditAttribute == 'string')) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (tipoEditAttribute == 'number')) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(23)
if(true && (tipoEditAttribute == 'list')) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(38)
if(true && (opcionesEditAttribute == null || opcionesEditAttribute == 'null')) {
printHtmlPart(39)
}
else {
printHtmlPart(40)
expressionOut.print(opcionesEditAttribute)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('submitButton','g',238,['name':("create"),'class':("btn btn-primary"),'value':("Edit attribute")],-1)
printHtmlPart(33)
})
invokeTag('form','g',239,['controller':("specificAttribute"),'action':("edit"),'method':("POST"),'name':("myFormEditAttribute"),'id':("myFormEditAttribute")],2)
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
invokeTag('hiddenField','g',254,['name':("idAttribute"),'value':("0")],-1)
printHtmlPart(42)
invokeTag('hiddenField','g',255,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(43)
invokeTag('submitButton','g',262,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(33)
})
invokeTag('form','g',263,['controller':("specificAttribute"),'action':("delete"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(44)
invokeTag('render','g',265,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(45)
expressionOut.print(slrInstance.title)
printHtmlPart(46)
createClosureForHtmlPart(47, 2)
invokeTag('link','g',280,['controller':("index"),'action':("menu")],2)
printHtmlPart(48)
createClosureForHtmlPart(49, 2)
invokeTag('link','g',281,['controller':("slr"),'action':("myList")],2)
printHtmlPart(48)
createTagBody(2, {->
expressionOut.print(slrBreadCrumb)
})
invokeTag('link','g',284,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],2)
printHtmlPart(50)
for( attributeInstance in (specAttributesListInstance) ) {
printHtmlPart(51)
invokeTag('set','g',310,['var':("strOptions"),'value':("")],-1)
printHtmlPart(52)
expressionOut.print(attributeInstance.name)
printHtmlPart(53)
expressionOut.print(attributeInstance.tipo)
printHtmlPart(53)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: attributeInstance.submitDate))
printHtmlPart(53)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: attributeInstance.modifyDate))
printHtmlPart(54)
if(true && (attributeInstance.tipo != "list")) {
printHtmlPart(55)
}
else {
printHtmlPart(56)
for( optionInstance in (attributeInstance.options) ) {
printHtmlPart(57)
if(true && (optionInstance != '--')) {
printHtmlPart(58)
expressionOut.print(optionInstance)
printHtmlPart(59)

strOptions += optionInstance + ";"

printHtmlPart(57)
}
printHtmlPart(56)
}
printHtmlPart(60)
}
printHtmlPart(61)
expressionOut.print(attributeInstance.id.toString())
printHtmlPart(62)
expressionOut.print(attributeInstance.name.toString())
printHtmlPart(62)
expressionOut.print(attributeInstance.tipo.toString())
printHtmlPart(62)
expressionOut.print(strOptions)
printHtmlPart(63)
if(true && (slrInstance.noDrop == false)) {
printHtmlPart(64)
expressionOut.print(attributeInstance.id.toString())
printHtmlPart(65)
}
else {
printHtmlPart(66)
}
printHtmlPart(67)
}
printHtmlPart(68)
invokeTag('render','g',343,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(69)
invokeTag('render','g',349,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(70)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(71)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(72)
})
invokeTag('captureBody','sitemesh',363,['onload':("loadModal();")],1)
printHtmlPart(73)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464442000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
