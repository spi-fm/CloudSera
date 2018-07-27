import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLRindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('render','g',5,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(resource(dir:'images/galery_index', file:'portada1.jpg'))
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',88,['class':("btn btn-lg btn-primary"),'role':("button"),'controller':("login")],2)
printHtmlPart(9)
expressionOut.print(resource(dir:'images/galery_index', file:'portada2.jpg'))
printHtmlPart(10)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',98,['class':("btn btn-lg btn-primary"),'role':("button"),'controller':("login")],2)
printHtmlPart(11)
expressionOut.print(resource(dir:'images/galery_index', file:'portada3.jpg'))
printHtmlPart(12)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',108,['class':("btn btn-lg btn-primary"),'role':("button"),'controller':("login")],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',213,['onload':("activeGalery();")],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523876577000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
