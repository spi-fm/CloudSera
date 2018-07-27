import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_slr_referencesSearchResult_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/slr/_referencesSearchResult.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (!strSearch.equals(""))) {
printHtmlPart(1)
expressionOut.print(strSearch)
printHtmlPart(2)
}
printHtmlPart(3)
invokeTag('render','g',14,['template':("pagination"),'contextPath':("/")],-1)
printHtmlPart(4)
expressionOut.print(referenceListCount)
printHtmlPart(5)
if(true && (referenceListCount == 0 && strSearch.equals(""))) {
printHtmlPart(6)
}
else if(true && (referenceListCount == 0 && !strSearch.equals(""))) {
printHtmlPart(7)
}
else {
printHtmlPart(8)
loop:{
int i = 0
for( referenceInstance in (referenceListInstance) ) {
printHtmlPart(9)
expressionOut.print(resource(dir: 'images/flags', file: referenceInstance.language.image))
printHtmlPart(10)
expressionOut.print(resource(dir: 'images/logos_engines', file: referenceInstance.engine.image))
printHtmlPart(11)
expressionOut.print(referenceInstance.engine.name)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
expressionOut.print(referenceInstance.title)
printHtmlPart(14)
})
invokeTag('link','g',44,['controller':("reference"),'action':("show"),'params':([idmend: "${referenceInstance.idmend}"])],3)
printHtmlPart(15)
expressionOut.print(referenceInstance.citation_key)
printHtmlPart(16)
expressionOut.print(referenceInstance.type.nombre)
printHtmlPart(17)
invokeTag('set','g',52,['var':("displayAllAuthors"),'value':("")],-1)
printHtmlPart(18)
loop:{
int ar = 0
for( authorReference in (referenceInstance.authors) ) {
printHtmlPart(19)
if(true && (ar == 0 || ar == (referenceInstance.authors.size()))) {
printHtmlPart(20)
expressionOut.print(authorReference)
printHtmlPart(19)
}
else {
printHtmlPart(20)
expressionOut.print(", " + authorReference)
printHtmlPart(19)
}
printHtmlPart(18)
ar++
}
}
printHtmlPart(21)
expressionOut.print(referenceInstance.month + ", " + referenceInstance.year)
printHtmlPart(22)
expressionOut.print(referenceInstance.publisher != null && referenceInstance.publisher != '' ? referenceInstance.publisher : '')
printHtmlPart(23)
expressionOut.print(referenceInstance.volume != null && referenceInstance.volume != '' ? 'Volume ' + referenceInstance.volume : '')
printHtmlPart(24)
expressionOut.print(referenceInstance.pages != null && referenceInstance.pages != '' ? 'Páginas ' + referenceInstance.pages : '')
printHtmlPart(25)
expressionOut.print(referenceInstance.department != null && referenceInstance.department != '' ? referenceInstance.department : '')
printHtmlPart(26)
expressionOut.print((referenceInstance.city != null && referenceInstance.city != '' ? referenceInstance.city : '') + (referenceInstance.country != null && referenceInstance.country != '' ? ', '+referenceInstance.country : ''))
printHtmlPart(18)
if(true && (referenceInstance.keywords.size() > 0)) {
printHtmlPart(27)
expressionOut.print(referenceInstance.keywords.toString())
printHtmlPart(28)
}
printHtmlPart(29)
if(true && (referenceInstance.docAbstract != null && !referenceInstance.docAbstract.equals(''))) {
printHtmlPart(30)
loop:{
int w = 0
for( word in (referenceInstance.docAbstract.split(" ")) ) {
printHtmlPart(20)
if(true && (w < 30)) {
printHtmlPart(31)
expressionOut.print(word + " ")
printHtmlPart(20)
}
printHtmlPart(19)
w++
}
}
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(i+offset+1)
printHtmlPart(34)
expressionOut.print(referenceListCount)
printHtmlPart(35)
i++
}
}
printHtmlPart(36)
}
printHtmlPart(37)
invokeTag('render','g',98,['template':("pagination"),'contextPath':("/")],-1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1498921472000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
