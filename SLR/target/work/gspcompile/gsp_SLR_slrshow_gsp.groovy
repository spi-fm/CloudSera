import es.uca.pfc.User
import es.uca.pfc.Slr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slrshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/show.gsp" }
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
expressionOut.print(slrInstance.title)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
invokeTag('render','g',15,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('hiddenField','g',40,['name':("guidSlr"),'value':("0")],-1)
printHtmlPart(10)
invokeTag('submitButton','g',46,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Sí")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',48,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes"),'onclick':("closeModalWithMessage('myModalDrop','Deleting SLR...');")],-1)
printHtmlPart(12)
})
invokeTag('form','g',48,['controller':("slr"),'action':("delete"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('render','g',51,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(15)
expressionOut.print(slrInstance.title)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',65,['controller':("index"),'action':("menu")],3)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',67,['controller':("slr"),'action':("myList")],3)
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(slrBreadCrumb)
})
invokeTag('link','g',69,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],3)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',78,['title':("Research Questions"),'type':("button"),'class':("btn btn-primary"),'controller':("slr"),'action':("researchQuestions"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',79,['title':("Criterions"),'class':("btn btn-primary"),'controller':("slr"),'action':("criterions"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(22)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',80,['title':("Specific Attributes"),'class':("btn btn-primary"),'controller':("slr"),'action':("specAttributes"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(22)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',81,['title':("Searchs"),'type':("button"),'class':("btn btn-primary"),'controller':("slr"),'action':("searchs"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(26)
expressionOut.print(slrInstance.guid)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',85,['title':("Export Excel"),'type':("button"),'class':("btn btn-success"),'controller':("slr"),'action':("exportToExcel"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(22)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',86,['title':("Export Word"),'type':("button"),'class':("btn btn-success"),'controller':("slr"),'action':("exportToWord"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(22)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',87,['title':("Export Bibtex"),'type':("button"),'class':("btn btn-success"),'controller':("slr"),'action':("exportToBibTex"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(22)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',88,['title':("Graphs"),'type':("button"),'class':("btn btn-success"),'controller':("slr"),'action':("graphs"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(32)
expressionOut.print(slrInstance.title)
printHtmlPart(33)
createTagBody(3, {->
expressionOut.print(slrInstance.userProfile.display_name)
})
invokeTag('link','g',99,['controller':("user"),'action':("show"),'params':([guid: "${slrInstance.userProfile.guid}"])],3)
printHtmlPart(34)
if(true && (slrInstance.searchs.size() > 0)) {
printHtmlPart(35)
createTagBody(4, {->
expressionOut.print(slrInstance.searchs.size())
printHtmlPart(36)
})
invokeTag('link','g',101,['controller':("slr"),'action':("searchs"),'params':([guid: "${slrInstance.guid}"])],4)
printHtmlPart(22)
}
else {
printHtmlPart(35)
expressionOut.print(slrInstance.searchs.size())
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (slrInstance.totalReferences > 0)) {
printHtmlPart(35)
createTagBody(4, {->
expressionOut.print(slrInstance.totalReferences)
printHtmlPart(39)
})
invokeTag('link','g',109,['controller':("slr"),'action':("references"),'params':([guid: "${slrInstance.guid}"])],4)
printHtmlPart(22)
}
else {
printHtmlPart(35)
expressionOut.print(slrInstance.totalReferences)
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(slrInstance.justification)
printHtmlPart(42)
if(true && (slrInstance.questions.size() > 0)) {
printHtmlPart(43)
for( questionInstance in (slrInstance.questions) ) {
printHtmlPart(44)
expressionOut.print(questionInstance.enunciado)
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(47)
invokeTag('render','g',132,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(48)
})
invokeTag('form','g',133,[:],2)
printHtmlPart(49)
invokeTag('render','g',133,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(50)
invokeTag('render','g',133,['template':("graphsGoogleSlrView"),'contextPath':("/graphs")],-1)
printHtmlPart(51)
invokeTag('render','g',136,['template':("slrInfo"),'contextPath':("/slr")],-1)
printHtmlPart(52)
})
invokeTag('captureBody','sitemesh',136,[:],1)
printHtmlPart(53)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464438000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
