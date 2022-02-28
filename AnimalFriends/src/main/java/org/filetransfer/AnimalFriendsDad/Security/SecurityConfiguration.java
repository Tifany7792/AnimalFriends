package org.filetransfer.AnimalFriendsDad.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
		
		//Paginas publicas -- añadir todas las paginas publicas
		http.authorizeRequests().antMatchers("/").permitAll();
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
		
		
		
		
		//paginas privadas -- se añaden automaticamente
		http.authorizeRequests().anyRequest().authenticated();
		
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
		http.csrf().disable();
	}
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// User
		auth.inMemoryAuthentication()
		.withUser("Jose").password("1234").roles("USER");
		
		auth.inMemoryAuthentication().withUser("admin").password("adminpass").roles("USER","ADMIN");

	}
	
	
	
	

}
