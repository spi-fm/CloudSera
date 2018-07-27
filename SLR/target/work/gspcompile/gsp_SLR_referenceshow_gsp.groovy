import es.uca.pfc.User
import es.uca.pfc.Reference
import es.uca.pfc.TypeDocument
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SLR_referenceshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/reference/show.gsp" }
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
createTagBody(3, {->
printHtmlPart(4)
expressionOut.print(referenceInstance.title)
})
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
invokeTag('render','g',16,['template':("css"),'contextPath':("/")],-1)
printHtmlPart(6)
expressionOut.print(null != error && error != "")
printHtmlPart(7)
expressionOut.print(success)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',42,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('hiddenField','g',59,['name':("idmendReference"),'value':(referenceInstance.idmend)],-1)
printHtmlPart(12)
invokeTag('submitButton','g',65,['id':("boton"),'name':("boton"),'class':("btn btn-primary"),'value':("Sí"),'onclick':("closeModalWithMessage('myModalDrop','Eliminando...');")],-1)
printHtmlPart(13)
})
invokeTag('form','g',65,['controller':("reference"),'action':("delete"),'id':("myFormDelete"),'name':("myFormDelete"),'method':("DELETE")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',87,['type':("button"),'class':("btn btn-primary"),'controller':("reference"),'action':("sychronizeReferenceMend"),'onclick':("closeModalWithMessage('myModalSynchro','Synchronizing...');"),'params':([idmend: "${referenceInstance.idmend}"])],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('hiddenField','g',93,['name':("idmend"),'value':(referenceInstance.idmend)],-1)
printHtmlPart(18)
invokeTag('render','g',95,['template':("head"),'contextPath':("/")],-1)
printHtmlPart(19)
expressionOut.print(referenceInstance.title)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',105,['controller':("index"),'action':("menu")],3)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',108,['controller':("slr"),'action':("myList")],3)
printHtmlPart(22)
createTagBody(3, {->
expressionOut.print(slrBreadCrumb)
})
invokeTag('link','g',109,['controller':("slr"),'action':("show"),'params':([guidSlr: "${slrInstance.guid}"])],3)
printHtmlPart(22)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',110,['controller':("slr"),'action':("references"),'params':([guid: "${slrInstance.guid}"])],3)
printHtmlPart(25)
expressionOut.print(refBreadCrumb)
printHtmlPart(26)
if(true && (userOwnerInstance.id == User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).id)) {
printHtmlPart(27)
invokeTag('submitButton','g',115,['class':("btn btn-success"),'name':("create"),'value':("Save changes"),'onclick':("loading('Saving changes...');")],-1)
printHtmlPart(27)
if(true && (!noDrop)) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(27)
createClosureForHtmlPart(30, 4)
invokeTag('link','g',123,['type':("button"),'class':("btn btn-primary"),'controller':("reference"),'action':("exportReferenceToBibTex"),'params':([idmend: "${referenceInstance.idmend}"])],4)
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (userOwnerInstance.id == User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).id)) {
printHtmlPart(11)
invokeTag('set','g',130,['var':("isEditable"),'value':("")],-1)
printHtmlPart(11)
invokeTag('set','g',130,['var':("isEditableSelect"),'value':("")],-1)
printHtmlPart(33)
}
else {
printHtmlPart(11)
invokeTag('set','g',132,['var':("isEditable"),'value':("readonly=\'readonly\'")],-1)
printHtmlPart(11)
invokeTag('set','g',134,['var':("isEditableSelect"),'value':("disabled=\'disabled\'")],-1)
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (isEditable == "")) {
printHtmlPart(35)
expressionOut.print(error)
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(isEditableSelect)
printHtmlPart(38)
for( criterionInstance in (criterionListInstance) ) {
printHtmlPart(39)
if(true && (referenceInstance.criterion.name.equals(criterionInstance.name))) {
printHtmlPart(40)
expressionOut.print(criterionInstance.nomenclatura)
printHtmlPart(41)
expressionOut.print(criterionInstance.name)
printHtmlPart(42)
}
else {
printHtmlPart(40)
expressionOut.print(criterionInstance.nomenclatura)
printHtmlPart(43)
expressionOut.print(criterionInstance.name)
printHtmlPart(42)
}
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (referenceInstance.specificAttributes.size() != 0)) {
printHtmlPart(46)
invokeTag('set','g',168,['var':("cont"),'value':(0)],-1)
printHtmlPart(47)
for( attributeRefInstance in (referenceInstance.specificAttributes) ) {
printHtmlPart(48)
expressionOut.print(attributeRefInstance.attribute.id)
printHtmlPart(49)
expressionOut.print(attributeRefInstance.attribute.name)
printHtmlPart(50)
if(true && (attributeRefInstance.attribute.tipo == "list")) {
printHtmlPart(51)
expressionOut.print(attributeRefInstance.attribute.id)
printHtmlPart(52)
expressionOut.print(attributeRefInstance.attribute.id)
printHtmlPart(53)
expressionOut.print(isEditableSelect)
printHtmlPart(54)
for( optionInstance in (attributeRefInstance.attribute.options) ) {
printHtmlPart(55)
if(true && (optionInstance.equals(attributeRefInstance.value))) {
printHtmlPart(56)
expressionOut.print(optionInstance)
printHtmlPart(41)
expressionOut.print(optionInstance)
printHtmlPart(57)
}
else {
printHtmlPart(56)
expressionOut.print(optionInstance)
printHtmlPart(43)
expressionOut.print(optionInstance)
printHtmlPart(57)
}
printHtmlPart(58)
}
printHtmlPart(59)
}
else {
printHtmlPart(60)
expressionOut.print(attributeRefInstance.attribute.id)
printHtmlPart(52)
expressionOut.print(attributeRefInstance.attribute.id)
printHtmlPart(61)
expressionOut.print(attributeRefInstance.value)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(63)
}
printHtmlPart(64)
}
printHtmlPart(65)
if(true && (cont % 2 != 0)) {
printHtmlPart(66)
}
printHtmlPart(67)
}
printHtmlPart(68)
expressionOut.print(referenceInstance.title)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(69)
expressionOut.print(isEditableSelect)
printHtmlPart(38)
for( typeInstance in (typeListInstance) ) {
printHtmlPart(39)
if(true && (referenceInstance.type.nombre.equals(typeInstance.nombre))) {
printHtmlPart(40)
expressionOut.print(typeInstance.nomenclatura)
printHtmlPart(41)
expressionOut.print(typeInstance.nombre)
printHtmlPart(42)
}
else {
printHtmlPart(40)
expressionOut.print(typeInstance.nomenclatura)
printHtmlPart(43)
expressionOut.print(typeInstance.nombre)
printHtmlPart(42)
}
printHtmlPart(44)
}
printHtmlPart(70)
expressionOut.print(referenceInstance.publisher)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(71)
expressionOut.print(isEditableSelect)
printHtmlPart(72)
expressionOut.print(listAuthorsString)
printHtmlPart(73)
expressionOut.print(referenceInstance.year)
printHtmlPart(74)
expressionOut.print(isEditableSelect)
printHtmlPart(38)
for( languageInstance in (languageListInstance) ) {
printHtmlPart(39)
if(true && (referenceInstance.language.name.equals(languageInstance.name))) {
printHtmlPart(40)
expressionOut.print(languageInstance.code)
printHtmlPart(41)
expressionOut.print(languageInstance.name)
printHtmlPart(42)
}
else {
printHtmlPart(40)
expressionOut.print(languageInstance.code)
printHtmlPart(43)
expressionOut.print(languageInstance.name)
printHtmlPart(42)
}
printHtmlPart(44)
}
printHtmlPart(75)
expressionOut.print(isEditable)
printHtmlPart(72)
expressionOut.print(referenceInstance.docAbstract)
printHtmlPart(76)
expressionOut.print(referenceInstance.isbn)
printHtmlPart(77)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: referenceInstance.created))
printHtmlPart(78)
expressionOut.print(referenceInstance.source)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(79)
expressionOut.print(referenceInstance.pages)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(80)
expressionOut.print(referenceInstance.volume)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(81)
expressionOut.print(referenceInstance.issue)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(82)
expressionOut.print(referenceInstance.country)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(83)
expressionOut.print(isEditable)
printHtmlPart(72)
expressionOut.print(listKeywordsString)
printHtmlPart(84)
expressionOut.print(isEditable)
printHtmlPart(72)
expressionOut.print(listWebsString)
printHtmlPart(85)
expressionOut.print(referenceInstance.citation_key)
printHtmlPart(86)
expressionOut.print(formatDate(format: 'HH:mm - dd/MMM/yyyy', date: referenceInstance.last_modified))
printHtmlPart(87)
expressionOut.print(referenceInstance.city)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(88)
expressionOut.print(referenceInstance.institution)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(89)
expressionOut.print(referenceInstance.series)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(90)
expressionOut.print(referenceInstance.chapter)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(91)
expressionOut.print(referenceInstance.genre)
printHtmlPart(62)
expressionOut.print(isEditable)
printHtmlPart(92)
expressionOut.print(isEditableSelect)
printHtmlPart(72)
expressionOut.print(listTagsString)
printHtmlPart(93)
expressionOut.print(isEditableSelect)
printHtmlPart(72)
expressionOut.print(referenceInstance.notes)
printHtmlPart(94)
invokeTag('render','g',391,['template':("foot"),'contextPath':("/")],-1)
printHtmlPart(95)
})
invokeTag('form','g',397,['class':("form-horizontal"),'controller':("reference"),'action':("save"),'method':("POST"),'name':("myForm"),'id':("myForm")],2)
printHtmlPart(96)
invokeTag('render','g',400,['template':("javascript"),'contextPath':("/")],-1)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',400,['onload':("loadModal();")],1)
printHtmlPart(97)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1523464355000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
