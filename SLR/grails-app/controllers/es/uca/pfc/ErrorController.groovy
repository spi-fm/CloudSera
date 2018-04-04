package es.uca.pfc

class ErrorController {

    //def index() { }
	
	def error404()
	{
		render(view: '/error/error404')
	}
	
	def error500()
	{
		render(view: '/error/error500')
	}
	
	def error503()
	{
		render(view: '/error/error503')
	}
}
