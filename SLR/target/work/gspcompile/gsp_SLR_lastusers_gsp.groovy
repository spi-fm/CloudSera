import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_lastusers_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_lastusers.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( profileInstance in (lastUsersRegistered) ) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
if(true && (profileInstance.isOnline)) {
printHtmlPart(3)
expressionOut.print(profileInstance.display_name)
printHtmlPart(2)
}
else {
printHtmlPart(4)
expressionOut.print(profileInstance.display_name)
printHtmlPart(2)
}
printHtmlPart(2)
if(true && (profileInstance.isOnline)) {
printHtmlPart(5)
}
else {
printHtmlPart(6)
}
printHtmlPart(1)
})
invokeTag('link','g',25,['class':("list-group-item"),'controller':("user"),'action':("show"),'params':([guid: "${profileInstance.guid}"])],2)
printHtmlPart(7)
}
printHtmlPart(8)
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
