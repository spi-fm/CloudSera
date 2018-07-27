import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.Criterion
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_wizardSlrcreateSpecAttributes_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/wizardSlr/createSpecAttributes.gsp" }
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
invokeTag('captureHead','sitemesh',100,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('hiddenField','g',121,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(15)
if(true && (null != errorAttribute && !errorAttribute.equals(""))) {
printHtmlPart(16)
expressionOut.print(errorAttribute)
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(nombreAttribute)
printHtmlPart(19)
if(true && (tipoAttribute == 'string')) {
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (tipoAttribute == 'number')) {
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(22)
if(true && (tipoAttribute == 'list')) {
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (opcionesAttribute == null || opcionesAttribute == 'null')) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(opcionesAttribute)
printHtmlPart(30)
}
printHtmlPart(31)
invokeTag('submitButton','g',177,['name':("create"),'class':("btn btn-primary"),'value':("Create attribute")],-1)
printHtmlPart(32)
})
invokeTag('form','g',177,['controller':("wizardSlr"),'action':("saveSpecAttributes"),'method':("POST"),'name':("myFormAttribute"),'id':("myFormAttribute")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('hiddenField','g',199,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',200,['name':("idEditAttribute"),'value':(idEditAttribute)],-1)
printHtmlPart(15)
if(true && (null != errorEditAttribute && !errorEditAttribute.equals(""))) {
printHtmlPart(34)
expressionOut.print(errorEditAttribute)
printHtmlPart(17)
}
printHtmlPart(35)
expressionOut.print(nombreEditAttribute)
printHtmlPart(36)
if(true && (tipoEditAttribute == 'string')) {
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (tipoEditAttribute == 'number')) {
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(22)
if(true && (tipoEditAttribute == 'list')) {
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(37)
if(true && (opcionesEditAttribute == null || opcionesEditAttribute == 'null')) {
printHtmlPart(38)
}
else {
printHtmlPart(39)
expressionOut.print(opcionesEditAttribute)
printHtmlPart(40)
}
printHtmlPart(31)
invokeTag('submitButton','g',264,['name':("create"),'class':("btn btn-primary"),'value':("Edit attribute")],-1)
printHtmlPart(32)
})
invokeTag('form','g',265,['controller':("wizardSlr"),'action':("editSpecAttributes"),'method':("POST"),'name':("myFormEditAttribute"),'id':("myFormEditAttribute")],2)
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('hiddenField','g',285,['name':("idAttribute"),'value':("0")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',286,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(42)
invokeTag('submitButton','g',296,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(32)
})
invokeTag('form','g',296,['controller':("wizardSlr"),'action':("deleteSpecAttributes"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(43)
invokeTag('render','g',298,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(44)
expressionOut.print(slrInstance.title)
printHtmlPart(45)
createClosureForHtmlPart(46, 2)
invokeTag('link','g',313,['controller':("index"),'action':("menu")],2)
printHtmlPart(47)
createClosureForHtmlPart(48, 2)
invokeTag('link','g',313,['controller':("slr"),'action':("myList")],2)
printHtmlPart(49)
createClosureForHtmlPart(50, 2)
invokeTag('link','g',345,['class':("btn btn-primary"),'controller':("wizardSlr"),'action':("createSearch"),'onclick':("closeModalWithMessage('myModal','Creating Specific Attributes...');"),'params':([guidSlr: "${slrInstance.guid}"])],2)
printHtmlPart(51)
if(true && (null != error && !error.equals(""))) {
printHtmlPart(52)
expressionOut.print(error)
printHtmlPart(32)
}
printHtmlPart(53)
for( attributeInstance in (specAttributesListInstance) ) {
printHtmlPart(54)
invokeTag('set','g',368,['var':("strOptions"),'value':("")],-1)
printHtmlPart(55)
expressionOut.print(attributeInstance.name)
printHtmlPart(56)
expressionOut.print(attributeInstance.tipo)
printHtmlPart(56)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: attributeInstance.submitDate))
printHtmlPart(56)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: attributeInstance.modifyDate))
printHtmlPart(57)
if(true && (attributeInstance.tipo != "list")) {
printHtmlPart(58)
}
else {
printHtmlPart(22)
for( optionInstance in (attributeInstance.options) ) {
printHtmlPart(59)
if(true && (optionInstance != '--')) {
printHtmlPart(60)
expressionOut.print(optionInstance)
printHtmlPart(61)

strOptions += optionInstance + ";"

printHtmlPart(59)
}
printHtmlPart(22)
}
printHtmlPart(62)
}
printHtmlPart(63)
expressionOut.print(attributeInstance.id.toString())
printHtmlPart(64)
expressionOut.print(attributeInstance.name.toString())
printHtmlPart(64)
expressionOut.print(attributeInstance.tipo.toString())
printHtmlPart(64)
expressionOut.print(strOptions)
printHtmlPart(65)
if(true && (slrInstance.noDrop == false)) {
printHtmlPart(66)
expressionOut.print(attributeInstance.id.toString())
printHtmlPart(67)
}
else {
printHtmlPart(68)
}
printHtmlPart(69)
}
printHtmlPart(70)
invokeTag('render','g',421,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(71)
invokeTag('render','g',430,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(72)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(73)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(74)
})
invokeTag('captureBody','sitemesh',446,['onload':("loadModal();")],1)
printHtmlPart(75)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464496000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
