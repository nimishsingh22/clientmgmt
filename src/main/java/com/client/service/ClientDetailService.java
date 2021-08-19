package com.client.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.client.entity.Client;
import com.client.entity.Role;

@Service
public class ClientDetailService implements UserDetailsService{
	@Autowired
ClientService clientService ;
	
	 @Transactional
	 @Override
		public UserDetails loadUserByUsername(String email) {
		try {
		 Client client = clientService.findClientByEmail(email);
		 if(client !=null) {
	        List<GrantedAuthority> authorities = getUserAuthority(client.getRoles());
			return buildUserForAuthentication(client, authorities);
		 }
		}
		catch(UsernameNotFoundException e) {
		e.printStackTrace();	
		}
		return null;
		}
	   
	 
	 public List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
	        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
	        for (Role role : userRoles) {
	            roles.add(new SimpleGrantedAuthority(role.getRole()));
	            System.out.println(role.toString());
	        }
	        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	        return grantedAuthorities;
	 }
	 
	 @SuppressWarnings("unused")
	private UserDetails buildUserForAuthentication(Client client, List<GrantedAuthority> authorities) {
	        return new org.springframework.security.core.userdetails.User(client.getEmail(), client.getPassword(),
	                client.getActive(), true, true, true, authorities);
	    }

	
}
