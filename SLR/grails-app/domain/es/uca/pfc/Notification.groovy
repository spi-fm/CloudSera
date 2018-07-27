package es.uca.pfc

class Notification {

    static belongsTo = [profile: UserProfile]

	Date fecha = new Date()
	String fechaString = ""
	String asunto = ""
	String texto = ""
	String tipo = "slr" // slr-friend-search
	boolean leido = false
	String guid = UUID.randomUUID().toString();

    static constraints = {
      asunto(size:0..255)
      fechaString(size:0..255)
      guid(size:0..255)
      tipo(size:0..255)
    }

	static mapping = {
		texto type: 'text'
	}

	def beforeInsert = {
		fechaString = getTimeString(fecha)
	}

	String getTimeString(Date date)
	{
		String timeToString = "";

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal1.setTime(date);
		cal2.setTime(new Date());

		def milis1 = cal1.getTimeInMillis();
		def milis2 = cal2.getTimeInMillis();

		def diff = milis2 - milis1;

		// Calculamos la diferencia en segundos
		def diffSeconds = diff / 1000;
		if(diffSeconds < 60)
		{
			timeToString = Math.round(diffSeconds) + " seconds ago";
		}
		else
		{
			def diffMinutes = diff / (60 * 1000);
			if(diffMinutes < 60)
			{
				timeToString = Math.round(diffMinutes) + " minutes ago.";
			}
			else
			{
				def diffHours = diff / (60 * 60 * 1000);
				if(diffHours < 24)
				{
					timeToString = Math.round(diffHours) + " hours ago.";
				}
				else
				{
					def diffDays = diff / (24 * 60 * 60 * 1000);
					if(diffDays < 30)
					{
						timeToString = Math.round(diffDays) + " days ago.";
					}
					else
					{
						def diffMonths = diff / (30 * 24 * 60 * 60 * 1000);
						if(diffMonths <= 6)
						{
							timeToString = Math.round(diffMonths) + " months ago.";
						}
						else
						{
							timeToString = "6 or more months ago";
						}
					}
				}
			}
		}

		return timeToString;
	}
}
