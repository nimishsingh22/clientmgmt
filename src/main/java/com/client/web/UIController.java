package com.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.client.entity.Client;
import com.client.service.ClientService;

@Controller
public class UIController {
	@Autowired
	ClientService  clientService ;
	
	@Autowired
	SignupValidator  signupValidator ;

	@GetMapping("/signup")
    public ModelAndView getSignup(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientForm", new Client());
        modelAndView.setViewName("signup");
        return modelAndView;
    }
	@PostMapping("/signup")
	 public ModelAndView createClient(@ModelAttribute("clientForm")  Client client, BindingResult bindingResult) {
	        ModelAndView modelAndView = new ModelAndView();
	        signupValidator.validate(client, bindingResult);
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("signup");
	        } else {
	        	Client c = clientService.saveClient(client);
	            modelAndView.addObject("successMessage", "User has been registered successfully");
	            modelAndView.addObject("clientForm", new Client());
	            modelAndView.setViewName("signup");
	        }
	     
	        return modelAndView;
	    }

	
	
	@GetMapping("/signin")
	    public ModelAndView registration(){
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("signin");
	        return modelAndView;
	    }

	@GetMapping("/admin/home")
		  public ModelAndView home(@RequestParam("error") String error){
		System.out.println(error +" occured");
		        ModelAndView modelAndView = new ModelAndView();
		        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		        Client client = clientService.findClientByEmail(auth.getName());
		      
		        //modelAndView.addObject("userName", "Welcome " + client.getEmail() + "/" + client.getName() + " " + " (" + client.getPassword() + ")");
		       modelAndView.addObject("userName",client.getName());
		        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		        modelAndView.setViewName("home");
		        return modelAndView;
		    }
	    
}
	


