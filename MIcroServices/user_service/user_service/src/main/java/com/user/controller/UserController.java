package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {

        User user = this.userService.getUser(userId);
        //http://localhost:9002/contact/user/1311

        List contacts = this.restTemplate.getForObject("http://localhost:9002/contact/user/" + user.getUserId(), List.class);
        
        List addresses = this.restTemplate.getForObject("http://localhost:9003/address/user/" + user.getUserId(),  List.class);
    	
    	user.setAddress(addresses);

        
        user.setContacts(contacts);
        return user;

    }
    
    @PostMapping("/post")
    public void postUser(@RequestBody User user)
    {
		this.userService.postUser(user);
		
    	
    }
    
   

}
