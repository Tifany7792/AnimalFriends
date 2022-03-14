package org.filetransfer.AnimalFriendsDad.Security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//@Autowired
	//public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Autowired
	RepositoryUserDetailsService userDetailsService;
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
		
		//Paginas publicas -- añadir todas las paginas publicas
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/principal").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginUsuario").permitAll();
		http.authorizeRequests().antMatchers("/registrar").permitAll();
		http.authorizeRequests().antMatchers("/registrarUsuario").permitAll();
		http.authorizeRequests().antMatchers("/animales").permitAll();
		http.authorizeRequests().antMatchers("/localizaciones").permitAll();
		http.authorizeRequests().antMatchers("/productos").permitAll();
		http.authorizeRequests().antMatchers("/animal/{{id}}").permitAll();
		http.authorizeRequests().antMatchers("/local/{{id}}").permitAll();
		http.authorizeRequests().antMatchers("/prod/{{id}}").permitAll();
		http.authorizeRequests().antMatchers("/plantilla.css").permitAll();
		http.authorizeRequests().antMatchers("/estilos.css").permitAll();
		http.authorizeRequests().antMatchers("/fondo.jpg").permitAll();
		http.authorizeRequests().antMatchers("/main.js").permitAll();
		http.authorizeRequests().antMatchers("/indexPrueba").permitAll();
		
		//paginas privadas -- se añaden automaticamente
		http.authorizeRequests().anyRequest().authenticated();
		//http.authorizeRequests().antMatchers("/").hasAnyRole("USER");

		
		//  login
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("nombre");
		http.formLogin().passwordParameter("psw");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/login");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");
		
		// Disable CSRF at the moment
		//http.csrf().disable();
	}
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// User
		/*auth.inMemoryAuthentication()
		.withUser("Jose").password("1234").roles("USER");
		
		auth.inMemoryAuthentication().withUser("admin").password("adminpass").roles("USER","ADMIN");
*/
		//auth.authenticationProvider(authenticationProvider);
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	
	

}
