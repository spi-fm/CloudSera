package es.uca.pfc

import java.util.Comparator;

class UserProfile implements Comparator<UserProfile> {

	static belongsTo = [user: User]
	static hasMany = [slrs:Slr, notifications: Notification, loggers: Logger, friends: UserProfile, educations: Education]

	String first_name = ""
	String last_name = ""
	String display_name = ""
	String url_foto = ""
	String guid = UUID.randomUUID().toString();
	String idmend = ""
	String research_interests = ""
	String academic_status = ""
	String link = ""
	String created = ""
	String biography = ""
	String codeBotonEnlace = ""
	String locationName = ""
	String locationLatitude = ""
	String locationLongitude = ""
	String discipline = ""

	Date ultimaConexion = new Date()
	Date fechaRegistro  = new Date()
	String timeString = ""

	String lastGuidTaskSearch = "";

	boolean isOnline = false

    static constraints = {
			academic_status(nullable: true)
			biography(nullable: true)
			codeBotonEnlace(nullable: true)
			created(size:0..255, nullable: true)
			discipline(size:0..255, nullable: true)
			display_name(size:0..255, nullable: true)
			first_name(size:0..255, nullable: true)
			guid(size:0..255)
			idmend(size:0..255, nullable: true)
			lastGuidTaskSearch(size:0..255)
			last_name(size:0..255, nullable: true)
			link(nullable: true)
			locationLatitude(nullable: true)
			locationLongitude(nullable: true)
			locationName(nullable: true)
			research_interests(nullable: true)
			timeString(size:0..255)
			url_foto(nullable: true)
    }

	//static mappedBy = [loggers: 'profile', friends: 'profile']
	//static mappedBy = [loggers: 'profile']

	def beforeInsert = {
		applyEncode()
		display_name = first_name + ' ' + last_name;

		//addToLoggers(new Logger(tipo: 'bienvenida'))
		loggers = [new Logger(tipo: 'bienvenida',profile: this)] // Para que pase el test de integracion
	}

	def beforeUpdate = {
		applyEncode()
		display_name = first_name + ' ' + last_name
	}

	void applyEncode()
	{
		/*first_name = (first_name == null ? '' : new String(first_name.getBytes("ISO-8859-1"), "UTF-8"))
		last_name = (last_name == null ? '' : new String(last_name.getBytes("ISO-8859-1"), "UTF-8"))
		research_interests = (research_interests == null ? '' : new String(research_interests.getBytes("ISO-8859-1"), "UTF-8"))
		academic_status = (academic_status == null ? '' : new String(academic_status.getBytes("ISO-8859-1"), "UTF-8"))
		biography = (biography == null ? '' : new String(biography.getBytes("ISO-8859-1"), "UTF-8"))
		locationName = (locationName == null ? '' : new String(locationName.getBytes("ISO-8859-1"), "UTF-8"))
		locationLatitude = (locationLatitude == null ? '' : new String(locationLatitude.getBytes("ISO-8859-1"), "UTF-8"))
		locationLongitude = (locationLongitude == null ? '' : new String(locationLongitude.getBytes("ISO-8859-1"), "UTF-8"))
		discipline = (discipline == null ? '' : new String(discipline.getBytes("ISO-8859-1"), "UTF-8"))*/
	}

	boolean equals(Object obj)
	{
		if (null == obj) { return false; }
		if(getClass() != obj.getClass()) { return false; }

		final UserProfile other = (UserProfile) obj;

		if (this.id != other.id) { return false; }

		if (!Objects.equals(this.guid, obj.guid)) { return false; }

		return true;
	}

	@Override
	public int compare(UserProfile up1, UserProfile up2) {
		return up1.display_name.compareTo(up2.display_name)
	}

	static mapping = {
		research_interests type: 'text'
		academic_status type: 'text'
		link type: 'text'
		biography type: 'text'
		codeBotonEnlace type: 'text'
		locationName type: 'text'
		locationLatitude type: 'text'
		locationLongitude type: 'text'
		discipline type: 'text'
	}
}
