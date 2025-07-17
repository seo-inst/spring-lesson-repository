package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	public void register() {
		System.out.println("core register user");
	}
	public String getNick() {
		return "손흥민";
	}
}
