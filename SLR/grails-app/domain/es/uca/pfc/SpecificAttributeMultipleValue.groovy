package es.uca.pfc

class SpecificAttributeMultipleValue extends SpecificAttribute {
	
	static hasMany = [options: String]
	
	String optionDefault = ""
		
    static constraints = {
    }
	
	static mapping = {
		sort options : "asc"
	}
	
	def beforeInsert = {
		tipo = "list"
	}
	
	String getStrOptions()
	{
		return options.toString();
	}
}
