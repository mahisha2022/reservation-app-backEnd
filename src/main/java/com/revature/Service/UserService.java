package com.revature.Service;

import com.revature.Model.User;
import com.revature.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SplittableRandom;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Create a User
     * @param user
     * @return
     */
   public User create(User user){
       //check if the username already exists
       if(userRepository.findUserByUserName(user.getUsername()) != null){
           return null;
       }
       return userRepository.save(user);
   }

    /**
     * User login
     * @param username
     * @param password
     * @return
     */
   public User login(String username, String password){
       User user = userRepository.findUserByUserNameAndPassword(username, password);
       if (user == null){
           return null;
       }
       return user;
   }

    public boolean userAuthenticate(String username, String password){
        User user = userRepository.findUserByUserName(username);
        if(user != null && user.getPasswd().equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
}
