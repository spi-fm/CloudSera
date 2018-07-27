import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_index_paginationMyLogger_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/_paginationMyLogger.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (totalMyLoggers > 1)) {
printHtmlPart(0)
if(true && (totalMyLoggers <= 3)) {
printHtmlPart(1)
for( p in ((1..<(totalMyLoggers+1))) ) {
printHtmlPart(2)
if(true && (p == pageMyLoggers)) {
printHtmlPart(3)
expressionOut.print(p)
printHtmlPart(4)
}
else {
printHtmlPart(5)
expressionOut.print(p)
printHtmlPart(4)
}
printHtmlPart(6)
}
printHtmlPart(7)
}
else {
printHtmlPart(8)
if(true && (pageMyLoggers == 1)) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (pageMyLoggers == 1)) {
printHtmlPart(12)
expressionOut.print(pageMyLoggers)
printHtmlPart(13)
expressionOut.print(pageMyLoggers+1)
printHtmlPart(13)
expressionOut.print(pageMyLoggers+2)
printHtmlPart(14)
}
else if(true && ((pageMyLoggers+1) == totalMyLoggers)) {
printHtmlPart(15)
expressionOut.print(pageMyLoggers-1)
printHtmlPart(16)
expressionOut.print(pageMyLoggers)
printHtmlPart(13)
expressionOut.print(pageMyLoggers+1)
printHtmlPart(14)
}
else if(true && (pageMyLoggers == totalMyLoggers)) {
printHtmlPart(15)
expressionOut.print(pageMyLoggers-2)
printHtmlPart(13)
expressionOut.print(pageMyLoggers-1)
printHtmlPart(16)
expressionOut.print(pageMyLoggers)
printHtmlPart(14)
}
else {
printHtmlPart(2)
for( p in (((pageMyLoggers-1)..<(pageMyLoggers+2))) ) {
printHtmlPart(17)
if(true && (p == pageMyLoggers)) {
printHtmlPart(18)
expressionOut.print(p)
printHtmlPart(19)
}
else {
printHtmlPart(20)
expressionOut.print(p)
printHtmlPart(19)
}
printHtmlPart(2)
}
printHtmlPart(1)
}
printHtmlPart(21)
if(true && (pageMyLoggers == totalMyLoggers)) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(25)
}
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1461491808000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
