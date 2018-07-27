import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_index_notificationsUser_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/_notificationsUser.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (notificationList.size() > 0)) {
printHtmlPart(1)
expressionOut.print(notificationList.size())
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (notificationList.size() == 0)) {
printHtmlPart(4)
invokeTag('message','g',8,['code':("pfc.main.top.no.notification"),'locale':(languageDefault)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
for( notificationInstance in (notificationList) ) {
printHtmlPart(7)
if(true && (notificationInstance.tipo == 'slr')) {
printHtmlPart(8)
createTagBody(4, {->
printHtmlPart(9)
expressionOut.print(notificationInstance.asunto)
printHtmlPart(10)
expressionOut.print(notificationInstance.fechaString)
printHtmlPart(11)
expressionOut.print(notificationInstance.texto)
printHtmlPart(12)
})
invokeTag('link','g',24,['controller':("slr"),'action':("myList"),'params':([guidNotif: "${notificationInstance.guid}"])],4)
printHtmlPart(13)
}
else if(true && (notificationInstance.tipo == 'search')) {
printHtmlPart(8)
createTagBody(4, {->
printHtmlPart(9)
expressionOut.print(notificationInstance.asunto)
printHtmlPart(14)
expressionOut.print(notificationInstance.fechaString)
printHtmlPart(15)
expressionOut.print(notificationInstance.texto)
printHtmlPart(16)
})
invokeTag('link','g',35,['controller':("slr"),'action':("searchs"),'params':([guid: "${notificationInstance.slr.guid}", guidNotif: "${notificationInstance.guid}"])],4)
printHtmlPart(13)
}
else if(true && (notificationInstance.tipo == 'friend')) {
printHtmlPart(8)
createTagBody(4, {->
printHtmlPart(9)
expressionOut.print(notificationInstance.asunto)
printHtmlPart(14)
expressionOut.print(notificationInstance.fechaString)
printHtmlPart(15)
expressionOut.print(notificationInstance.texto)
printHtmlPart(12)
})
invokeTag('link','g',46,['controller':("user"),'action':("show"),'params':([guid: "${notificationInstance.friendProfile.guid}", guidNotif: "${notificationInstance.guid}"])],4)
printHtmlPart(13)
}
else {
printHtmlPart(17)
expressionOut.print(notificationInstance.asunto)
printHtmlPart(10)
expressionOut.print(notificationInstance.fechaString)
printHtmlPart(11)
expressionOut.print(notificationInstance.texto)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('message','g',64,['code':("pfc.main.top.notification.view.all"),'locale':(languageDefault)],-1)
printHtmlPart(22)
})
invokeTag('link','g',66,['class':("text-center"),'controller':("slr"),'action':("myList"),'params':([guidNotif: 'all'])],2)
printHtmlPart(23)
}
printHtmlPart(24)
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
