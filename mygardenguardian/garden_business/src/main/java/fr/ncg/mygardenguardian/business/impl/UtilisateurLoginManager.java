package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.entites.Utilisateur;

@Service
public class UtilisateurLoginManager implements UserDetailsService {

	private IDaoFactory daoFacto;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur appUser = this.daoFacto.getUtilisateurDao().findByNom(username);

		if (appUser == null) {
			System.out.println("User not found! " + username);
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		System.out.println("Found User: " + appUser);

		// [ROLE_USER, ROLE_ADMIN,..]
		// List<String> roleNames = appUser.getRole();

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		// if (roleNames != null) {
		// for (String role : roleNames) {
		// ROLE_USER, ROLE_ADMIN,..
		GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRole());
		grantList.add(authority);
		// }
		// }
		// User.UserBuilder = User.withDefaultPasswordEncoder();
		// PasswordEncoder encoder =
		// PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails userDetails = new User(appUser.getNom(), (appUser.getMdp()), grantList);
		System.out.println(("CTRL userDetails " + userDetails.toString()));
		return userDetails;
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
