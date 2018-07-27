package es.uca.pfc

class Logger {

    static belongsTo = [profile: UserProfile]

	String tipo = 'bienvenida'
	Date submitDate = new Date()
	String timeString = ''
	//UserProfile userProfile

    static constraints = {
  		tipo(size:0..13, inList:['bienvenida','crear','buscar','seguir','fr-bienvenida','fr-crear','fr-buscar','fr-seguir'],display:false,blank:false)
  		profile(nullable: true)
      timeString(size:0..255)
    }

	@Override
	public boolean equals(Object obj)
	{
		if (null == obj) { return false; }
		if(getClass() != obj.getClass()) { return false; }

		final Logger other = (Logger) obj;

		if (this.id != other.id) { return false; }

		return true;
	}
}
