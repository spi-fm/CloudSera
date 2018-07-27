package es.uca.pfc

class EngineSearch {

	String name = ""			//nombre
	String display_name = ""
	String url = ""				//url
	String image = ""			//imagen a mostrar
	String text = ""			//texto a mostrar
	boolean checkDefault  = false	//activado por defecto o no
	boolean status = true		//indica si se puede realizar busquedas o no
	String apiKey = ""

    static constraints = {
			apiKey(size:0..255, blank:true, nullable: true)
			display_name(size:0..255)
			image(size:0..255)
			name(size:0..255)
			text(size:0..255)
			url(size:0..255)
    }
}
