package ba.posao.models;

import java.io.Serializable;

public class PasswordDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
