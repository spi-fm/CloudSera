import es.uca.pfc.User
import es.uca.pfc.Slr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slrmyList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/myList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('render','g',9,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
invokeTag('render','g',15,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
expressionOut.print(null != error && error != "")
printHtmlPart(7)
expressionOut.print(null != errorCriterion && errorCriterion != "")
printHtmlPart(8)
expressionOut.print(null != errorAttribute && errorAttribute != "")
printHtmlPart(9)
expressionOut.print(tipoAttribute == 'list')
printHtmlPart(10)
expressionOut.print(null != errorQuestion && errorQuestion != "")
printHtmlPart(11)
expressionOut.print(success)
printHtmlPart(12)
expressionOut.print(successCriterion)
printHtmlPart(13)
expressionOut.print(successAttribute)
printHtmlPart(14)
expressionOut.print(successQuestion)
printHtmlPart(15)
expressionOut.print(null != errorSynchro && errorSynchro != "")
printHtmlPart(16)
})
invokeTag('captureHead','sitemesh',98,[:],1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
if(true && (null != error && !error.equals(""))) {
printHtmlPart(20)
expressionOut.print(error)
printHtmlPart(21)
}
printHtmlPart(22)
expressionOut.print(tituloSlr)
printHtmlPart(23)
expressionOut.print(justificacionSlr)
printHtmlPart(24)
invokeTag('submitButton','g',134,['name':("create"),'class':("btn btn-primary"),'value':("Crear Slr"),'onclick':("closeModalWithMessage('myModal','Creating SLR...');")],-1)
printHtmlPart(25)
})
invokeTag('form','g',134,['controller':("slr"),'action':("save"),'method':("POST"),'name':("myForm"),'id':("myForm")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('hiddenField','g',149,['name':("guidSlr"),'value':("0")],-1)
printHtmlPart(28)
invokeTag('submitButton','g',156,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Sí")],-1)
printHtmlPart(29)
invokeTag('submitButton','g',157,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes"),'onclick':("closeModalWithMessage('myModalDrop','Deleting SLR...');")],-1)
printHtmlPart(25)
})
invokeTag('form','g',158,['controller':("slr"),'action':("delete"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',179,['type':("button"),'class':("btn btn-primary"),'controller':("slr"),'action':("syncronizeListSlrMendeley"),'onclick':("closeModalWithMessage('myModalSynchro','Sinchronize with Mendeley...');")],2)
printHtmlPart(32)
invokeTag('render','g',180,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(33)
createClosureForHtmlPart(34, 2)
invokeTag('link','g',191,['controller':("index"),'action':("menu")],2)
printHtmlPart(35)
createClosureForHtmlPart(36, 2)
invokeTag('link','g',212,['type':("button"),'class':("btn btn-success"),'controller':("wizardSlr"),'action':("createSLR")],2)
printHtmlPart(37)
createClosureForHtmlPart(38, 2)
invokeTag('link','g',213,['type':("button"),'class':("btn btn-primary"),'controller':("slr"),'action':("syncronizeListSlrMendeley"),'onclick':("loading('Sincronizando con Mendeley...');")],2)
printHtmlPart(39)
for( slrInstance in (slrListInstance) ) {
printHtmlPart(40)
createTagBody(3, {->
expressionOut.print(slrInstance.title)
})
invokeTag('link','g',230,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],3)
printHtmlPart(41)
if(true && (slrInstance.state.equals("fase1"))) {
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (slrInstance.state.equals("fase2"))) {
printHtmlPart(44)
}
printHtmlPart(43)
if(true && (slrInstance.state.equals("fase3"))) {
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: slrInstance.submitDate))
printHtmlPart(41)
if(true && (slrInstance.searchs.size() > 0)) {
printHtmlPart(47)
createTagBody(4, {->
expressionOut.print(slrInstance.searchs.size())
printHtmlPart(48)
})
invokeTag('link','g',246,['controller':("slr"),'action':("searchs"),'params':([guid: "${slrInstance.guid}"])],4)
printHtmlPart(43)
}
else {
printHtmlPart(47)
expressionOut.print(slrInstance.searchs.size())
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (slrInstance.totalReferences > 0)) {
printHtmlPart(47)
createTagBody(4, {->
expressionOut.print(slrInstance.totalReferences)
printHtmlPart(51)
})
invokeTag('link','g',254,['controller':("slr"),'action':("references"),'params':([guid: "${slrInstance.guid}"])],4)
printHtmlPart(43)
}
else {
printHtmlPart(47)
expressionOut.print(slrInstance.totalReferences)
printHtmlPart(52)
}
printHtmlPart(53)
createClosureForHtmlPart(54, 3)
invokeTag('link','g',262,['title':("Research Questions"),'type':("button"),'class':("btn btn-outline btn-primary btn-circle"),'controller':("slr"),'action':("researchQuestions"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(55)
createClosureForHtmlPart(56, 3)
invokeTag('link','g',262,['title':("Criterions"),'class':("btn btn-outline btn-primary btn-circle"),'controller':("slr"),'action':("criterions"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(55)
createClosureForHtmlPart(57, 3)
invokeTag('link','g',263,['title':("Specific Attributes"),'class':("btn btn-outline btn-primary btn-circle"),'controller':("slr"),'action':("specAttributes"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(55)
createClosureForHtmlPart(58, 3)
invokeTag('link','g',264,['title':("Searchs"),'type':("button"),'class':("btn btn-outline btn-primary btn-circle"),'controller':("slr"),'action':("searchs"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(55)
if(true && (slrInstance.noDrop == false)) {
printHtmlPart(59)
expressionOut.print(slrInstance.guid)
printHtmlPart(60)
}
printHtmlPart(61)
createClosureForHtmlPart(62, 3)
invokeTag('link','g',269,['title':("Export Excel"),'type':("button"),'class':("btn btn-outline btn-success btn-circle"),'controller':("slr"),'action':("exportToExcel"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(63)
createClosureForHtmlPart(64, 3)
invokeTag('link','g',270,['title':("Exportar a PDF"),'type':("button"),'class':("btn btn-outline btn-success btn-circle"),'controller':("slr"),'action':("exportToPdf"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(65)
createClosureForHtmlPart(66, 3)
invokeTag('link','g',271,['title':("Export Word"),'type':("button"),'class':("btn btn-outline btn-success btn-circle"),'controller':("slr"),'action':("exportToWord"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(55)
createClosureForHtmlPart(67, 3)
invokeTag('link','g',272,['title':("Export Bibtex"),'type':("button"),'class':("btn btn-outline btn-success btn-circle"),'controller':("slr"),'action':("exportToBibTex"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(55)
createClosureForHtmlPart(68, 3)
invokeTag('link','g',273,['title':("Graphs"),'type':("button"),'class':("btn btn-outline btn-success btn-circle"),'controller':("slr"),'action':("graphs"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(69)
}
printHtmlPart(70)
invokeTag('render','g',278,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(71)
invokeTag('render','g',284,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(72)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(73)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(74)
invokeTag('render','g',300,['template':("slrInfo"),'contextPath':("/slr")],-1)
printHtmlPart(75)
})
invokeTag('captureBody','sitemesh',302,['onload':("loadModal();")],1)
printHtmlPart(76)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464422000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
