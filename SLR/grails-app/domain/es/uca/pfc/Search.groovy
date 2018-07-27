package es.uca.pfc

class Search {

	static belongsTo = [slr: Slr]
	static hasMany = [references: Reference, engines: EngineSearch, termParams: SearchTermParam]

	Date fecha = new Date()
	String startYear = ""
	String endYear = ""
	int maxTotal = 5
	String guid = UUID.randomUUID().toString();

    static constraints = {
			endYear(size:0..255)
			guid(size:0..255)
			startYear(size:0..255)
    }

	String toString()
	{
		return "${terminos}"
	}
}
