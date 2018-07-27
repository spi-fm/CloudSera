import es.uca.pfc.EngineSearch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_engineSearchindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/engineSearch/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('render','g',8,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('render','g',13,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(4)
expressionOut.print(null != updateOk && updateOk)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('render','g',37,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',45,['controller':("index"),'action':("menu")],3)
printHtmlPart(10)
invokeTag('submitButton','g',49,['name':("create"),'class':("btn btn-primary"),'value':("Save changes")],-1)
printHtmlPart(11)
for( engineSearchInstance in (engineSearchListInstance) ) {
printHtmlPart(12)
expressionOut.print(engineSearchInstance.display_name)
printHtmlPart(13)
expressionOut.print('input' + engineSearchInstance.name)
printHtmlPart(14)
expressionOut.print('input' + engineSearchInstance.name)
printHtmlPart(15)
expressionOut.print('input' + engineSearchInstance.name)
printHtmlPart(16)
expressionOut.print(engineSearchInstance.apiKey)
printHtmlPart(17)
if(true && (engineSearchInstance.status == true)) {
printHtmlPart(18)
expressionOut.print('cbox' + engineSearchInstance.name)
printHtmlPart(15)
expressionOut.print('cbox' + engineSearchInstance.name)
printHtmlPart(19)
}
else {
printHtmlPart(18)
expressionOut.print('cbox' + engineSearchInstance.name)
printHtmlPart(15)
expressionOut.print('cbox' + engineSearchInstance.name)
printHtmlPart(20)
}
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('render','g',88,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(23)
})
invokeTag('form','g',89,['class':("form-horizontal"),'controller':("engineSearch"),'action':("save"),'method':("POST"),'name':("myForm"),'id':("myForm")],2)
printHtmlPart(24)
invokeTag('render','g',93,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',95,['onload':("loadMessageSucess();")],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523463741000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
