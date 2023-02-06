package com.Majesteye.Skeye.Dailylifeservices.Services;

import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityUser;
import com.Majesteye.Skeye.Dailylifeservices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public EntityUser SaveUser(EntityUser user){
             return repo.save(user);
    }

    public EntityUser fetchUserByEmail(String email){
        return repo.findByEmail(email);
    }

    public EntityUser fetchUserByUsername(String username){
        return repo.findByUsername(username);
    }

}
