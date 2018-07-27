import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_css_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_css.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(resource(dir: 'bower_components', file: 'bootstrap/dist/css/bootstrap.min.css'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'bower_components', file: 'metisMenu/dist/metisMenu.min.css'))
printHtmlPart(2)
expressionOut.print(resource(dir: 'dist', file: 'css/sb-admin-2.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'bower_components', file: 'font-awesome/css/font-awesome.min.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css', file: 'jquery.range.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'bower_components', file: 'morrisjs/morris.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'dist', file: 'css/tokenfield-typeahead.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'dist', file: 'css/bootstrap-tokenfield.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'dist', file: 'css/pygments-manni.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'dist', file: 'css/docs.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'dist', file: 'css/bootstrap-nav-wizard.min.css'))
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500390846000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
