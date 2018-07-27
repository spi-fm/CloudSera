import es.uca.pfc.User
import es.uca.pfc.Search
import es.uca.pfc.Slr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_searchcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('render','g',10,['template':("headMeta"),'contextPath':("/")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
invokeTag('render','g',16,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
expressionOut.print(null != error && error != "")
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',59,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('render','g',70,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(10)
expressionOut.print(slrInstance.title)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',77,['controller':("index"),'action':("menu")],2)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',78,['controller':("slr"),'action':("myList")],2)
printHtmlPart(13)
createTagBody(2, {->
expressionOut.print(slrBreadCrumb)
})
invokeTag('link','g',79,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],2)
printHtmlPart(13)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',80,['controller':("slr"),'action':("searchs"),'params':([guid: "${slrInstance.guid}"])],2)
printHtmlPart(16)
expressionOut.print(error)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('hiddenField','g',93,['name':("guidSlr"),'value':(slrInstance.guid)],-1)
printHtmlPart(19)
invokeTag('set','g',99,['var':("listEngines"),'value':("")],-1)
printHtmlPart(20)
expressionOut.print(resource(dir:'images/logos_engines', file: 'all.png'))
printHtmlPart(21)
for( engineInstance in (engineListInstance) ) {
printHtmlPart(22)
if(true && (engineInstance.name.toLowerCase().equals("acm") && opACMSearch.toString().equals('true'))) {
printHtmlPart(23)
expressionOut.print(engineInstance.name)
printHtmlPart(24)
expressionOut.print(engineInstance.name)
printHtmlPart(25)
expressionOut.print(engineInstance.name)
printHtmlPart(26)
expressionOut.print(resource(dir:'images/logos_engines', file: engineInstance.image))
printHtmlPart(27)
}
else if(true && (engineInstance.name.toLowerCase().equals("ieee") && opIEEESearch.toString().equals('true'))) {
printHtmlPart(23)
expressionOut.print(engineInstance.name)
printHtmlPart(24)
expressionOut.print(engineInstance.name)
printHtmlPart(25)
expressionOut.print(engineInstance.name)
printHtmlPart(26)
expressionOut.print(resource(dir:'images/logos_engines', file: engineInstance.image))
printHtmlPart(27)
}
else if(true && (engineInstance.name.toLowerCase().equals("science") && opSCIENCESearch.toString().equals('true'))) {
printHtmlPart(23)
expressionOut.print(engineInstance.name)
printHtmlPart(24)
expressionOut.print(engineInstance.name)
printHtmlPart(25)
expressionOut.print(engineInstance.name)
printHtmlPart(26)
expressionOut.print(resource(dir:'images/logos_engines', file: engineInstance.image))
printHtmlPart(27)
}
else if(true && (engineInstance.name.toLowerCase().equals("springer") && opSPRINGERSearch.toString().equals('true'))) {
printHtmlPart(23)
expressionOut.print(engineInstance.name)
printHtmlPart(24)
expressionOut.print(engineInstance.name)
printHtmlPart(25)
expressionOut.print(engineInstance.name)
printHtmlPart(26)
expressionOut.print(resource(dir:'images/logos_engines', file: engineInstance.image))
printHtmlPart(27)
}
else {
printHtmlPart(23)
expressionOut.print(engineInstance.name)
printHtmlPart(24)
expressionOut.print(engineInstance.name)
printHtmlPart(25)
expressionOut.print(engineInstance.name)
printHtmlPart(26)
expressionOut.print(resource(dir:'images/logos_engines', file: engineInstance.image))
printHtmlPart(27)
}
printHtmlPart(28)

listEngines += 'engine' + engineInstance.name + ';'

printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(minYearSearch)
printHtmlPart(31)
expressionOut.print(maxYearSearch)
printHtmlPart(32)
for( componentInstance in (componentListInstance) ) {
printHtmlPart(33)
expressionOut.print(componentInstance.value)
printHtmlPart(34)
expressionOut.print(componentInstance.name)
printHtmlPart(35)
}
printHtmlPart(36)
for( operatorInstance in (operatorListInstance) ) {
printHtmlPart(33)
expressionOut.print(operatorInstance.value)
printHtmlPart(34)
expressionOut.print(operatorInstance.name)
printHtmlPart(35)
}
printHtmlPart(37)
invokeTag('submitButton','g',179,['id':("boton"),'name':("boton"),'class':("btn btn-success"),'value':("Create Search")],-1)
printHtmlPart(38)
})
invokeTag('form','g',180,['class':("form-horizontal"),'controller':("search"),'action':("save"),'method':("POST"),'name':("myForm"),'id':("myForm")],2)
printHtmlPart(39)
invokeTag('render','g',183,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(40)
invokeTag('render','g',191,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(41)
expressionOut.print(minYear)
printHtmlPart(42)
expressionOut.print(maxYear)
printHtmlPart(43)
expressionOut.print(minYear)
printHtmlPart(31)
expressionOut.print(maxYear)
printHtmlPart(44)
expressionOut.print(strOptionsComponents.encodeAsJavaScript())
printHtmlPart(45)
expressionOut.print(strOptionsOperators.encodeAsJavaScript())
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',227,['onload':("loadError();")],1)
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464399000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
