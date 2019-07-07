package fr.ncg.mygardenguardian.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import fr.ncg.mygardenguardian.business.impl.security.UtilisateurLoginManager;

@Configuration
public class MyGardenGuardianConfiguration extends WebSecurityConfigurerAdapter {

	private UtilisateurLoginManager user;

	private AuthenticationSuccessHandler authenticationSuccessHandler;

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
		http.authorizeRequests().antMatchers("/modif_mdp")
				.access("hasAnyRole('ROLE_Administrateur', 'ROLE_Jardinier')");
		http.authorizeRequests().antMatchers("/static/**")
				.access("hasAnyRole('ROLE_Administrateur', 'ROLE_Jardinier')");
		http.authorizeRequests().antMatchers("/culture/**")
				.access("hasAnyRole('ROLE_Administrateur', 'ROLE_Jardinier')");
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_Administrateur')");

		http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_Jardinier')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/accueil")
				// .successHandler(this.authenticationSuccessHandler)//
				.failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password")
				// Config for Logout Page
				.and().logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/login");
		// .permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedHandler(this.accessDeniedHandler);
	}

//	@Bean
//	public FormattingConversionService conversionService() {
//		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
//
//		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
//		registrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//		registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//		registrar.registerFormatters(conversionService);
//
//		// other desired formatters
//
//		return conversionService;
//	}

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

	public AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
		return this.authenticationSuccessHandler;
	}

	@Autowired
	public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler authenticationSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}
}
