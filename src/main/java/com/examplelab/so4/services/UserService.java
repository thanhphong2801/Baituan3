package com.examplelab.so4.services;

import com.examplelab.so4.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examplelab.so4.enity.User;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user)
    {
        userRepository.save(user);
    }
}
