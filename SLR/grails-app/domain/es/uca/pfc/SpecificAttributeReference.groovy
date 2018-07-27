package es.uca.pfc

class SpecificAttributeReference {

	SpecificAttribute attribute
	Reference reference
	String value = ""

	static belongsTo = [attribute: SpecificAttribute, reference: Reference]

    static constraints = {
			value(size:0..255)
    }
}
