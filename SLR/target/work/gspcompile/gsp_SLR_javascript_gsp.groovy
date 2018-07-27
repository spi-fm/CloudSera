import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_javascript_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_javascript.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(resource(dir: 'bower_components', file: 'jquery/dist/jquery.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'bower_components', file: 'bootstrap/dist/js/bootstrap.min.js'))
printHtmlPart(2)
expressionOut.print(resource(dir: 'bower_components', file: 'metisMenu/dist/metisMenu.min.js'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'dist', file: 'js/sb-admin-2.js'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js', file: 'jquery.range.js'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'bower_components', file: 'raphael/raphael-min.js'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'bower_components', file: 'morrisjs/morris.min.js'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'js', file: 'jquery.blockUI.js'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'dist', file: 'js/bootstrap-tokenfield.js'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'dist', file: 'js/scrollspy.js'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'dist', file: 'js/affix.js'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'dist', file: 'js/typeahead.bundle.min.js'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'dist', file: 'js/docs.min.js'))
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1494160542000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
