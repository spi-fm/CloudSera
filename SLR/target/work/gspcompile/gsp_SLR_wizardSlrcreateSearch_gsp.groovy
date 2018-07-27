import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.Criterion
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_wizardSlrcreateSearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/wizardSlr/createSearch.gsp" }
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
printHtmlPart(0)
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
expressionOut.print(slrInstance.title)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',60,['controller':("search"),'action':("create"),'params':([guidSlr:"${slrInstance.guid}"])],2)
printHtmlPart(15)
invokeTag('render','g',70,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(16)
invokeTag('render','g',75,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(17)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(18)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464484000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
