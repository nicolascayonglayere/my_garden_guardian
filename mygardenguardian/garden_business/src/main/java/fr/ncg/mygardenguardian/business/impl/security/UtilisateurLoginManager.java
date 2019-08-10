package fr.ncg.mygardenguardian.business.impl.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		System.out.println("CTRL loadUser security -------------- "
				+ this.daoFacto.getUtilisateurDao().findByEmail(username).get().getIdUtilisateur() + " - " + username);
		Utilisateur appUser = this.daoFacto.getUtilisateurDao().findByEmail(username).get();

		if (appUser == null) {
			System.out.println("User not found! " + username);
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		System.out.println("Found User: " + appUser);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRole());
		grantList.add(authority);

		UserDetails userDetails = new GardenGuardianAppUser(appUser.getCoordonneeUtilisateur().getEmail(),
				appUser.getMdp(), appUser.getIdUtilisateur(), true, true, true, true, grantList);

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
