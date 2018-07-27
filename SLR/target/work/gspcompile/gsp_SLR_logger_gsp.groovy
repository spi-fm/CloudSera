import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_logger_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_logger.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("pfc.logger.title"),'locale':(languageDefault)],-1)
printHtmlPart(1)
for( loggerInstance in (loggerListInstance) ) {
printHtmlPart(2)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(3)
if(true && (loggerInstance.friendProfile.url_foto.toString().contains('unknown_user.png'))) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/user', file: 'unknown_user.png'))
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(loggerInstance.friendProfile.url_foto)
printHtmlPart(5)
}
printHtmlPart(7)
}
else {
printHtmlPart(3)
if(true && (loggerInstance.profile.url_foto.toString().contains('unknown_user.png'))) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/user', file: 'unknown_user.png'))
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(loggerInstance.profile.url_foto)
printHtmlPart(5)
}
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(9)
expressionOut.print(loggerInstance.friendProfile.display_name)
printHtmlPart(10)
}
else {
printHtmlPart(9)
invokeTag('message','g',63,['code':("pfc.logger.user.me"),'locale':(languageDefault)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(loggerInstance.timeString)
printHtmlPart(12)
if(true && (loggerInstance.tipo == 'bienvenida')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(13)
invokeTag('message','g',71,['code':("pfc.logger.welcome"),'locale':(languageDefault)],-1)
printHtmlPart(3)
}
else if(true && (loggerInstance.tipo == 'fr-bienvenida')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(13)
invokeTag('message','g',74,['code':("pfc.logger.registered"),'locale':(languageDefault)],-1)
printHtmlPart(3)
}
else if(true && (loggerInstance.tipo == 'crear')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(13)
invokeTag('message','g',77,['code':("pfc.logger.me.slr.created"),'locale':(languageDefault)],-1)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',77,['controller':("slr"),'action':("myList")],3)
printHtmlPart(3)
}
else if(true && (loggerInstance.tipo == 'fr-crear')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(13)
invokeTag('message','g',80,['code':("pfc.logger.me.slr.created"),'locale':(languageDefault)],-1)
printHtmlPart(14)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(3)
}
else if(true && (loggerInstance.tipo == 'buscar')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(13)
invokeTag('message','g',83,['code':("pfc.logger.me.search.created"),'locale':(languageDefault)],-1)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',83,['controller':("slr"),'action':("searchs"),'params':([guid: "${loggerInstance.slr.guid}"])],3)
printHtmlPart(3)
}
else if(true && (loggerInstance.tipo == 'fr-buscar')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(13)
invokeTag('message','g',86,['code':("pfc.logger.friend.search.created"),'locale':(languageDefault)],-1)
printHtmlPart(14)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(3)
}
else if(true && (loggerInstance.tipo == 'seguir')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(13)
invokeTag('message','g',89,['code':("pfc.logger.me.friend"),'locale':(languageDefault)],-1)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(loggerInstance.friendProfile.display_name)
})
invokeTag('link','g',89,['controller':("user"),'action':("show"),'params':([guid: "${loggerInstance.friendProfile.guid}"])],3)
printHtmlPart(3)
}
else if(true && (loggerInstance.tipo == 'fr-seguir')) {
printHtmlPart(4)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(13)
invokeTag('message','g',92,['code':("pfc.logger.friend.friend"),'locale':(languageDefault)],-1)
printHtmlPart(14)
expressionOut.print(loggerInstance.friendFriendProfile.display_name)
printHtmlPart(3)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
}
printHtmlPart(17)
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
