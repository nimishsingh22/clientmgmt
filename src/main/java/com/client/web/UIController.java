package com.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.client.entity.Client;
import com.client.service.ClientService;

@Controller
public class UIController {
	@Autowired
	ClientService  clientService ;
	
	@GetMapping("/signup")
    public ModelAndView getSignup(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup");
        return modelAndView;
    }
	@PostMapping("/signup")
	 public ModelAndView createClient( Client client, BindingResult bindingResult) {
	        ModelAndView modelAndView = new ModelAndView();
	        if(client.getEmail()=="" || client.getName()=="" || client.getPassword()=="") {
	        	/* bindingResult.rejectValue("error.empty",
                         "Please fill all the entries");*/
	        	 modelAndView.addObject("errormessage", "Please fill all the entries");
	        	  modelAndView.setViewName("signup");
	        }
	        try{
	       Client cl=clientService.findClientByEmail(client.getEmail());
	       
	        if (cl != null) {
	            bindingResult.rejectValue("email", "error.email",
	                            "There is already a user registered with this email id");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("signup");
	        } else {
	        	Client c = clientService.saveClient(client);
	            modelAndView.addObject("successMessage", "User has been registered successfully");
	            modelAndView.addObject("user", new Client());
	            modelAndView.setViewName("signup");
	        }
	        }
	        catch(Exception e) {
	        	System.out.println(e.getStackTrace()+"  enter all data");
	        	
	        }
	       
	        return modelAndView;
	    }
/*	@PostMapping("/signup")
	public String createClient(Client client,Map<String, Object> model) {
		if(client.getEmail()=="" || client.getName()=="" || client.getPassword()=="") {
			model.put("emptyerror", "Please fill all the entries ");
			//System.out.println("Please fill all the entries ");
			return "signup";   
		}
		try {
			Client cl=clientService.findClientByEmail(client.getEmail());
			if(cl != null) {
				model.put("emptyerror", "Please choose another email id");
			}
			else {
			Client c = clientService.saveClient(client);
			System.out.println(c);
			model.put("success", "You have been Registered.Please sign in ");
			return "signup";
		}
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	return "signup";
		
	}
	*/
	
	
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
	


