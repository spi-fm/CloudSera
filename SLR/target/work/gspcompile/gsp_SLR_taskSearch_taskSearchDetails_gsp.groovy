import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_taskSearch_taskSearchDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/taskSearch/_taskSearchDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',6,['controller':("index"),'action':("menu")],1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',7,['controller':("index"),'action':("taskSearchs")],1)
printHtmlPart(4)
createTagBody(1, {->
expressionOut.print(taskSearchInstance.titleSlr)
})
invokeTag('link','g',19,['controller':("slr"),'action':("searchs"),'params':([guid: "${taskSearchInstance.guidSlr}"])],1)
printHtmlPart(5)
if(true && (taskSearchInstance.hasErrors)) {
printHtmlPart(6)
}
else {
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(taskSearchInstance.details)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1499592996000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
