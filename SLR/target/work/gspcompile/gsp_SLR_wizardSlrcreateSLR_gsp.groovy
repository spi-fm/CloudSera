import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.Criterion
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_wizardSlrcreateSLR_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/wizardSlr/createSLR.gsp" }
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
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',24,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',32,['controller':("index"),'action':("menu")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',33,['controller':("slr"),'action':("myList")],2)
printHtmlPart(12)
if(true && (null != error && !error.equals(""))) {
printHtmlPart(13)
expressionOut.print(error)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(tituloSlr)
printHtmlPart(17)
expressionOut.print(justificacionSlr)
printHtmlPart(18)
invokeTag('submitButton','g',79,['name':("create"),'class':("btn btn-primary"),'value':("Create Research Questions"),'onclick':("closeModalWithMessage('myModal','Creating SLR...');")],-1)
printHtmlPart(19)
})
invokeTag('form','g',80,['class':("form-horizontal"),'controller':("wizardSlr"),'action':("saveSLR"),'method':("POST"),'name':("myForm"),'id':("myForm")],2)
printHtmlPart(20)
invokeTag('render','g',88,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(21)
invokeTag('render','g',93,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464489000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
