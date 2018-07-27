package es.uca.pfc

class Education {

    static belongsTo = [profile: UserProfile]

	String degree;
	String institution;
	String website;
	Date start_date;
	Date end_date;

    static constraints = {
		degree(size:0..255, nullable: true)
		institution(size:0..255, nullable: true)
		website(size:0..255, nullable: true)
		start_date(nullable: true)
		end_date(nullable: true)
    }

	def beforeInsert = {
		applyEncode()
	}

	def beforeUpdate = {
		applyEncode()
	}

	void applyEncode()
	{
		degree = (degree == null ? '' : new String(degree.getBytes("ISO-8859-1"), "UTF-8"))
		institution = (institution == null ? '' : new String(institution.getBytes("ISO-8859-1"), "UTF-8"))
		website = (website == null ? '' : new String(website.getBytes("ISO-8859-1"), "UTF-8"))
	}

	static mapping = {
		degree type: 'text'
		institution type: 'text'
		website type: 'text'
	}
}
