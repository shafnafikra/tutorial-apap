package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user" ;
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String viewAllUser(
            Model model
    ){
        model.addAttribute("listUser", userService.getListUser());
        return "view-all-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(
            @PathVariable String id,
            Model model
    ) {
        UserModel user = userService.getUserById(id);
        model.addAttribute("user", user);

        if (userService.getListUser().contains(user)) {
            userService.deleteUser(user);
            return "delete-user";
        }
        return "null-user";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    private String updatePasswordForm(
            Model model){
        return "change-password";
    }

//    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
//    public String changePassword(@ModelAttribute UserModel userModel, String newPassword, String confPassword, Model model){
//        UserModel user = userService.getUserbyUsername(userModel.getUsername());
//
//        if (userService.isMatch(userModel.getPassword(), user.getPassword())){
//            if (newPassword.equals(confPassword)){
//                userService.setPassword(user, newPassword);
//                userService.addUser(user);
//                model.addAttribute("message", "password berhasil diubah");
//            }else {
//                model.addAttribute("message", "password tidak sama");
//            }
//        }else {
//            model.addAttribute("message", "password salah");
//        }
//        return "home";
//    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String changePasswordSubmit(
            @RequestParam(value = "passwordOld") String passwordOld,
            @RequestParam(value = "passwordNew") String passwordNew,
            @RequestParam(value = "passwordNew2") String passwordNew2,
            HttpServletRequest request,
            RedirectAttributes attributes,
            Model model
    ) {
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUserbyUsername(principal.getName());
        if(!passwordNew.equals(passwordNew2)){
            model.addAttribute("alert", "The new password doesn't match, please re-enter");
            return "change-password";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(passwordOld, user.getPassword())){
            String a = userService.changePassword(user, passwordNew);
            attributes.addFlashAttribute("alert", a);
            return "redirect:/user/updatePassword";
        }
        else{
            model.addAttribute("alert", "Password lama salah, mohon input ulang");
            return "change-password";
        }
    }
}
