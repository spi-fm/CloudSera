import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_index_taskBackgroundProccess_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/_taskBackgroundProccess.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (taskList.size() == 0)) {
printHtmlPart(1)
}
else {
printHtmlPart(2)
for( taskInstance in (taskList) ) {
printHtmlPart(3)
expressionOut.print(taskInstance.slr.title)
printHtmlPart(4)
expressionOut.print(taskInstance.porcentaje)
printHtmlPart(5)
expressionOut.print(taskInstance.porcentaje)
printHtmlPart(6)
expressionOut.print(taskInstance.porcentaje)
printHtmlPart(7)
expressionOut.print(taskInstance.porcentaje)
printHtmlPart(8)
}
printHtmlPart(9)
}
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1498065296000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
