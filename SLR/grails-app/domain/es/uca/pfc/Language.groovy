package es.uca.pfc

class Language {

	String name = ""
	String country = ""
	String code = ""
	String image = ""

    static constraints = {
			code(size:0..255)
			country(size:0..255)
			image(size:0..255)
			name(size:0..255)
    }
}
