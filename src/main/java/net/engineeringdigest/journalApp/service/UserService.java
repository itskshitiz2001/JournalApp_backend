package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component
public class UserService{

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public static final Logger logger= LoggerFactory.getLogger(UserService.class);

    public void saveNewUser(User user)
    {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            logger.info("Saved new user Successfully!");
        }catch(Exception e)
        {
            logger.info("Some error occured while saving user");
        }
    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> findbyId(ObjectId id)
    {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId myId)
    {
        userRepository.deleteById(myId);
    }

    public User findByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }
}
