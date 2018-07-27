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
			guid(size:0..255)
			guidSlr(size:0..255)
			state(size:0..255)
			strException(nullable: true)
			titleSlr(size:0..255)
			username(size:0..255)
    }

	// Indicamos que strException es un texto
	static mapping = {
		strException type: 'text'
		details type: 'text'
	}
}
