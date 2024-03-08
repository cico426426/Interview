package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if(userRepository.findByPhoneNumber(user.getPhoneNumber())!=null){
            return ResponseEntity.badRequest().body("Error: Phone number is already in use!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRegistTime(new Timestamp(System.currentTimeMillis()));
        User saveUser = userRepository.save(user);
        return ResponseEntity.ok(saveUser);
    }
}
