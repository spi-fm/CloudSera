package es.uca.pfc

class UserMendeley {

	static belongsTo = [user: User]

	String email_mend
	String pass_mend
	String access_token = "";
	String token_type = "";
	String expires_in = "";
	String refresh_token = "";

    static constraints = {
			access_token(size:0..255)
			email_mend(size:0..255)
			expires_in(size:0..255)
			pass_mend(size:0..255)
			refresh_token(size:0..255)
			token_type(size:0..255)
    }
}
