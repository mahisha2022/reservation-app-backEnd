package com.revature.Controller;

import com.revature.Model.User;
import com.revature.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * as a user, I want to create an account
     * as a user, I want to login into my account
     */


    /**
     * Create a new user
     * @param user
     * @return
     */
    @PostMapping("users/signup")
    public User createUser(@RequestBody User user){
      return   userService.create(user);
    }

    /**
     * User Login
     * @param username
     * @param password
     * @return
     */
    @PostMapping("users/login")
    public User userLogin(@RequestParam String username, @RequestParam String password){
       return userService.login(username, password);
    }


}
