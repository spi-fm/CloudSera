import es.uca.pfc.User
import es.uca.pfc.UserProfile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_indexloggers_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/loggers.gsp" }
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
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(5)
invokeTag('render','g',17,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',26,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',34,['controller':("index"),'action':("menu")],2)
printHtmlPart(10)
expressionOut.print((currentOnglet == 'all' ? 'active' : ''))
printHtmlPart(11)
expressionOut.print((currentOnglet == 'my' ? 'active' : ''))
printHtmlPart(12)
expressionOut.print((currentOnglet == 'friend' ? 'active' : ''))
printHtmlPart(13)
if(true && (totalAllLoggers == 0)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
for( loggerInstance in (allLoggers) ) {
printHtmlPart(16)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(17)
expressionOut.print(loggerInstance.friendProfile.url_foto)
printHtmlPart(18)
}
else {
printHtmlPart(17)
expressionOut.print(loggerInstance.profile.url_foto)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(20)
expressionOut.print(loggerInstance.friendProfile.display_name)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(loggerInstance.timeString)
printHtmlPart(24)
if(true && (loggerInstance.tipo == 'bienvenida')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(26)
}
else if(true && (loggerInstance.tipo == 'fr-bienvenida')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(27)
}
else if(true && (loggerInstance.tipo == 'crear')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(28)
createTagBody(5, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',100,['controller':("slr"),'action':("myList")],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-crear')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(30)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'buscar')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(31)
createTagBody(5, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',106,['controller':("slr"),'action':("searchs"),'params':([guid: "${loggerInstance.slr.guid}"])],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-buscar')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(32)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'seguir')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(33)
createTagBody(5, {->
expressionOut.print(loggerInstance.friendProfile.display_name)
})
invokeTag('link','g',112,['controller':("user"),'action':("show"),'params':([guid: "${loggerInstance.friendProfile.guid}"])],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-seguir')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(34)
expressionOut.print(loggerInstance.friendFriendProfile.display_name)
printHtmlPart(29)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('render','g',123,['template':("paginationAllLogger"),'contextPath':("/index")],-1)
printHtmlPart(39)
if(true && (totalFriendsLoggers == 0)) {
printHtmlPart(40)
}
else {
printHtmlPart(15)
for( loggerInstance in (friendsLogers) ) {
printHtmlPart(16)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(17)
expressionOut.print(loggerInstance.friendProfile.url_foto)
printHtmlPart(18)
}
else {
printHtmlPart(17)
expressionOut.print(loggerInstance.profile.url_foto)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(20)
expressionOut.print(loggerInstance.friendProfile.display_name)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(loggerInstance.timeString)
printHtmlPart(24)
if(true && (loggerInstance.tipo == 'bienvenida')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(26)
}
else if(true && (loggerInstance.tipo == 'fr-bienvenida')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(27)
}
else if(true && (loggerInstance.tipo == 'crear')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(28)
createTagBody(5, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',176,['controller':("slr"),'action':("myList")],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-crear')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(30)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'buscar')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(31)
createTagBody(5, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',183,['controller':("slr"),'action':("searchs"),'params':([guid: "${loggerInstance.slr.guid}"])],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-buscar')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(32)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'seguir')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(33)
createTagBody(5, {->
expressionOut.print(loggerInstance.friendProfile.display_name)
})
invokeTag('link','g',189,['controller':("user"),'action':("show"),'params':([guid: "${loggerInstance.friendProfile.guid}"])],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-seguir')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(34)
expressionOut.print(loggerInstance.friendFriendProfile.display_name)
printHtmlPart(29)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('render','g',195,['template':("paginationFriendsLogger"),'contextPath':("/index")],-1)
printHtmlPart(41)
if(true && (totalMyLoggers == 0)) {
printHtmlPart(42)
}
else {
printHtmlPart(15)
for( loggerInstance in (myLoggers) ) {
printHtmlPart(16)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(17)
expressionOut.print(loggerInstance.friendProfile.url_foto)
printHtmlPart(18)
}
else {
printHtmlPart(17)
expressionOut.print(loggerInstance.profile.url_foto)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (loggerInstance.tipo.contains('fr-'))) {
printHtmlPart(20)
expressionOut.print(loggerInstance.friendProfile.display_name)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(loggerInstance.timeString)
printHtmlPart(24)
if(true && (loggerInstance.tipo == 'bienvenida')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(26)
}
else if(true && (loggerInstance.tipo == 'fr-bienvenida')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'start.png'))
printHtmlPart(27)
}
else if(true && (loggerInstance.tipo == 'crear')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(28)
createTagBody(5, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',252,['controller':("slr"),'action':("myList")],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-crear')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'libro.jpg'))
printHtmlPart(30)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'buscar')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(31)
createTagBody(5, {->
expressionOut.print(loggerInstance.slr.title)
})
invokeTag('link','g',259,['controller':("slr"),'action':("searchs"),'params':([guid: "${loggerInstance.slr.guid}"])],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-buscar')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'lupa.jpg'))
printHtmlPart(32)
expressionOut.print(loggerInstance.slr.title)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'seguir')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(33)
createTagBody(5, {->
expressionOut.print(loggerInstance.friendProfile.display_name)
})
invokeTag('link','g',265,['controller':("user"),'action':("show"),'params':([guid: "${loggerInstance.friendProfile.guid}"])],5)
printHtmlPart(29)
}
else if(true && (loggerInstance.tipo == 'fr-seguir')) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/logger',file:'friend.png'))
printHtmlPart(34)
expressionOut.print(loggerInstance.friendFriendProfile.display_name)
printHtmlPart(29)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('render','g',270,['template':("paginationMyLogger"),'contextPath':("/index")],-1)
printHtmlPart(43)
invokeTag('render','g',278,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(44)
invokeTag('render','g',283,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',283,[:],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523876165000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
