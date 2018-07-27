import es.uca.pfc.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_userfriends_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/friends.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('render','g',9,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
invokeTag('render','g',15,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('render','g',24,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(7)
loop:{
int i = 0
for( userProfileInstance in (userProfileListInstance) ) {
printHtmlPart(8)
expressionOut.print(i+1)
printHtmlPart(9)
if(true && (userProfileInstance.isOnline)) {
printHtmlPart(10)
expressionOut.print(userProfileInstance.display_name)
printHtmlPart(11)
}
else {
printHtmlPart(12)
expressionOut.print(userProfileInstance.display_name)
printHtmlPart(11)
}
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(userProfileInstance.user.username)
})
invokeTag('link','g',59,['controller':("user"),'action':("show"),'params':([guid: "${userProfileInstance.guid}"])],3)
printHtmlPart(14)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: userProfileInstance.fechaRegistro))
printHtmlPart(15)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: userProfileInstance.ultimaConexion))
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
invokeTag('render','g',74,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(18)
invokeTag('render','g',79,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(19)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(20)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',89,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464458000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
