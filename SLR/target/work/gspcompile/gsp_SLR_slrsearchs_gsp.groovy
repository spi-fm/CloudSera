import es.uca.pfc.User
import es.uca.pfc.Slr
import es.uca.pfc.Search
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slrsearchs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/searchs.gsp" }
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
expressionOut.print(isCreating)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('hiddenField','g',48,['name':("guidSearch"),'value':("0")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',56,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Yes")],-1)
printHtmlPart(12)
})
invokeTag('form','g',56,['controller':("search"),'action':("delete"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(13)
invokeTag('render','g',59,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(14)
expressionOut.print(slrInstance.title)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',72,['controller':("index"),'action':("menu")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',74,['controller':("slr"),'action':("myList")],2)
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(slrBreadCrumb)
})
invokeTag('link','g',76,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],2)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',87,['controller':("index"),'action':("taskSearchs")],2)
printHtmlPart(21)
createClosureForHtmlPart(22, 2)
invokeTag('link','g',91,['controller':("search"),'action':("create"),'class':("btn btn-success"),'params':([guidSlr:"${slrInstance.guid}"])],2)
printHtmlPart(23)
for( searchInstance in (searchListInstance) ) {
printHtmlPart(24)
expressionOut.print(formatDate(format: 'dd/MMM/yyyy HH:mm:ss', date: searchInstance.fecha))
printHtmlPart(25)
expressionOut.print(searchInstance.startYear)
printHtmlPart(25)
expressionOut.print(searchInstance.endYear)
printHtmlPart(25)
expressionOut.print(searchInstance.maxTotal)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(searchInstance.references.size())
printHtmlPart(26)
})
invokeTag('link','g',113,['controller':("slr"),'action':("references"),'params':([guid: "${searchInstance.slr.guid}"])],3)
printHtmlPart(27)
for( engine in (searchInstance.engines) ) {
printHtmlPart(28)
expressionOut.print(engine.name)
printHtmlPart(29)
}
printHtmlPart(30)
for( searchTermParam in (searchInstance.termParams) ) {
printHtmlPart(31)
expressionOut.print(searchTermParam.operator.name)
printHtmlPart(32)
expressionOut.print(searchTermParam.terminos)
printHtmlPart(33)
expressionOut.print(searchTermParam.component.name)
printHtmlPart(34)
}
printHtmlPart(35)
if(true && (slrInstance.noDrop == false)) {
printHtmlPart(36)
expressionOut.print(searchInstance.guid)
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
}
printHtmlPart(40)
invokeTag('render','g',143,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(41)
invokeTag('render','g',148,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(42)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables/media/js/jquery.dataTables.min.js'))
printHtmlPart(43)
expressionOut.print(resource(dir: 'bower_components', file: 'datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js'))
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',160,['onload':("showMessages();")],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464434000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
