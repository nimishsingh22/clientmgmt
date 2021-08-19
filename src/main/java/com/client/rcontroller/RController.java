package com.client.rcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.entity.Client;
import com.client.service.ClientService;


@RestController
public class RController {
	@Autowired	
	 ClientService clientService;
	
	    @GetMapping("/clientlist")
	    public ResponseEntity<List<Client>> getAllStudent() {
	        List<Client> clientlist = clientService.getAllClients();
	        return new ResponseEntity<List<Client>>(clientlist , HttpStatus.OK);
	    }
}
