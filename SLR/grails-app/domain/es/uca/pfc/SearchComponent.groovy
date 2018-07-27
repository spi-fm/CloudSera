package es.uca.pfc

class SearchComponent {

	String name = ""
	String value = ""

    static constraints = {
			name(size:0..255)
			value(size:0..255)
    }

	String toString()
	{
		return "${name}"
	}
}
