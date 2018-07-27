import es.uca.pfc.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_userlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/list.gsp" }
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
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('hiddenField','g',39,['name':("guidUserEnabled"),'value':("0")],-1)
printHtmlPart(9)
invokeTag('submitButton','g',45,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(10)
})
invokeTag('form','g',45,['controller':("user"),'action':("enabledUser"),'id':("myFormEnabled"),'name':("myFormEnabled"),'method':("POST")],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('hiddenField','g',60,['name':("guidUserDisabled"),'value':("0")],-1)
printHtmlPart(12)
invokeTag('submitButton','g',66,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(10)
})
invokeTag('form','g',66,['controller':("user"),'action':("disabledUser"),'id':("myFormDisabled"),'name':("myFormDisabled"),'method':("POST")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('hiddenField','g',81,['name':("guidUserRoleAdmin"),'value':("0")],-1)
printHtmlPart(14)
invokeTag('submitButton','g',87,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(10)
})
invokeTag('form','g',87,['controller':("user"),'action':("changeToAdminRole"),'id':("myFormAdminRole"),'name':("myFormAdminRole"),'method':("POST")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('hiddenField','g',102,['name':("guidUserRoleUser"),'value':("0")],-1)
printHtmlPart(16)
invokeTag('submitButton','g',108,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(10)
})
invokeTag('form','g',108,['controller':("user"),'action':("changeToUserRole"),'id':("myFormUserRole"),'name':("myFormUserRole"),'method':("POST")],2)
printHtmlPart(17)
invokeTag('render','g',118,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(18)
if(true && (roleUserLogin != "U")) {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (roleUserLogin != "U")) {
printHtmlPart(21)
}
printHtmlPart(22)
loop:{
int i = 0
for( userInstance in (userListInstance) ) {
printHtmlPart(23)
expressionOut.print(i+1)
printHtmlPart(24)
if(true && (userInstance.userProfile.isOnline)) {
printHtmlPart(25)
expressionOut.print(userInstance.userProfile.display_name)
printHtmlPart(26)
}
else {
printHtmlPart(27)
expressionOut.print(userInstance.userProfile.display_name)
printHtmlPart(26)
}
printHtmlPart(28)
createTagBody(3, {->
expressionOut.print(userInstance.username)
})
invokeTag('link','g',160,['controller':("user"),'action':("show"),'params':([guid: "${userInstance.userProfile.guid}"])],3)
printHtmlPart(29)
if(true && (roleUserLogin != "U")) {
printHtmlPart(30)
expressionOut.print(userInstance.enabled ? "Enabled" : "Disabled")
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: userInstance.userProfile.fechaRegistro))
printHtmlPart(31)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: userInstance.userProfile.ultimaConexion))
printHtmlPart(31)
expressionOut.print(userInstance.getAuthorities().toString().contains("USER") ? "User" : (userInstance.getAuthorities().toString().contains("SUPER") ? "Super Admin" : "Administrador"))
printHtmlPart(29)
if(true && (roleUserLogin != "U")) {
printHtmlPart(32)
if(true && (userLogin.id != userInstance.id && ((roleUserLogin == "S" && !userInstance.getAuthorities().toString().contains("SUPER")) || (roleUserLogin == "A" && userInstance.getAuthorities().toString().contains("USER"))))) {
printHtmlPart(33)
if(true && (!userInstance.enabled)) {
printHtmlPart(34)
expressionOut.print(userInstance.userProfile.guid)
printHtmlPart(35)
}
else {
printHtmlPart(36)
expressionOut.print(userInstance.userProfile.guid)
printHtmlPart(37)
}
printHtmlPart(33)
if(true && (userInstance.getAuthorities().toString().contains("ADMIN"))) {
printHtmlPart(38)
expressionOut.print(userInstance.userProfile.guid)
printHtmlPart(39)
}
else {
printHtmlPart(40)
expressionOut.print(userInstance.userProfile.guid)
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
}
printHtmlPart(44)
i++
}
}
printHtmlPart(45)
invokeTag('render','g',187,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(46)
invokeTag('render','g',190,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(47)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(48)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(49)
})
invokeTag('captureBody','sitemesh',209,[:],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464461000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
