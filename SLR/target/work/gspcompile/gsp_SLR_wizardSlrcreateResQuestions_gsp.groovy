import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.Criterion
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_wizardSlrcreateResQuestions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/wizardSlr/createResQuestions.gsp" }
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
expressionOut.print(null != errorQuestion && errorQuestion != "")
printHtmlPart(7)
expressionOut.print(successQuestion)
printHtmlPart(8)
expressionOut.print(null != errorEditQuestion && errorEditQuestion != "")
printHtmlPart(9)
expressionOut.print(successEditQuestion)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',60,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',75,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(14)
if(true && (null != errorQuestion && !errorQuestion.equals(""))) {
printHtmlPart(15)
expressionOut.print(errorQuestion)
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(enunciadoQuestion)
printHtmlPart(18)
invokeTag('submitButton','g',92,['name':("create"),'class':("btn btn-primary"),'value':("Create Research Question")],-1)
printHtmlPart(19)
})
invokeTag('form','g',92,['controller':("wizardSlr"),'action':("saveResQuestions"),'method':("POST"),'name':("myFormQuestion"),'id':("myFormQuestion")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',107,['name':("idEditQuestion"),'value':(idEditQuestion)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',108,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(14)
if(true && (null != errorEditQuestion && !errorEditQuestion.equals(""))) {
printHtmlPart(21)
expressionOut.print(errorEditQuestion)
printHtmlPart(16)
}
printHtmlPart(22)
expressionOut.print(enunciadoEditQuestion)
printHtmlPart(18)
invokeTag('submitButton','g',124,['name':("create"),'class':("btn btn-primary"),'value':("Edit Research Question")],-1)
printHtmlPart(19)
})
invokeTag('form','g',125,['controller':("wizardSlr"),'action':("editResQuestions"),'method':("POST"),'name':("myFormEditQuestion"),'id':("myFormEditQuestion")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',140,['name':("idQuestion"),'value':("0")],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',140,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(25)
invokeTag('submitButton','g',147,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(19)
})
invokeTag('form','g',147,['controller':("wizardSlr"),'action':("deleteResQuestions"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(26)
invokeTag('render','g',148,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(27)
expressionOut.print(slrInstance.title)
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',163,['controller':("index"),'action':("menu")],2)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',165,['controller':("slr"),'action':("myList")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
invokeTag('hiddenField','g',187,['name':("guid"),'value':(slrInstance.guid)],-1)
printHtmlPart(34)
invokeTag('submitButton','g',195,['name':("create"),'class':("btn btn-primary"),'value':("Create Criterions"),'onclick':("closeModalWithMessage('myModal','Creating Research Questions...');")],-1)
printHtmlPart(35)
if(true && (null != errorTotal && !errorTotal.equals(""))) {
printHtmlPart(36)
expressionOut.print(errorTotal)
printHtmlPart(37)
}
printHtmlPart(38)
for( questionInstance in (questionListInstance) ) {
printHtmlPart(39)
invokeTag('set','g',211,['var':("contReference"),'value':("0")],-1)
printHtmlPart(40)
expressionOut.print(questionInstance.enunciado)
printHtmlPart(41)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: questionInstance.submitDate))
printHtmlPart(42)
expressionOut.print(questionInstance.id.toString())
printHtmlPart(43)
expressionOut.print(questionInstance.enunciado.toString())
printHtmlPart(44)
if(true && (slrInstance.noDrop == false)) {
printHtmlPart(45)
expressionOut.print(questionInstance.id.toString())
printHtmlPart(46)
}
else {
printHtmlPart(47)
}
printHtmlPart(48)
}
printHtmlPart(49)
})
invokeTag('form','g',226,['class':("form-horizontal"),'controller':("wizardSlr"),'action':("createCriterions"),'method':("POST"),'name':("myForm"),'id':("myForm")],2)
printHtmlPart(50)
invokeTag('render','g',231,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(51)
invokeTag('render','g',236,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(52)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(53)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(54)
})
invokeTag('captureBody','sitemesh',250,['onload':("loadModal();")],1)
printHtmlPart(55)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464480000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
