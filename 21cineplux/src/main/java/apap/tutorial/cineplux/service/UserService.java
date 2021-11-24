package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser();
    UserModel deleteUser(UserModel user);
    UserModel getUserById(String id);
    boolean isMatch(String newPassword, String oldPassword);
    void setPassword(UserModel user, String newPassword);
    UserModel getUserbyUsername(String username);
    String changePassword(UserModel user, String pass);
}
