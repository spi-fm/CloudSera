package es.uca.pfc

class RegisterController {

	def springSecurityService
	def mendeleyToolService
	def toolService
	
    def index() { 
		
		if(springSecurityService.isLoggedIn())
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			def emailMend = (params.emailMend == null ? "" : params.emailMend.toString())
		
			[emailMend: emailMend]
		}
	}
		
	def registerUser() {
		
		def emailMend    = (params.j_email_mend == null ? "" : params.j_email_mend.toString())
		def passMend     = (params.j_pass_mend == null ? "" : params.j_pass_mend.toString())
		def passMendRep  = (params.j_pass_mend_rep == null ? "" : params.j_pass_mend_rep.toString())
		
		log.info 'El usuario ' + emailMend + ' procede a realizar el registro'
		
		def error = ""
		
		def userRepeatInstance = User.findByUsernameLike(emailMend)
		
		if (emailMend.equals("") || passMend.equals("") || passMendRep.equals("")) {
			error = "Error: There are empty fields"
		}
		else if(!toolService.isValidEmail(emailMend)) {
			error = "Error: Email no valid."
		}
		else if(!passMend.equals(passMendRep)) {
			error = "Error: The passwords aren't the same."
		}
		else if (userRepeatInstance != null) {
			error = "User registered in the application."
		}
		
		if(error.equals(""))
		{
			if(!mendeleyToolService.isRegisteredMendeley(emailMend, passMend))
			{
				error = "Error: Incorrect login in Mendeley. Verify yours credentials or try again later."
			}
		}
		
		if(error.equals("")) {
			User userInstance = mendeleyToolService.getUserFromMendeley(emailMend, passMend)
			
			if(userInstance == null)
			{
				log.info "El usuario no existe en Mendeley => userInstance == null"
				flash.message = "Error: The user doesn't exist in Mendeley."
				redirect(controller: 'register', action: 'index', params: [emailMend: emailMend])
			}
			else if (!userInstance.validate())
			{
				log.info "El usuario no es válido => !userInstance.validate()"
				flash.message = "Error: User isn't correct."
				redirect(controller: 'register', action: 'index', params: [emailMend: emailMend])
			}
			else
			{
				userInstance.save flush: true
				
				// Creamos role
				def userRole = Role.findByAuthority('ROLE_USER')				
				if(userRole == null)
				{
					log.info "ROLE_USER debe ser creado"
					userRole = new Role(authority: 'ROLE_USER').save(failOnError: true)
				}
				
				if (!userInstance.authorities.contains(userRole)) {
					// Excepcion de servidor cuando la BBDD supera
					// el wait_timeout
					try
					{
						log.info "Insertando ROL_USER al usuario"
						UserRole.create userInstance, userRole
					}
					catch(Exception ex) {
						log.info "Excepcion en la creación de role, se crea de nuevo"
						UserRole.create userInstance, userRole
					}
				}
				
				userInstance.save(failOnError: true, flush: true)
				
				log.info "Usuario registrado: " + userInstance.username +  " => " + userInstance.authorities
				
				// Hacemos Login automaticamente
				springSecurityService.reauthenticate(userInstance.username, userInstance.password)
				redirect(controller: 'index', action: 'index')
				
				return
			}
		}
		else
		{
			log.info "Validacion incorrecta en el registro de usuarios => " + (emailMend != null ? emailMend : '')
			flash.message = error
			redirect(controller: 'register', action: 'index', params: [emailMend: emailMend])
		}
	}
}
