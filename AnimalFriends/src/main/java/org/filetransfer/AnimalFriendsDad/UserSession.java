package org.filetransfer.AnimalFriendsDad;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {

	private String user;
	private int numAnimals;

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public int getNumAnimals() {
		return this.numAnimals;
	}

	public void incNumAnimals() {
		this.numAnimals++;
	}

}