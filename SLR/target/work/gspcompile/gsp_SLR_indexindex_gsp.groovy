import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_indexindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('render','g',6,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',51,['controller':("index"),'action':("faqs")],2)
printHtmlPart(8)
expressionOut.print(resource(dir:'images/galery_index', file:'portada1.jpg'))
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',89,['class':("btn btn-lg btn-primary"),'role':("button"),'controller':("login")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',89,['class':("btn btn-lg btn-success"),'role':("button"),'controller':("register")],2)
printHtmlPart(13)
expressionOut.print(resource(dir:'images/galery_index', file:'portada2.jpg'))
printHtmlPart(14)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',99,['class':("btn btn-lg btn-primary"),'role':("button"),'controller':("login")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',99,['class':("btn btn-lg btn-success"),'role':("button"),'controller':("register")],2)
printHtmlPart(15)
expressionOut.print(resource(dir:'images/galery_index', file:'portada3.jpg'))
printHtmlPart(16)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',109,['class':("btn btn-lg btn-primary"),'role':("button"),'controller':("login")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',109,['class':("btn btn-lg btn-success"),'role':("button"),'controller':("register")],2)
printHtmlPart(17)
expressionOut.print(resource(dir:'images/index', file:'imgHeader5.png'))
printHtmlPart(18)
expressionOut.print(resource(dir:'images/index', file:'imgHeader1.png'))
printHtmlPart(19)
expressionOut.print(resource(dir:'images/index', file:'imgHeader3.png'))
printHtmlPart(20)
expressionOut.print(resource(dir:'images/index', file:'imgHeader4.png'))
printHtmlPart(21)
expressionOut.print(resource(dir:'images/index', file:'imgHeader6.ico'))
printHtmlPart(22)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',168,['controller':("index"),'action':("about")],2)
printHtmlPart(24)
expressionOut.print(resource(dir:'images/index', file:'tutorial.jpg'))
printHtmlPart(25)
expressionOut.print(resource(dir:'images/index', file:'imgHeader1.png'))
printHtmlPart(26)
expressionOut.print(resource(dir:'images/index', file:'imgHeader3.png'))
printHtmlPart(27)
expressionOut.print(resource(dir:'images/index', file:'imgHeader4.png'))
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',248,['onload':("activeGalery();")],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523876115000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
