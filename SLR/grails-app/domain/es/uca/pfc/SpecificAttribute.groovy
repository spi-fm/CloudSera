package es.uca.pfc

class SpecificAttribute {

	static belongsTo = [slr:Slr]
	static hasMany = [attributesReferences: SpecificAttributeReference]

	String name = ""
	String tipo = "string" //list-string-number
	Date submitDate = new Date()
	Date modifyDate = new Date()

    static constraints = {
			name(size:0..255)
			tipo(size:0..255)
    }

	def beforeUpdate = {
		modifyDate = new Date()
	}
}
