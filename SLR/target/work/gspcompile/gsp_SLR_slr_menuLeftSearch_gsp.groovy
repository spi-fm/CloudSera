import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slr_menuLeftSearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/_menuLeftSearch.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',16,['var':("guidSlr"),'value':(guidSlr)],-1)
printHtmlPart(1)
if(true && (criterionsListInstance.size() > 0)) {
printHtmlPart(2)
for( criterion in (criterionsListInstance) ) {
printHtmlPart(3)
expressionOut.print(criterion)
printHtmlPart(4)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "criterion="+criterion]))
printHtmlPart(5)
expressionOut.print(criterion)
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (specificAttributesMapInstance.size() > 0)) {
printHtmlPart(9)
for( specificAttribute in (specificAttributesMapInstance) ) {
printHtmlPart(10)
expressionOut.print(specificAttribute.key.replaceAll(" ",""))
printHtmlPart(11)
expressionOut.print(specificAttribute.key.replaceAll(" ",""))
printHtmlPart(12)
expressionOut.print(specificAttribute.key.replaceAll(" ",""))
printHtmlPart(13)
expressionOut.print(specificAttribute.key.replaceAll(" ",""))
printHtmlPart(14)
expressionOut.print(specificAttribute.key)
printHtmlPart(15)
expressionOut.print(specificAttribute.key)
printHtmlPart(16)
expressionOut.print(specificAttribute.key.replaceAll(" ",""))
printHtmlPart(17)
for( valueAttribute in (specificAttribute.value) ) {
printHtmlPart(18)
expressionOut.print(valueAttribute)
printHtmlPart(19)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "@as@" + specificAttribute.key + "="+valueAttribute]))
printHtmlPart(20)
expressionOut.print(valueAttribute)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(8)
if(true && (enginesListInstance.size() > 0)) {
printHtmlPart(24)
for( engine in (enginesListInstance) ) {
printHtmlPart(25)
expressionOut.print(engine)
printHtmlPart(26)
expressionOut.print(engine)
printHtmlPart(27)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "engine="+engine]))
printHtmlPart(28)
expressionOut.print(engine)
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (languagesListInstance.size() > 0)) {
printHtmlPart(29)
for( language in (languagesListInstance) ) {
printHtmlPart(3)
expressionOut.print(language)
printHtmlPart(4)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "language="+language]))
printHtmlPart(30)
expressionOut.print(language)
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (departmentsListInstance.size() > 0)) {
printHtmlPart(31)
for( department in (departmentsListInstance) ) {
printHtmlPart(3)
expressionOut.print(department)
printHtmlPart(32)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "department="+department]))
printHtmlPart(33)
expressionOut.print(department)
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (typesListInstance.size() > 0)) {
printHtmlPart(34)
for( type in (typesListInstance) ) {
printHtmlPart(3)
expressionOut.print(type)
printHtmlPart(4)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "type="+type]))
printHtmlPart(33)
expressionOut.print(type)
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (authorsListInstance.size() > 0)) {
printHtmlPart(35)
for( author in (authorsListInstance) ) {
printHtmlPart(3)
expressionOut.print(author)
printHtmlPart(4)
expressionOut.print(remoteFunction(controller:'slr', action:'filtredReferencesByParam', update:'searchresults',params:[guidSlr: guidSlr, filter: "author="+author]))
printHtmlPart(33)
expressionOut.print(author)
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1501230810000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
