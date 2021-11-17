package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

//    @RequestMapping("/")
//    public String home(){
//        return "home";
//    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String home(HttpServletRequest httpsr, Model model){
        Principal princ = httpsr.getUserPrincipal();
        String role = userService.getUserbyUsername(princ.getName()).getRole().getRole();
        model.addAttribute("role", role);
        return "home";
    }
}