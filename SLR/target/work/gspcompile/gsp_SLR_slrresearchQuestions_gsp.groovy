import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.ResearchQuestion
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slrresearchQuestions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/researchQuestions.gsp" }
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
invokeTag('captureHead','sitemesh',61,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',76,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(14)
if(true && (null != errorQuestion && !errorQuestion.equals(""))) {
printHtmlPart(15)
expressionOut.print(errorQuestion)
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(enunciadoQuestion)
printHtmlPart(18)
invokeTag('submitButton','g',93,['name':("create"),'class':("btn btn-primary"),'value':("Create Research Question")],-1)
printHtmlPart(19)
})
invokeTag('form','g',93,['controller':("researchQuestion"),'action':("save"),'method':("POST"),'name':("myFormQuestion"),'id':("myFormQuestion")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',108,['name':("idEditQuestion"),'value':(idEditQuestion)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',109,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(14)
if(true && (null != errorEditQuestion && !errorEditQuestion.equals(""))) {
printHtmlPart(21)
expressionOut.print(errorEditQuestion)
printHtmlPart(16)
}
printHtmlPart(22)
expressionOut.print(enunciadoEditQuestion)
printHtmlPart(18)
invokeTag('submitButton','g',125,['name':("create"),'class':("btn btn-primary"),'value':("Edit Research Question")],-1)
printHtmlPart(19)
})
invokeTag('form','g',126,['controller':("researchQuestion"),'action':("edit"),'method':("POST"),'name':("myFormEditQuestion"),'id':("myFormEditQuestion")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',141,['name':("idQuestion"),'value':("0")],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',141,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(25)
invokeTag('submitButton','g',148,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(19)
})
invokeTag('form','g',148,['controller':("researchQuestion"),'action':("delete"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(26)
invokeTag('render','g',149,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(27)
expressionOut.print(slrInstance.title)
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',164,['controller':("index"),'action':("menu")],2)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',166,['controller':("slr"),'action':("myList")],2)
printHtmlPart(30)
createTagBody(2, {->
expressionOut.print(slrBreadCrumb)
})
invokeTag('link','g',168,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],2)
printHtmlPart(32)
for( questionInstance in (questionListInstance) ) {
printHtmlPart(33)
invokeTag('set','g',191,['var':("contReference"),'value':("0")],-1)
printHtmlPart(34)
expressionOut.print(questionInstance.enunciado)
printHtmlPart(35)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: questionInstance.submitDate))
printHtmlPart(36)
expressionOut.print(questionInstance.id.toString())
printHtmlPart(37)
expressionOut.print(questionInstance.enunciado.toString())
printHtmlPart(38)
if(true && (slrInstance.noDrop == false)) {
printHtmlPart(39)
expressionOut.print(questionInstance.id.toString())
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
invokeTag('render','g',211,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(44)
invokeTag('render','g',216,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(45)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(46)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(47)
})
invokeTag('captureBody','sitemesh',230,['onload':("loadModal();")],1)
printHtmlPart(48)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464430000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
