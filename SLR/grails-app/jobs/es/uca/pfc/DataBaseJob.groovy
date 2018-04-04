package es.uca.pfc

class DataBaseJob {
    static triggers = {
      //simple repeatInterval: 5000l // execute job once in 5 seconds
	  simple repeatInterval: 1000 * 60 * 60 * 3 // execute job once in 3 hours
    }

    def execute() {
		
        def userListInstance = User.list()
		def slrListInstance = Slr.list()
		
		Statistics statistics = Statistics.findByCodeLike('1')
		
		if(statistics == null)
		{
			statistics = new Statistics(totalSlrs: slrListInstance.size(), totalUsers: userListInstance.size(), code: '1')
		}
		else
		{
			statistics.totalSlrs = slrListInstance.size()
			statistics.totalUsers = userListInstance.size()
		}
		
		statistics.save(failOnError: true, flush: true)
		
		log.info "Actualizando conexion BD => Hay " + userListInstance.size() + " usuarios y " + slrListInstance.size() + " revisiones sistematicas."
    }
}
