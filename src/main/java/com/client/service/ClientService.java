package com.client.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.client.entity.Client;
import com.client.entity.Role;
import com.client.repo.ClientRepository;
import com.client.repo.RoleRepository;

@Service
public class ClientService  {
	private ClientRepository clientRepository;
	private RoleRepository roleRepository;
	@Autowired
	ClientService(ClientRepository clientRepository,RoleRepository roleRepository){
		this.roleRepository=roleRepository;
		this.clientRepository=clientRepository;
	}
	
	public Client findClientByEmail(String email) {
		return clientRepository.findByEmail(email);
	}
	
	public Client saveClient(Client client) {
		 client.setPassword(client.getPassword());
		client.setActive(true);
		Role role= roleRepository.findByRole("ADMIN");
		System.out.println("Role is  "+role.toString());
		Set<Role> a=new HashSet<>();
		a.add(role);
		client.setRoles(a);
		return clientRepository.save(client);
	}
	
	public List<Client> getAllClients(){
		List<Client> clientList = clientRepository.findAll();
		if(clientList.size()>0) {
			return clientList;
		}
		else {
			return new ArrayList<>();
		}
	}
}
