package org.filetransfer.AnimalFriendsDad.Security;

import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private RepositorioUsuarios userRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		Optional<Usuarios> user = userRepository.findByNombre(auth.getName());

		if (user == null) {
			throw new BadCredentialsException("Usuario no encontrado");
		}
		String password = (String) auth.getCredentials();
		if (!new BCryptPasswordEncoder().matches(password, user.get().getPasword())) {
			throw new BadCredentialsException("Wrong password");
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.get().getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return new UsernamePasswordAuthenticationToken(user.get().getNombre(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
