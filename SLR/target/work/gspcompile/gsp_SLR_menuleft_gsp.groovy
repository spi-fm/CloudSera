import es.uca.pfc.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_menuleft_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_menuleft.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (!request.forwardURI.contains("references"))) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('message','g',9,['code':("pfc.main.left.main.menu"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',9,['controller':("index"),'action':("menu")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',13,['code':("pfc.main.left.profile"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',13,['controller':("user"),'action':("show"),'params':([guid: "${User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.guid.toString()}"])],2)
printHtmlPart(5)
if(true && (!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER"))) {
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
invokeTag('message','g',21,['code':("pfc.main.left.users"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',22,['controller':("user"),'action':("list")],3)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',24,['code':("pfc.main.left.slr"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',24,['controller':("slr"),'action':("myList")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',26,['code':("pfc.main.left.logger"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',26,['controller':("index"),'action':("loggers")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',28,['code':("pfc.main.left.faqs"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',28,['controller':("index"),'action':("faqs")],2)
printHtmlPart(5)
if(true && (!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER"))) {
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('message','g',35,['code':("pfc.main.left.engines"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',35,['controller':("engineSearch"),'action':("index")],3)
printHtmlPart(8)
}
printHtmlPart(15)
if(true && (!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER"))) {
printHtmlPart(13)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',39,['controller':("mendeleyApi"),'action':("index")],3)
printHtmlPart(8)
}
printHtmlPart(17)
if(true && (!User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).getAuthorities().toString().contains("USER"))) {
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('message','g',44,['code':("pfc.main.left.error.search"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',44,['controller':("search"),'action':("errorsSearchs")],3)
printHtmlPart(8)
}
printHtmlPart(9)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',45,['controller':("index"),'action':("about")],2)
printHtmlPart(20)
}
else {
printHtmlPart(21)
invokeTag('render','g',47,['template':("menuLeftSearch"),'contextPath':("/slr")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1499879400000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
