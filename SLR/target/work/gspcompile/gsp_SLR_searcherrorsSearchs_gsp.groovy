import es.uca.pfc.TaskSearch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_searcherrorsSearchs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/errorsSearchs.gsp" }
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
printHtmlPart(4)
invokeTag('render','g',14,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',50,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',59,['controller':("index"),'action':("menu")],2)
printHtmlPart(10)
for( taskInstance in (taskWithErrors) ) {
printHtmlPart(11)
expressionOut.print(taskInstance.id)
printHtmlPart(12)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: taskInstance.submitDate))
printHtmlPart(12)
expressionOut.print(taskInstance.username)
printHtmlPart(13)
expressionOut.print(taskInstance.strException)
printHtmlPart(14)
expressionOut.print(taskInstance.id.toString())
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('render','g',95,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(17)
invokeTag('render','g',99,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(18)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(19)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',112,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464403000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
