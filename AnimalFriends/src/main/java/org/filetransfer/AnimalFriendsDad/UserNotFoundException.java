package org.filetransfer.AnimalFriendsDad;

public class UserNotFoundException extends RuntimeException {

	  UserNotFoundException(Long id) {
	    super("Could not find user " + id);
	  }

}
