package es.uca.pfc

class SearchTermParam {

	static belongsTo = [component: SearchComponent, operator: SearchOperator, search: Search]

	String terminos = ""

    static constraints = {
			terminos(size:0..512)
    }
}
