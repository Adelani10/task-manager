package com.ade.taskmanager.services;
import com.ade.taskmanager.models.User;
import com.ade.taskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getUsers () {
        return userRepo.findAll();
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }

    public boolean deleteUser(Long id) {
        if(!userRepo.existsById(id)){
            return false;
        }
        userRepo.deleteById(id);
        return true;
    }
}
