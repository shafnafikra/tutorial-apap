package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user. setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new  BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDB.findAll();
    }

    @Override
    public UserModel deleteUser(UserModel user) {
        userDB.delete(user);
        return user;
    }

    @Override
    public UserModel getUserById(String id) {
        Optional<UserModel> user = userDB.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public boolean isMatch(String newPassword, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(newPassword, oldPassword);
    }

    @Override
    public void setPassword(UserModel user, String newPassword) {
        user.setPassword(newPassword);
    }

    @Override
    public UserModel getUserbyUsername(String username) {
        return userDB.findByUsername(username);
    }

    //Referensi:
    // https://stackoverflow.com/questions/11533474/java-how-to-test-if-a-string-contains-both-letter-and-number
    // https://stackoverflow.com/questions/1795402/check-if-a-string-contains-a-special-character
    @Override
    public String changePassword(UserModel user, String pass) {

        String numRegex   = ".*[0-9].*";
        String alphaRegex = ".*[a-zA-Z].*";
        String symRegex = ".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*";

        if (pass.length() >= 8){
            if(pass.matches(numRegex) && pass.matches(alphaRegex) && pass.matches(symRegex)) {
                String password = encrypt(pass);
                user.setPassword(password);
                userDB.save(user);
                return "Password successfully changed!";
            }
        }
        return "The password does not match the conditions, please try again";
    }
}
