import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_indexmenu_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/menu.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(lang)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('render','g',7,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(5)
invokeTag('render','g',13,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',22,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(8)
invokeTag('message','g',27,['code':("pfc.main.h1"),'locale':(languageDefault)],-1)
printHtmlPart(9)
invokeTag('render','g',32,['template':("menucenter"),'contextPath':("/")],-1)
printHtmlPart(10)
invokeTag('render','g',40,['template':("logger"),'contextPath':("/")],-1)
printHtmlPart(11)
invokeTag('render','g',41,['template':("donut"),'contextPath':("/")],-1)
printHtmlPart(12)
invokeTag('render','g',43,['template':("statgraphics"),'contextPath':("/")],-1)
printHtmlPart(13)
invokeTag('render','g',49,['template':("lastslrs"),'contextPath':("/")],-1)
printHtmlPart(14)
invokeTag('render','g',51,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(15)
invokeTag('render','g',54,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(16)
invokeTag('render','g',57,['template':("graphGoogleIndex"),'contextPath':("/graphs")],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464290000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
