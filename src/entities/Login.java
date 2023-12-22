package entities;

public class Login {
	private String hashedPassword;
	private String username;

	public Login() {}
	
	public Login(String hashedPassword, String username) {
		this.hashedPassword = hashedPassword;
		this.username = username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void changePassword(String oldPass, String newPass) throws PasswordsDoNotMatchException, WeakPasswordException {
		if (PasswordUtils.checkPassword(oldPass, hashedPassword)) {
			if(PasswordUtils.isStrongPassword(newPass)) {
				hashedPassword = PasswordUtils.hashPassword(newPass);
			}
			else {
				throw new WeakPasswordException("The password must have at least 8 letters, upper case letter(s) and digit(s)");
			}
		}else{
			throw new PasswordsDoNotMatchException("The password do not match!!!");
		};
	}

}
