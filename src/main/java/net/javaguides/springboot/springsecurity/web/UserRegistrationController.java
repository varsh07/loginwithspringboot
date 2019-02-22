package net.javaguides.springboot.springsecurity.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.UserLoginDto;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	
	
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
    @ModelAttribute("user1")
    public UserLoginDto userloginDto() {
        return new UserLoginDto();
    }
    
    
    
    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

   
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto
                                      ){
    	
        User existing = userService.findByEmail(userDto.getEmail());
        
       

        userService.save(userDto);
    	  	
        return "redirect:/registration?success";
        
        
        
    }
    
    @PostMapping("/login")
	public String postCustomer(@ModelAttribute("user1")  @Valid UserLoginDto userlogDto) {
 
    	userService.save(userlogDto);
		return "redirect:/index?success";
	}
  

}
