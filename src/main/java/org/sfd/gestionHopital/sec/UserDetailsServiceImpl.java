
package org.sfd.gestionHopital.sec;

import java.util.ArrayList;
import java.util.Collection;

import org.sfd.gestionHopital.entities.Utilisateur;
import org.sfd.gestionHopital.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur u = accountService.loadUserByLoging(username);
		if (u == null)
			throw new UsernameNotFoundException("Utilisateur invalid");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		u.getRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getLibelle()));
		});
		return new User(u.getUsername(), u.getPassword(), authorities);
	}

}
