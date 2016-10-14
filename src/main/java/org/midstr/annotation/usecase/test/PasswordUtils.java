package org.midstr.annotation.usecase.test;

import java.util.List;

import org.midstr.annotation.usecase.SimulatingNull;
import org.midstr.annotation.usecase.UseCase;

public class PasswordUtils {

	@UseCase(id = 10, description = "password must contain at least one numeric")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}

	@UseCase(id = 11)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}

	@UseCase(id = 12, description = "New password can't equal previously used one")
	@SimulatingNull
	public boolean checkForNewPassword(List<String> prevPasswords,
			String password) {
		return !prevPasswords.contains(password);
	}
}
