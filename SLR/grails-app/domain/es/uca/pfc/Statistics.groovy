package es.uca.pfc

class Statistics {

	String code = '1'
	int totalSlrs = 0
	int totalUsers = 0

    static constraints = {
			code(size:0..255)
    }
}
