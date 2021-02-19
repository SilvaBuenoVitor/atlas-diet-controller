package com.example.atlas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.atlas.model.User;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    private List<User> users;
    // private int nextId = 1;
    
    @PostConstruct
    public void init(){
        User u1 = new User();
        u1.setId(0);
        u1.setEmail("email");
        u1.setPassword("password");

        User u2 = new User();
        u2.setEmail("email2");
        u2.setId(1);
        u2.setPassword("senha");

        users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
    }

    public int login(User login){
        for (User user : users) {
            if(user.getEmail().equals(login.getEmail()) && user.getPassword().equals(login.getPassword())){
                return user.getId();
            }
        }
        return -1;
    }
}
