package es.uca.pfc

class TypeDocument {

	static hasMany = [references: Reference]

	String nombre
	String nomenclatura

    static constraints = {
			nombre(size:0..255)
			nomenclatura(size:0..255)
    }
}
