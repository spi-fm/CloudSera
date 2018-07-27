import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_lastslrs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_lastslrs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (lastSlrCreated.size() > 0)) {
printHtmlPart(0)
for( slrInstance in (lastSlrCreated) ) {
printHtmlPart(1)
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(slrInstance.userProfile.display_name)
printHtmlPart(3)
expressionOut.print(slrInstance.timeString)
printHtmlPart(4)
expressionOut.print(slrInstance.title)
printHtmlPart(5)
})
invokeTag('link','g',15,['class':("list-group-item"),'controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],3)
printHtmlPart(6)
}
printHtmlPart(7)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1499004150000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
