import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_index_taskSearchList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/_taskSearchList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',6,['controller':("index"),'action':("menu")],1)
printHtmlPart(2)
for( taskSearch in (taskSearchList) ) {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(taskSearch.titleSlr)
})
invokeTag('link','g',16,['controller':("slr"),'action':("searchs"),'params':([guid: "${taskSearch.guidSlr}"])],2)
printHtmlPart(4)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: taskSearch.submitDate))
printHtmlPart(5)
if(true && (taskSearch.percentage == 100)) {
printHtmlPart(6)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm', date: taskSearch.endDate))
printHtmlPart(7)
}
else if(true && (taskSearch.hasErrors)) {
printHtmlPart(8)
expressionOut.print('#'+ taskSearch.id)
printHtmlPart(7)
}
printHtmlPart(9)
expressionOut.print(taskSearch.state)
printHtmlPart(10)
invokeTag('set','g',28,['var':("cssBar"),'value':("progress-bar progress-bar-striped progress-bar-primary")],-1)
printHtmlPart(11)
if(true && (taskSearch.percentage == 0 && taskSearch.hasErrors)) {
printHtmlPart(12)
invokeTag('set','g',30,['var':("cssBar"),'value':("progress-bar progress-bar-danger")],-1)
printHtmlPart(11)
}
else if(true && (taskSearch.percentage != 100)) {
printHtmlPart(12)
invokeTag('set','g',33,['var':("cssBar"),'value':("progress-bar progress-bar-striped progress-bar-primary active")],-1)
printHtmlPart(11)
}
printHtmlPart(13)
if(true && (taskSearch.hasErrors)) {
printHtmlPart(14)
expressionOut.print(cssBar)
printHtmlPart(15)
expressionOut.print(taskSearch.percentage)
printHtmlPart(16)
}
else {
printHtmlPart(17)
expressionOut.print(cssBar)
printHtmlPart(18)
expressionOut.print(taskSearch.percentage)
printHtmlPart(19)
expressionOut.print(taskSearch.percentage)
printHtmlPart(20)
expressionOut.print(taskSearch.percentage)
printHtmlPart(21)
expressionOut.print(taskSearch.percentage)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (taskSearch.percentage == 100 || (taskSearch.percentage == 0 && taskSearch.hasErrors))) {
printHtmlPart(11)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',53,['class':("btn btn-default"),'type':("submit"),'controller':("taskSearch"),'action':("details"),'params':([guid: "${taskSearch.guid}"])],3)
printHtmlPart(7)
}
printHtmlPart(25)
}
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1499592996000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
