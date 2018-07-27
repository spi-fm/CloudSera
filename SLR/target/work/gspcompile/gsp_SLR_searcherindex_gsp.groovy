import es.uca.pfc.User
import es.uca.pfc.Slr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_searcherindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/searcher/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('render','g',9,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
invokeTag('render','g',15,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',23,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(8)
expressionOut.print(query)
printHtmlPart(9)
if(true && (totalUserList + totalSlrList == 0)) {
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (userList.size() > 0)) {
printHtmlPart(12)
expressionOut.print(totalUserList)
printHtmlPart(13)
expressionOut.print(userList.size())
printHtmlPart(14)
if(true && (userList.size() > 0)) {
printHtmlPart(15)
for( userInstance in (userList) ) {
printHtmlPart(16)
expressionOut.print(userInstance.url_foto)
printHtmlPart(17)
expressionOut.print(userInstance.display_name)
printHtmlPart(18)
createTagBody(5, {->
expressionOut.print(userInstance.display_name)
})
invokeTag('link','g',57,['controller':("user"),'action':("show"),'params':([guid: "${userInstance.guid}"])],5)
printHtmlPart(19)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: userInstance.fechaRegistro))
printHtmlPart(20)
expressionOut.print(userInstance.slrs.size())
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (slrList.size() > 0)) {
printHtmlPart(25)
expressionOut.print(totalSlrList)
printHtmlPart(13)
expressionOut.print(slrList.size())
printHtmlPart(26)
if(true && (slrList.size() > 0)) {
printHtmlPart(15)
for( slrInstance in (slrList) ) {
printHtmlPart(16)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(17)
expressionOut.print(slrInstance.title)
printHtmlPart(18)
createTagBody(5, {->
expressionOut.print(slrInstance.title)
})
invokeTag('link','g',84,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],5)
printHtmlPart(27)
createTagBody(5, {->
expressionOut.print(slrInstance.userProfile.display_name)
})
invokeTag('link','g',85,['controller':("user"),'action':("show"),'params':([guid: "${slrInstance.userProfile.guid}"])],5)
printHtmlPart(28)
expressionOut.print(slrInstance.totalReferences)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(29)
}
printHtmlPart(30)
invokeTag('render','g',98,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(31)
invokeTag('render','g',103,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',104,['onload':("loadModal();")],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464408000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
