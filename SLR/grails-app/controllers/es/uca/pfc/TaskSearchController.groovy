package es.uca.pfc

class TaskSearchController {

	def springSecurityService
	def toolService
    
	def index() { 
		redirect(controller: 'index', action: 'index')
	}
	
	def details()
	{
		def guidTask = params.guid.toString()
		def taskSearchInstance = TaskSearch.findByGuidLike(guidTask)
		
		if(taskSearchInstance != null)
		{
			[taskSearchInstance: taskSearchInstance]
		}
		else
		{
			redirect(controller: 'index', action: 'index')
		}
	}
	
	def loadDetailsTaskSearch()
	{
		def isLogin = springSecurityService.isLoggedIn()
		
		if (isLogin)
		{
			def userInstance = User.get(springSecurityService.principal.id)
			def guidTaskSearch = params.guid == null ? "" : params.guid.toString()
			def taskSearchInstance = toolService.getTaskSearchByGuid(guidTaskSearch, userInstance)
			Map model = [taskSearchInstance: taskSearchInstance]
			render(template: 'taskSearchDetails', model: model)
		}
		else
		{
			redirect(controller: 'index', action: 'index')
		}
	}
}
