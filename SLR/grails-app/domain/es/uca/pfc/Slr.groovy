package es.uca.pfc
import groovy.sql.Sql

class Slr {

	static belongsTo = [userProfile: UserProfile]
	static hasMany = [userProfile: UserProfile, searchs: Search, criterions: Criterion, questions: ResearchQuestion,
					  				specAttributes: SpecificAttribute, taskSearchs: TaskSearch]

	String title
	String justification
	String state = 'fase1'
	boolean noDrop = false
	int numVisits = 0
	Date submitDate = new Date()	// fecha creacion
	Date lastModified = new Date()	// fecha modificacion
	String timeString = ""
	String guid = UUID.randomUUID().toString();
	String idmend = "" 				//id de folder en mendeley
	int totalReferences = 0
	int visibility_id = 0
	String objectives
	String threats_to_validity
	String conclusions
	//String formatTitle

	static constraints = {
		guid(size:0..255)
		idmend(size:0..255)
		state(size:0..5, inList:['fase1','fase2','fase3'], display: false, blank: false)
		noDrop(display: false)
		numVisits(display: false)
		submitDate(display: false)
		timeString(size:0..255)
		title(size:0..255)
		userProfile(nullable: true)
	}

	// Sobrecarga m�todo toString()
	String toString()
	{
		return "${title}";
	}

	// Indicamos que la justificacion es un texto
	static mapping = {
		justification type: 'text'
		searchs lazy: false
	}

	def beforeUpdate = {
		// Actualizamos la fecha de modificacion
		lastModified = new Date()
	}

	def beforeInsert = {
		// Creamos un criterio "Included"
		addToCriterions(new Criterion(name: "included", description: "Referencia incluida en el estudio.", nomenclatura: "cr_included"))
	}

	def afterInsert = {
		// Insertamos un logger al usuario
		userProfile.addToLoggers(new LoggerSlr(slr: this, tipo: 'crear')).save(failOnError: true)
	}
}
