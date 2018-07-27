import es.uca.pfc.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_menucenter_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_menucenter.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print((User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.slrs.size() > 100 ? "+100" : User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.slrs.size().toString()))
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('link','g',22,['controller':("slr"),'action':("myList")],1)
printHtmlPart(3)
expressionOut.print(totalRefsIncluded)
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',44,['controller':("slr"),'action':("myList")],1)
printHtmlPart(6)
expressionOut.print(totalTaskSearchs)
printHtmlPart(7)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',66,['controller':("index"),'action':("taskSearchs")],1)
printHtmlPart(8)
expressionOut.print((User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.friends.size() > 100 ? "+100" : User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.friends.size().toString()))
printHtmlPart(9)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',88,['controller':("user"),'action':("friends"),'params':([guid: "${User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.guid}"])],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1499004150000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
