package es.uca.pfc

class FAQ {

	String enunciado = ""
	String respuesta = ""
	Date submitDate = new Date()

    static constraints = {
			enunciado(size:0..255)
    }

	// Indicamos que la justificacion es un texto
	static mapping = {
		respuesta type: 'text'
		sort submitDate: 'asc'
	}
}
