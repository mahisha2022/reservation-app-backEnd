package com.revature.Repository;

import com.revature.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String username);
    User findUserByUserNameAndPassword(String username, String password);
}
