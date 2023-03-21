package com.revature.Service;

import com.revature.Model.User;
import com.revature.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.SplittableRandom;

public class UserService {

    @Autowired
    private UserRepository userRepository;

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
