package fr.ncg.mygardenguardian.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.ncg.mygardenguardian.business.impl.UtilisateurLoginManager;

@Configuration
public class MyGardenGuardianConfiguration extends WebSecurityConfigurerAdapter {

	private UtilisateurLoginManager user;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests().antMatchers("/login", "/home", "/about").permitAll();
		http.authorizeRequests().antMatchers("/accueil").access("hasAnyRole('ROLE_Administrateur', 'ROLE_Jardinier')");
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_Administrateur')");

		http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_Jardinier')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().and().formLogin().loginPage("/login").defaultSuccessUrl("/accueil")
				.failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password")
				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
		// .permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedHandler(this.accessDeniedHandler);
	}

	// create two users, admin and user
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// System.out.println("CTRL config userDetailsService " + this.user.toString());
	// auth.userDetailsService(this.user).passwordEncoder(this.passwordEncoder());
	// auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("Jardinier").and()
	// .withUser("admin").password("password").roles("Administrateur");
	// // auth.jdbcAuthentication().w
	// }

	// @Bean
	// public DaoAuthenticationProvider authProvider() throws Exception {
	// DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	// authProvider.setUserDetailsService(this.user);
	// authProvider.setPasswordEncoder(this.passwordEncoder());
	// return authProvider;
	// }

	public UtilisateurLoginManager getUser() {
		return this.user;
	}

	@Autowired
	public void setUser(UtilisateurLoginManager user) {
		this.user = user;
	}
}
