import es.uca.pfc.User
import es.uca.pfc.UserProfile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_usershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/show.gsp" }
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
createTagBody(3, {->
printHtmlPart(4)
if(true && (isMyProfile)) {
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(profileInstance.display_name)
printHtmlPart(4)
}
printHtmlPart(7)
})
invokeTag('captureTitle','sitemesh',17,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',18,[:],2)
printHtmlPart(8)
invokeTag('render','g',22,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(9)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css'))
printHtmlPart(10)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-responsive/css/dataTables.responsive.css'))
printHtmlPart(11)
expressionOut.print(isSynchro != null && isSynchro)
printHtmlPart(12)
expressionOut.print(isSynchro != null && !isSynchro)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',71,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
invokeTag('render','g',81,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(16)
if(true && (isMyProfile)) {
printHtmlPart(17)
invokeTag('message','g',87,['code':("pfc.profile.me.h1"),'locale':(languageDefault)],-1)
printHtmlPart(18)
}
else {
printHtmlPart(17)
invokeTag('message','g',90,['code':("pfc.profile.other.h1"),'locale':(languageDefault)],-1)
printHtmlPart(19)
expressionOut.print(profileInstance.display_name)
printHtmlPart(18)
}
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',93,['controller':("index"),'action':("menu")],2)
printHtmlPart(22)
if(true && (isMyProfile)) {
printHtmlPart(23)
invokeTag('message','g',95,['code':("pfc.profile.me.h1"),'locale':(languageDefault)],-1)
printHtmlPart(22)
}
else {
printHtmlPart(23)
invokeTag('message','g',98,['code':("pfc.profile.other.h1"),'locale':(languageDefault)],-1)
printHtmlPart(19)
expressionOut.print(profileInstance.display_name)
printHtmlPart(22)
}
printHtmlPart(24)
if(true && (profileInstance.url_foto.toString().contains('unknown_user.png'))) {
printHtmlPart(25)
expressionOut.print(resource(dir:'images/user', file: 'unknown_user.png'))
printHtmlPart(26)
}
else {
printHtmlPart(25)
expressionOut.print(profileInstance.url_foto)
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(profileInstance.link)
printHtmlPart(29)
if(true && (!isMyProfile)) {
printHtmlPart(30)
if(true && (isMyFriend == 'S')) {
printHtmlPart(31)
createClosureForHtmlPart(32, 4)
invokeTag('link','g',125,['elementId':("btn_friend"),'id':("btn_friend"),'type':("button"),'class':("btn btn-success btn-lg btn-block"),'onmouseover':("changeColourFriend();"),'onmouseout':("changeColourFriend();"),'controller':("user"),'action':("removeFollower"),'params':([guid: "${profileInstance.guid}"])],4)
printHtmlPart(30)
}
else if(true && (isMyFriend == 'P')) {
printHtmlPart(33)
}
else {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',131,['elementId':("btn_friend_2"),'id':("btn_friend_2"),'type':("button"),'class':("btn btn-default btn-lg btn-block"),'onmouseover':("changeColourFriend2();"),'onmouseout':("changeColourFriend2();"),'controller':("user"),'action':("addFollower"),'params':([guid: "${profileInstance.guid}"])],4)
printHtmlPart(30)
}
printHtmlPart(36)
}
else {
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',133,['code':("pfc.profile.button.synchro"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',133,['type':("buton"),'class':("btn btn-primary"),'controller':("user"),'action':("synchronizeUserProfile"),'onclick':("loading('Synchronizing profile...');"),'params':([guid: "${profileInstance.guid}"])],3)
printHtmlPart(36)
}
printHtmlPart(37)
invokeTag('message','g',138,['code':("pfc.profile.onglet.personal.info"),'locale':(languageDefault)],-1)
printHtmlPart(38)
if(true && (profileInstance.user.id != User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).id)) {
printHtmlPart(39)
invokeTag('message','g',144,['code':("pfc.profile.onglet.list.slr"),'locale':(languageDefault)],-1)
printHtmlPart(40)
expressionOut.print(profileInstance.slrs.size())
printHtmlPart(41)
invokeTag('message','g',146,['code':("pfc.profile.onglet.list.education"),'locale':(languageDefault)],-1)
printHtmlPart(40)
expressionOut.print(profileInstance.educations.size())
printHtmlPart(42)
invokeTag('message','g',147,['code':("pfc.profile.onglet.list.friend"),'locale':(languageDefault)],-1)
printHtmlPart(40)
expressionOut.print(profileInstance.friends.size())
printHtmlPart(43)
}
else {
printHtmlPart(39)
invokeTag('message','g',148,['code':("pfc.profile.onglet.me.list.slr"),'locale':(languageDefault)],-1)
printHtmlPart(40)
expressionOut.print(profileInstance.slrs.size())
printHtmlPart(41)
invokeTag('message','g',151,['code':("pfc.profile.onglet.me.list.education"),'locale':(languageDefault)],-1)
printHtmlPart(40)
expressionOut.print(profileInstance.educations.size())
printHtmlPart(42)
invokeTag('message','g',152,['code':("pfc.profile.onglet.me.list.friend"),'locale':(languageDefault)],-1)
printHtmlPart(40)
expressionOut.print(profileInstance.friends.size())
printHtmlPart(43)
}
printHtmlPart(44)
invokeTag('fieldValue','g',159,['bean':(profileInstance),'field':("first_name")],-1)
printHtmlPart(45)
invokeTag('fieldValue','g',161,['bean':(profileInstance),'field':("last_name")],-1)
printHtmlPart(46)
invokeTag('fieldValue','g',162,['bean':(profileInstance.user),'field':("username")],-1)
printHtmlPart(47)
if(true && (profileInstance.link.toString().contains("http://"))) {
printHtmlPart(48)
expressionOut.print(profileInstance.link.toString())
printHtmlPart(49)
expressionOut.print(profileInstance.link)
printHtmlPart(50)
}
else {
printHtmlPart(48)
expressionOut.print(profileInstance.link.toString())
printHtmlPart(49)
expressionOut.print(profileInstance.link)
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(formatDate(format: 'dd MMM, yyyy - HH:mm', date: profileInstance.fechaRegistro))
printHtmlPart(52)
expressionOut.print(profileInstance.research_interests)
printHtmlPart(53)
expressionOut.print(profileInstance.academic_status)
printHtmlPart(54)
expressionOut.print(profileInstance.locationName)
printHtmlPart(55)
expressionOut.print(profileInstance.discipline)
printHtmlPart(56)
if(true && (profileInstance.biography.equals(""))) {
printHtmlPart(57)
}
else {
printHtmlPart(58)
invokeTag('fieldValue','g',179,['bean':(profileInstance),'field':("biography")],-1)
printHtmlPart(59)
}
printHtmlPart(60)
for( educationInstance in (profileInstance.educations) ) {
printHtmlPart(61)
expressionOut.print(educationInstance.degree)
printHtmlPart(62)
expressionOut.print(educationInstance.institution)
printHtmlPart(62)
expressionOut.print(educationInstance.website)
printHtmlPart(62)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: educationInstance.start_date))
printHtmlPart(62)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy', date: educationInstance.end_date))
printHtmlPart(63)
}
printHtmlPart(64)
for( slrInstance in (profileInstance.slrs) ) {
printHtmlPart(61)
expressionOut.print(slrInstance.title)
printHtmlPart(62)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: slrInstance.submitDate))
printHtmlPart(62)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: slrInstance.lastModified))
printHtmlPart(65)
}
printHtmlPart(66)
for( friendInstance in (profileInstance.friends) ) {
printHtmlPart(61)
createTagBody(3, {->
expressionOut.print(friendInstance.display_name)
})
invokeTag('link','g',294,['controller':("user"),'action':("show"),'params':([guid: "${friendInstance.guid}"])],3)
printHtmlPart(62)
expressionOut.print(friendInstance.user.username)
printHtmlPart(62)
expressionOut.print(friendInstance.discipline)
printHtmlPart(62)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: friendInstance.fechaRegistro))
printHtmlPart(62)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: friendInstance.ultimaConexion))
printHtmlPart(63)
}
printHtmlPart(67)
invokeTag('render','g',305,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(68)
invokeTag('render','g',307,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(69)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(70)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(71)
})
invokeTag('captureBody','sitemesh',334,['onload':("showMsgSynchro();")],1)
printHtmlPart(72)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523876558000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
