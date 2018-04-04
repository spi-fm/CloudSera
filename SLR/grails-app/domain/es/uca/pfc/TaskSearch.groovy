package es.uca.pfc

class TaskSearch {
	
	static hasMany = [references: String]
	
	int percentage = 0
	String state = "Buscando referencias..."
	Date submitDate = new Date()
	Date endDate = new Date()
	boolean hasErrors = false
	String titleSlr
	String guidSlr
	String guid
	String strException
	String username
	String details = "Inicio\n"

    static constraints = {
		strException(nullable: true)
    }
	
	// Indicamos que strException es un texto
	static mapping = {
		strException type: 'text'
		details type: 'text'
	}
}
