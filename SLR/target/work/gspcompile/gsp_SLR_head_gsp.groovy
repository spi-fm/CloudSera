import es.uca.pfc.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_head_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_head.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print((request.forwardURI.contains("references") ? 'SLR' : 'Systematic Literature Review'))
printHtmlPart(2)
})
invokeTag('link','g',10,['class':("navbar-brand"),'controller':("index"),'action':("index"),'style':("font-size: 25px;")],1)
printHtmlPart(3)
invokeTag('include','g',20,['controller':("index"),'action':("loadNotifications")],-1)
printHtmlPart(4)
invokeTag('include','g',25,['controller':("index"),'action':("loadTaskSearchsHead")],-1)
printHtmlPart(5)
expressionOut.print(User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.display_name)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('message','g',93,['code':("pfc.main.top.profile"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',93,['controller':("user"),'action':("show"),'params':([guid: "${User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.guid}"])],1)
printHtmlPart(8)
invokeTag('message','g',95,['code':("pfc.main.top.setting"),'locale':(languageDefault)],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
invokeTag('message','g',98,['code':("pfc.main.top.logout"),'locale':(languageDefault)],-1)
})
invokeTag('link','g',98,['controller':("logout")],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('message','g',114,['code':("pfc.searcher.placeholder"),'locale':(languageDefault)],-1)
printHtmlPart(13)
})
invokeTag('form','g',114,['class':("form-horizontal"),'controller':("searcher"),'action':("search"),'method':("POST"),'name':("myForm"),'id':("myForm")],1)
printHtmlPart(14)
invokeTag('render','g',117,['template':("menuleft"),'contextPath':("/")],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500117374000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
