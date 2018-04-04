package es.uca.pfc

class ErrorTaskSearchController {

	def springSecurityService
	
    def index() {
		def isLogin = springSecurityService.loggedIn
		
		if(isLogin)
		{
			def userInstance = User.get(springSecurityService.principal.id)
			
			if(userInstance.authorities.any { it.authority != "ROLE_USER" })
			{
				[errors: ErrorTaskSearch.list(sort: 'createdDate', order: 'desc')]
			}
			else
			{
				redirect(controller: "index", action: "index")
			}
		}
		else
		{
			redirect(controller: "index", action: "index")
		}
	}
}
