import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_pagination_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_pagination.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (totalPages <= 3)) {
printHtmlPart(1)
for( p in ((1..<(totalPages+1))) ) {
printHtmlPart(2)
if(true && (p == page)) {
printHtmlPart(3)
expressionOut.print(p)
printHtmlPart(4)
}
else {
printHtmlPart(5)
createTagBody(4, {->
expressionOut.print(p)
})
invokeTag('remoteLink','g',9,['controller':("slr"),'action':("filtredReferencesByParam"),'update':("searchresults"),'params':([guidSlr: "${guidSlr}", p: "${p}"])],4)
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(8)
}
else {
printHtmlPart(9)
if(true && (page == 1)) {
printHtmlPart(10)
}
else {
printHtmlPart(11)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: 1]))
printHtmlPart(12)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page-1]))
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (page == 1)) {
printHtmlPart(15)
expressionOut.print(page)
printHtmlPart(16)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page+1]))
printHtmlPart(17)
expressionOut.print(page+1)
printHtmlPart(16)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page+2]))
printHtmlPart(17)
expressionOut.print(page+2)
printHtmlPart(18)
}
else if(true && ((page+1) == totalPages)) {
printHtmlPart(11)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page-1]))
printHtmlPart(17)
expressionOut.print(page-1)
printHtmlPart(19)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page]))
printHtmlPart(17)
expressionOut.print(page)
printHtmlPart(16)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page+1]))
printHtmlPart(17)
expressionOut.print(page+1)
printHtmlPart(18)
}
else if(true && (page == totalPages)) {
printHtmlPart(11)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page-2]))
printHtmlPart(17)
expressionOut.print(page-2)
printHtmlPart(16)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page-1]))
printHtmlPart(17)
expressionOut.print(page-1)
printHtmlPart(20)
expressionOut.print(page)
printHtmlPart(18)
}
else {
printHtmlPart(2)
for( p in (((page-1)..<(page+2))) ) {
printHtmlPart(21)
if(true && (p == page)) {
printHtmlPart(22)
expressionOut.print(p)
printHtmlPart(23)
}
else {
printHtmlPart(24)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: p]))
printHtmlPart(17)
expressionOut.print(p)
printHtmlPart(23)
}
printHtmlPart(2)
}
printHtmlPart(1)
}
printHtmlPart(25)
if(true && (page == totalPages)) {
printHtmlPart(26)
}
else {
printHtmlPart(11)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: page+1]))
printHtmlPart(27)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, page: totalPages]))
printHtmlPart(28)
}
printHtmlPart(29)
}
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500907754000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
