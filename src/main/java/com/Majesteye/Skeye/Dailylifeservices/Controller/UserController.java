package com.Majesteye.Skeye.Dailylifeservices.Controller;
import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityUser;
import com.Majesteye.Skeye.Dailylifeservices.Repository.UserRepository;
import com.Majesteye.Skeye.Dailylifeservices.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserRepository repo;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/register")
    public EntityUser RegisterUser(@RequestBody EntityUser user){

        String requestEmail = user.getEmail();
        if (requestEmail != null && !"".equals(requestEmail)) {
            EntityUser userObj = service.fetchUserByEmail(requestEmail);
            if (userObj != null) {
                throw new IllegalStateException("E-mail already exists");
            }
        }

        String requestUsername = user.getUsername();
        if (requestUsername != null && !"".equals(requestUsername)) {
            EntityUser userObj = service.fetchUserByUsername(requestUsername);
            if (userObj != null) {
                throw new IllegalStateException("Username already exists");
            }
        }

        String requestPassword = user.getPassword();
        if (requestPassword.isEmpty() || requestPassword.length() < 8 || requestPassword.length() > 256) {
            throw new IllegalStateException("Password must be >= 8 and <= 256");
        }

        EntityUser userObj = null;
        user.setPassword(encoder.encode(user.getPassword()));
        userObj = service.SaveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public EntityUser login(@RequestBody EntityUser user) throws Exception{
        EntityUser userObj = service.fetchUserByEmail(user.getEmail());

        if ( userObj == null || !encoder.matches(user.getPassword(), userObj.getPassword())) {
            throw new IllegalStateException("Bad credentials");
        }
        return userObj;
    }
    @GetMapping("/user")
    public List<EntityUser> findAll() {
        return this.repo.findAll();
    }

    @GetMapping("/user/{id}")
    public EntityUser findById(@PathVariable Integer id) throws Exception {
        return this.repo.findById(id).orElseThrow(() -> new Exception("no one exists"));
    }

    @PostMapping("/user")
    public EntityUser saveUser(@RequestBody EntityUser user) {
        return this.repo.save(user);
    }

    @PutMapping("/user/{id}")
    public EntityUser updateUserOrSave(@RequestBody EntityUser user) {
        return this.repo.findById(user.getId()).map(
                x -> {
                    x.setId(user.getId());
                    x.setEmail(user.getEmail());
                    x.setUsername(user.getUsername());
                    x.setPassword(user.getPassword());
                    x.setProfile(user.getProfile());
                    return repo.save(x);
                }).orElseGet(() -> {
            user.setId(user.getId());
            return repo.save(user);
        });
    }
    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Integer id){
        this.repo.deleteById(id);
    }

    @DeleteMapping("/user")
    public void deleteAll() {
        this.repo.deleteAll();
    }
}
